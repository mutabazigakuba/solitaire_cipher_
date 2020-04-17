package solitaire;

public class Encrypt
{
    public String mEncryptMessage(int[] message, int[] key)
    {
        if(message.length == 0){
            return "";
        }
        int[] encryptMessageArray = new int[message.length];
        for (int i = 0; i < key.length; i++) {
            encryptMessageArray[i] = message[i] +key[i];
        }
        String encryptMessage = "";
        for (int number : encryptMessageArray) 
        {
            encryptMessage +=  String.valueOf((char)(64 + number));
        }
        return encryptMessage;
    }
}