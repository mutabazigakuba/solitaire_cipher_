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
        String message = Message.replaceAll("\\s+", "");
        String generatedKey = Key.mGenerateKey(message);

        int[] keyArray = new int[generatedKey.length()];
        int[] messageArray = new int[Message.length()];

        //CONVERT MESSAGE AND KEY TO NUMBERS
        
        for (int i = 0; i < generatedKey.length(); i++) {
            keyArray[i] = generatedKey.charAt(i);
        }
        for (int i = 0; i < Message.length(); i++) {
            messageArray[i] = Message.charAt(i);
        }
        int[] encryptMessageArray = new int[Message.length()];
        for (int i = 0; i < generatedKey.length(); i++) {
            encryptMessageArray[i] = messageArray[i] + keyArray[i];
        }
        String encryptMessage = "";
        for (int number : encryptMessageArray) 
        {
            encryptMessage +=  String.valueOf((char)(64 + number));
        }
        return encryptMessage;
    }
    public String mDencryptMessage()
    {
        if(Message.length() == 0){
            return "";
        }

        String generatedKey = Key.mGenerateKey(Message);
        char[] keyArray = new char[generatedKey.length()];
        for (int i = 0; i < generatedKey.length(); i++) {
            keyArray[i] = generatedKey.charAt(i);
        }

        char[] messageArray = new char[Message.length()];
        for (int i = 0; i < Message.length(); i++) {
            messageArray[i] = Message.charAt(i);
        }

        int[] encryptMessageArray = new int[Message.length()];
        for (int i = 0; i < generatedKey.length(); i++) {
            if(messageArray[i] <= keyArray[i])
            {
               encryptMessageArray[i] = (messageArray[i] + 26) - keyArray[i];
            }
            encryptMessageArray[i] = messageArray[i] - keyArray[i];
        }
        String encryptMessage = "";
        for (int number : encryptMessageArray) 
        {
            encryptMessage +=  String.valueOf((char)(64 + number));
        }
        return encryptMessage;
    }
}