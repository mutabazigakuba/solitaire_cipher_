package solitaire;

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

        String key = Key.mGenerateKey(Message);
        char[] keyArray = new char[key.length()];
        for (int i = 0; i < key.length(); i++) {
            keyArray[i] = key.charAt(i);
        }

        char[] messageArray = new char[Message.length()];
        for (int i = 0; i < Message.length(); i++) {
            messageArray[i] = Message.charAt(i);
        }

        int[] encryptMessageArray = new int[Message.length()];
        
        for (int i = 0; i < key.length(); i++) {
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

        String key = Key.mGenerateKey(Message);
        char[] keyArray = new char[key.length()];
        for (int i = 0; i < key.length(); i++) {
            keyArray[i] = key.charAt(i);
        }

        char[] messageArray = new char[Message.length()];
        for (int i = 0; i < Message.length(); i++) {
            messageArray[i] = Message.charAt(i);
        }

        int[] encryptMessageArray = new int[Message.length()];
        for (int i = 0; i < key.length(); i++) {
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