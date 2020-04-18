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

        int[] encryptMessageArray = new int[Message.length()];
        
        for (int i = 0; i < key.length(); i++) {
            encryptMessageArray[i] = Message[i] + key[i];
        }
        String encryptMessage = "";
        for (int number : encryptMessageArray) 
        {
            encryptMessage +=  String.valueOf((char)(64 + number));
        }
        return encryptMessage;
    }
    public String mDencryptMessage(int[] message)
    {
        if(message.length == 0){
            return "";
        }
        int[] encryptMessageArray = new int[message.length];
        for (int i = 0; i < key.length; i++) {
            if(message[i] <= key[i])
            {
               encryptMessageArray[i] = (message[i] + 26) - key[i];
            }
            encryptMessageArray[i] = message[i] - key[i];
        }
        String encryptMessage = "";
        for (int number : encryptMessageArray) 
        {
            encryptMessage +=  String.valueOf((char)(64 + number));
        }
        return encryptMessage;
    }
}