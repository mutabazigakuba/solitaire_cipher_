package solitaire;

public class Dencrypt
{
    public String mDencryptMessage(int[] message, int[] key)
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