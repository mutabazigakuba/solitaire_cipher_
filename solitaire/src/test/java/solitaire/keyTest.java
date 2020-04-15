package solitaire;

import static org.junit.Assert.assertArrayEquals;
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
        int[] actualDeckOfCards = key.deckOfCards;

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    public void sumOfDeckShouldAAddUpTo1484()
    {
        Key key = new Key();

        int expectedSumOfDeck = 1485;
        int actualSumOfDeck = key.mSumOfDeck();

        assertEquals(expectedSumOfDeck, actualSumOfDeck);
    }

    @Test
    public void shouldBeAbleToMoveJokerAOneCardBelow()
    {
        Key key = new Key();
        int jokerA = 53;

        int[] expectedDeckOfCards = deckOfCards(jokerA);
        int[] actualDeckOfCards = key.mMoveJokerA(jokerA);

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    
    @Test
    public void shouldBeAbleToMoveJokerBTwoCardBelow()
    {
        Key key = new Key();
        int jokerB = 54;

        int[] expectedDeckOfCards = deckOfCards(jokerB);
        int[] actualDeckOfCards = key.mMoveJokerB(jokerB);

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    private int[] deckOfCards(int joker)
    {
        int[] newDeck = new int[54];
        //create deck
        for (int i = 0; i < newDeck.length; i++) 
        {
            newDeck[i] = i+1;
        }
        //moving joker A
        if(joker == 53)
        {
            for (int j = 0; j < newDeck.length; j++) 
            {
                if(newDeck[j] == 53)
                {
                    int x = newDeck[j-1];
                    newDeck[j-1] = joker;
                    newDeck[j] = x;
                    return newDeck;
                }
            }
        }
        
        //moving joker B
        for (int j = 0; j < newDeck.length; j++) 
        {
            if(newDeck[j] == 54)
            {
                int x = newDeck[j-2];
                newDeck[j-2] = joker;
                newDeck[j] = x;
            }
        }    
        return newDeck;
    }
}