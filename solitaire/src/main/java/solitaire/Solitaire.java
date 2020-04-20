package solitaire;

import java.util.Arrays;

public class Solitaire 
{
    public String Message;
    public GenerateKey Key;
    public Message CleanMessage;
    
    public Solitaire (String message, GenerateKey key, Message cleanMessage)
    {
        Message = message;  
        Key = key;
        CleanMessage = cleanMessage; 
    }

    public String mEncryptMessage()
    {
        Message = CleanMessage.mClean();
        if(Message.length() == 0){
            return "";
        }

        //GETTING KEY EQUAL TO LENGTH OF STRING
        String message = Message.replaceAll("\\s+", "");
        String generatedKey = Key.mGenerateKey(message);

        //CONVERT MESSAGE AND KEY TO NUMBERS
        int[] keyArray = new int[generatedKey.length()];
        int[] messageArray = new int[Message.length()];
        messageArray = CleanMessage.mConvertsToNumber();
        keyArray = mConvertsKeyToNumber(generatedKey);

        //ADDING MESSAGE AND KEY ARRAY VALUES
        int[] encryptMessageArray = new int[Message.length()];
        for (int i = 0; i < generatedKey.length(); i++) {
            encryptMessageArray[i] = messageArray[i] + keyArray[i];
        }

        //GENERATING ENCRYPTED MESSAGE
        String encryptMessage = CleanMessage.mConvertsNumberToMessage(encryptMessageArray);
        encryptMessage = encryptMessage.replaceAll("[^\\p{L}\\p{Z}]","");
        return encryptMessage;
    }

    //decrypt
    public String mDecryptMessage()
    {
        if(Message.length() == 0){
            return "";
        }

        String generatedKey = Key.mGenerateKey(Message);
        
        //CONVERT MESSAGE AND KEY TO NUMBERS
        int[] keyArray = new int[generatedKey.length()];
        int[] messageArray = new int[Message.length()];
        messageArray = CleanMessage.mConvertsToNumber();
        keyArray = mConvertsKeyToNumber(generatedKey);

        System.out.println(Arrays.toString(messageArray));
        System.out.println(Arrays.toString(keyArray));


        int[] decryptMessageArray = new int[Message.length()];
        for (int i = 0; i < generatedKey.length(); i++) {
            decryptMessageArray[i] = messageArray[i] - keyArray[i];
        }
        String decryptMessage = CleanMessage.mConvertsNumberToMessage(decryptMessageArray);
        return decryptMessage;
    }

    private int[] mConvertsKeyToNumber(String key)
    {
        if(key.isEmpty())
        {
            return new int[0];
        }

        int[] numbers = new int[key.length()];
        char[] values = key.toCharArray();
        for (int i = 0; i < values.length; i++) {
            int number = values[i] - 'A' +1;
            numbers[i] = number;
        }
        return numbers;
    }
}