package solitaire;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EncryptTest
{

    @Test
    public void encryptClassShouldBeCreated()
    {
        Converter encrypt = new Converter();

        assertEquals(true, encrypt instanceof Converter);
    }

    @Test
    public void messageShouldBeGivenNumbers()
    {
        Converter encrypt = new Converter();
        int[] message = new int[0];

        String expectedMessage = "";
        String actualMessage = encrypt.mEncryptMessage( new int[0], message);

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void keyShouldBeGivenInNumbers()
    {
        Converter encrypt = new Converter();
        int[] key = new int[0];

        String expectedKey = "";
        String actualKey = encrypt.mEncryptMessage(key, new int[0]);

        assertEquals(expectedKey, actualKey);
    }

    @Test
    public void keyAndMessageShouldBeOfSameLength()
    {
        Converter encrypt = new Converter();
        int length = 0;
        int[] key = new int[length];
        int[] message = new int[length];

        String expectedEncryptedMessage = "";
        String actualEncryptedMessage = encrypt.mEncryptMessage(key, message);

        assertEquals(expectedEncryptedMessage, actualEncryptedMessage);
    }

    @Test
    public void encryptMessageShouldBeTheSumOfMessageAndKey()
    {
        Converter encrypt = new Converter();
        int[] key = new int[]{1,2};
        int[] message = new int[]{3,4};
        String encryptedMessage = "DF";

        String expectedEncryptedMessage = encryptedMessage;
        String actualEncryptedMessage = encrypt.mEncryptMessage(message, key);

        assertEquals(expectedEncryptedMessage, actualEncryptedMessage);
    }
}