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
        messageArray = CleanMessage.mConvertsToNumber();
        keyArray = mConvertsKeyToNumber(generatedKey);

        int[] encryptMessageArray = new int[Message.length()];
        for (int i = 0; i < generatedKey.length(); i++) 
        {
            encryptMessageArray[i] = messageArray[i] + keyArray[i];
        }

        String encryptMessage = CleanMessage.mConvertsNumberToMessage(encryptMessageArray);
        encryptMessage = encryptMessage.replaceAll("[^\\p{L}\\p{Z}]","");
        return encryptMessage;
    }

    //decrypt
    public String mDecryptMessage()
    {
        if(Message.length() == 0)
        {
            return "";
        }

        String generatedKey = Key.mGenerateKey(Message);
        

        int[] keyArray = new int[generatedKey.length()];
        int[] messageArray = new int[Message.length()];
        messageArray = CleanMessage.mConvertsToNumber();
        keyArray = mConvertsKeyToNumber(generatedKey);

        int[] decryptMessageArray = new int[Message.length()];
        for (int i = 0; i < generatedKey.length(); i++) 
        {
            decryptMessageArray[i] = messageArray[i] - keyArray[i];
        }
        return CleanMessage.mConvertsNumberToMessage(decryptMessageArray);
    }

    private static int[] mConvertsKeyToNumber(String key)
    {
        if(key.isEmpty())
        {
            return new int[0];
        }

        int[] numbers = new int[key.length()];
        char[] values = key.toCharArray();
        for (int i = 0; i < values.length; i++) 
        {
            int number = values[i] - 'A' +1;
            numbers[i] = number;
        }
        return numbers;
    }
}