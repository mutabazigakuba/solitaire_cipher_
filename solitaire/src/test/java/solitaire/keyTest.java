package solitaire;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class keyTest {

    @Before
    public void testKeyClassShouldBeCreated()
    {
        Key key = new Key();

        assertEquals(true, key instanceof Key);
    } 

    @Test
    public void generateKeyFunctionShouldReturnString()
    {
        Key key = new Key();

        String expectedString = "";
        String actualString = key.mGenerateKey(0);

        assertEquals(expectedString, actualString);
    }

    @Test
    public void generateKeyFunctionShouldHaveDeckOf54Cards()
    {
        Key key = new Key();

        int[] expectedDeckOfCards = new int[54];
        int[] actualDeckOfCards = key.mCreateDeckOfCardsValues();

        assertEquals(expectedDeckOfCards, actualDeckOfCards);
    }

}