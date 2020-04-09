package solitaire;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class keyTest {

    @Test
    public void testKeyClassShouldBeCreated()
    {
        Key key = new Key();

        assertEquals(true, key instanceof Key);
    }

    @Test
    public void testKeyGenerateFucntionShouldReturnString()
    {
        Key key = new Key();
        String message = "";
        String keyGenerated = "";

        String expectedKey = keyGenerated;
        String actualKey = key.mGenerateKey(message.length());

        assertEquals(expectedKey, actualKey);
    }

    @Test
    public void testGeneratedKeyLengthShouldBeEqualToMessageLength()
    {
        Key key = new Key();
        String message = "hello";
        String generateKey = "hello";

        String expectedKey = generateKey;
        String actualKey = key.mGenerateKey(message.length());

        assertEquals(expectedKey, actualKey);
    }

}