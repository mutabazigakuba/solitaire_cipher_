package solitaire;

public class Solitaire 
{
    private GenerateKey Key;
    private Message Message;
    
    public Solitaire (GenerateKey key, Message message)
    {
        Key = key;
        Message = message; 
    }

    public String mEncryptMessage()
    {
        String message = Message.mClean();
        if(message.length() == 0)
        {
            return "";
        }

        String generatedKey = Key.mGenerateKey(message);

        int[] keyArray = new int[generatedKey.length()];
        int[] messageArray = new int[message.length()];

        messageArray = mConvertsToArrayOfNumber(message);
        keyArray = mConvertsToArrayOfNumber(generatedKey);

        int[] encryptMessageArray = new int[message.length()];
        for (int i = 0; i < generatedKey.length(); i++) 
        {
            encryptMessageArray[i] = messageArray[i] + keyArray[i];
        }
        return Message.mConvertsNumberToMessage(encryptMessageArray);
    }

    public String mDecryptMessage()
    {
        String message = Message.mClean();
        if(message.length() == 0)
        {
            return "";
        }

        String generatedKey = Key.mGenerateKey(message);
        
        int[] keyArray = new int[generatedKey.length()];
        int[] messageArray = new int[message.length()];

        messageArray = mConvertsToArrayOfNumber(message);
        keyArray = mConvertsToArrayOfNumber(generatedKey);

        int[] decryptMessageArray = new int[message.length()];
        for (int i = 0; i < generatedKey.length(); i++) 
        {
            decryptMessageArray[i] = messageArray[i] - keyArray[i];
        }
        return Message.mConvertsNumberToMessage(decryptMessageArray);
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