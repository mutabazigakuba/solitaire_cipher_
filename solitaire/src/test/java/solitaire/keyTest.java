package solitaire;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class keyTest {

    @Before
    public void testKeyClassShouldBeCreated()
    {
        int[] deckOfCards = new int[54];
        Key key = new Key(deckOfCards);

        assertEquals(true, key instanceof Key);
    } 

    @Test
    public void generateKeyFunctionShouldReturnString()
    {
        int[] deckOfCards = new int[54];
        Key key = new Key(deckOfCards);

        String expectedString = "";
        String actualString = key.mGenerateKey(0);

        assertEquals(expectedString, actualString);
    }

    @Test
    public void generateKeyFunctionShouldHaveDeckOf54Cards()
    {
        int[] deckOfCards = new int[54];
        Key key = new Key(deckOfCards);

        int[] expectedDeckOfCards = new int[54];
        int[] actualDeckOfCards = key.DeckOfCards;

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    public void sumOfDeckShouldAddUpTo1484()
    {
        int[] deckOfCards = new int[54];
        for (int i = 0; i < deckOfCards.length; i++) {
            deckOfCards[i] = i+1;
        }
        Key key = new Key(deckOfCards);

        int expectedSumOfDeck = 1485;
        int actualSumOfDeck = key.mSumOfDeck();

        assertEquals(expectedSumOfDeck, actualSumOfDeck);
    }

    @Test
    public void shouldBeAbleToMoveJokerAOneCardBelow()
    {
        int[] deckOfCards = new int[54];
        int jokerA = 53;
        deckOfCards[16] = jokerA;
        Key key = new Key(deckOfCards);
        int[] newDeckOfCards = new int[54];
        newDeckOfCards[15] = 53;

        int[] expectedDeckOfCards = newDeckOfCards;
        int[] actualDeckOfCards = key.mMoveJokerA(jokerA);
        
        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    
    @Test
    public void shouldBeAbleToMoveJokerBTwoCardsBelow()
    {
        int[] deckOfCards = new int[54];
        int jokerB = 54;
        deckOfCards[16] = jokerB;
        Key key = new Key(deckOfCards);
        int[] newDeckOfCards = new int[54];
        newDeckOfCards[14] = 54;

        int[] expectedDeckOfCards = newDeckOfCards;
        int[] actualDeckOfCards = key.mMoveJokerB(jokerB);

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    public void shouldMoveCardsBelowJokerAtoAboveJokerB()
    {
        int[] deckOfCards = new int[54];
        deckOfCards[16] = 53;
        deckOfCards[40] = 54;
        Key key = new Key(deckOfCards);
        int[] newDeckOfCards = new int[54];
        newDeckOfCards[13] = 53;
        newDeckOfCards[37] =54;

        int[] expectedDeckOfCards = newDeckOfCards;
        int[] actualDeckOfCards = key.mTrippleCut();

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    public void shouldReturnCardAfterCountingOffCardsBasingOnBottomeCardValue()
    {
        int[] deckOfCards = new int[54];
        deckOfCards[0] = 5;
        deckOfCards[48] = 37;
        Key key = new Key(deckOfCards);

        int expectedCard = 37;
        int actualCard = key.getFinalLetter();

        assertEquals(expectedCard, actualCard);
    }
}