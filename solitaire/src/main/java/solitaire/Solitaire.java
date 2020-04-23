package solitaire;

public class Solitaire 
{
    private String Message;
    private GenerateKey Key;
    private Message CleanMessage;
    
    public Solitaire (String message, GenerateKey key, Message cleanMessage)
    {
        Message = message;  
        Key = key;
        CleanMessage = cleanMessage; 
    }

    public String mEncryptMessage()
    {
        Message = CleanMessage.mClean();
        if(Message.length() == 0)
        {
            return "";
        }

        String message = Message.replaceAll("\\s+", "");
        String generatedKey = Key.mGenerateKey(message);

        int[] keyArray = new int[generatedKey.length()];
        int[] messageArray = new int[Message.length()];

        messageArray = mConvertsToArrayOfNumber(message);
        keyArray = mConvertsToArrayOfNumber(generatedKey);

        int[] encryptMessageArray = new int[message.length()];
        for (int i = 0; i < generatedKey.length(); i++) 
        {
            encryptMessageArray[i] = messageArray[i] + keyArray[i];
        }
        return CleanMessage.mConvertsNumberToMessage(encryptMessageArray);
    }

    public String mDecryptMessage()
    {
        if(Message.length() == 0)
        {
            return "";
        }

        String generatedKey = Key.mGenerateKey(Message);
        
        int[] keyArray = new int[generatedKey.length()];
        int[] messageArray = new int[Message.length()];

        messageArray = mConvertsToArrayOfNumber(Message);
        keyArray = mConvertsToArrayOfNumber(generatedKey);

        int[] decryptMessageArray = new int[Message.length()];
        for (int i = 0; i < generatedKey.length(); i++) 
        {
            decryptMessageArray[i] = messageArray[i] - keyArray[i];
        }
        return CleanMessage.mConvertsNumberToMessage(decryptMessageArray);
    }

    private int[] mConvertsToArrayOfNumber(String string)
    {
        if(string.isEmpty())
        {
            return new int[0];
        }

        int[] numbers = new int[string.length()];
        char[] values = string.toCharArray();
        for (int i = 0; i < values.length; i++) 
        {
            int number = values[i] - 'A' +1;
            numbers[i] = number;
        }
        return numbers;
    }
}