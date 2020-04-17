package solitaire;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DencryptTest
{
    @Test
    public void encryptClassShouldBeCreated()
    {
        Dencrypt dencrypt = new Dencrypt();

        assertEquals(true, dencrypt instanceof Dencrypt);
    }

    @Test
    public void messageShouldBeGivenNumbers()
    {
        Dencrypt dencrypt = new Dencrypt();
        int[] message = new int[0];

        String expectedMessage = "";
        String actualMessage = dencrypt.mDencryptMessage( new int[0], message);

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void keyShouldBeGivenInNumbers()
    {
        Dencrypt dencrypt = new Dencrypt();
        int[] key = new int[0];

        String expectedKey = "";
        String actualKey = dencrypt.mDencryptMessage(key, new int[0]);

        assertEquals(expectedKey, actualKey);
    }

    @Test
    public void keyAndMessageShouldBeOfSameLength()
    {
        Dencrypt dencrypt = new Dencrypt();
        int length = 0;
        int[] key = new int[length];
        int[] message = new int[length];

        String expectedDencryptedMessage = "";
        String actualDencryptedMessage = dencrypt.mDencryptMessage(key, message);

        assertEquals(expectedDencryptedMessage, actualDencryptedMessage);
    }

    @Test
    public void dencryptMessageShouldBeTheDifferenceOfMessageAndKey()
    {
        Dencrypt dencrypt = new Dencrypt();
        int[] key = new int[]{1,2};
        int[] message = new int[]{3,4};
        String dencryptedMessage = "BB";

        String expectedDencryptedMessage = dencryptedMessage;
        String actualDencryptedMessage = dencrypt.mDencryptMessage(message, key);

        assertEquals(expectedDencryptedMessage, actualDencryptedMessage);
    }
}