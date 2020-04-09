package solitaire;

public class Key 
{
    public String mGenerateKey(int keyLength)
    {
        if(keyLength < 1)
        {
            return "";
        }
        String generateKey = "hello";
        if(generateKey.length() == keyLength)
        {
            return "hello";
        }
        return generateKey;
    }
} 