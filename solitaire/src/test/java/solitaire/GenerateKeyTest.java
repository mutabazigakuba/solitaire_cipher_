package solitaire;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GenerateKeyTest 
{

    @Before
    public void testKeyClassShouldBeCreated()
    {
        int[] deckOfCards = new int[54];
        GenerateKey generateKey = new GenerateKey(deckOfCards);

        assertEquals(true, generateKey instanceof GenerateKey);
    } 

    @Test
    public void generateKeyFunctionShouldReturnString()
    {
        int[] deckOfCards = new int[54];
        GenerateKey generateKey = new GenerateKey(deckOfCards);

        String expectedString = "";
        String actualString = generateKey.mGenerateKey(0);

        assertEquals(expectedString, actualString);
    }

    @Test
    public void generateKeyFunctionShouldHaveDeckOf54Cards()
    {
        int[] deckOfCards = new int[54];
        GenerateKey generateKey = new GenerateKey(deckOfCards);

        int[] expectedDeckOfCards = new int[54];
        int[] actualDeckOfCards = generateKey.DeckOfCards;

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    public void sumOfDeckShouldAddUpTo1484()
    {
        int[] deckOfCards = new int[54];
        for (int i = 0; i < deckOfCards.length; i++) {
            deckOfCards[i] = i+1;
        }
        GenerateKey generateKey = new GenerateKey(deckOfCards);

        int expectedSumOfDeck = 1485;
        int actualSumOfDeck = generateKey.mSumOfDeck();

        assertEquals(expectedSumOfDeck, actualSumOfDeck);
    }

    @Test
    public void shouldBeAbleToMoveJokerAOneCardBelow()
    {
        int[] deckOfCards = new int[54];
        int jokerA = 53;
        deckOfCards[16] = jokerA;
        GenerateKey generateKey = new GenerateKey(deckOfCards);
        int[] newDeckOfCards = new int[54];
        newDeckOfCards[15] = 53;

        int[] expectedDeckOfCards = newDeckOfCards;
        int[] actualDeckOfCards = generateKey.mMoveJokerA(jokerA);
        
        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    
    @Test
    public void shouldBeAbleToMoveJokerBTwoCardsBelow()
    {
        int[] deckOfCards = new int[54];
        int jokerB = 54;
        deckOfCards[16] = jokerB;
        deckOfCards[15] = 3;
        deckOfCards[14] = 5;
        GenerateKey generateKey = new GenerateKey(deckOfCards);
        int[] newDeckOfCards = new int[54];
        newDeckOfCards[14] = 54;
        newDeckOfCards[15] = 5;
        newDeckOfCards[16] = 3;

        int[] expectedDeckOfCards = newDeckOfCards;
        int[] actualDeckOfCards = generateKey.mMoveJokerB(jokerB);

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    public void shouldMoveCardsBelowJokerAtoAboveJokerB()
    {
        int[] deckOfCards = new int[54];
        deckOfCards[16] = 53;
        deckOfCards[40] = 54;
        GenerateKey generateKey = new GenerateKey(deckOfCards);
        int[] newDeckOfCards = new int[54];
        newDeckOfCards[13] = 53;
        newDeckOfCards[37] =54;

        int[] expectedDeckOfCards = newDeckOfCards;
        int[] actualDeckOfCards = generateKey.mTrippleCut();

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    public void shouldReturnCardAfterCountingOffCardsBasingOnBottomeCardValue()
    {
        int[] deckOfCards = new int[54];
        deckOfCards[0] = 5;
        deckOfCards[48] = 37;
        GenerateKey generateKey = new GenerateKey(deckOfCards);

        int expectedCard = 37;
        int actualCard = generateKey.getFinalCardNumberValue();

        assertEquals(expectedCard, actualCard);
    }

    @Test
    public void shouldReturnStringValueWhenValueLessThan26()
    {
        int[] deckOfCards = new int[54];
        deckOfCards[0] = 5;
        deckOfCards[48] = 15;
        GenerateKey generateKey = new GenerateKey(deckOfCards);

        String expectedCard = "O";
        String actualCard = generateKey.getFinalCardStringValue(15);

        assertEquals(expectedCard, actualCard);       
    }

    @Test
    public void shouldReturnStringWhenValueIsGreaterThan26()
    {
        int[] deckOfCards = new int[54];
        deckOfCards[0] = 5;
        deckOfCards[48] = 51;
        GenerateKey generateKey = new GenerateKey(deckOfCards);     

        String expectedCard = "Y";
        String actualCard = generateKey.getFinalCardStringValue(51);

        assertEquals(expectedCard, actualCard);
    }

    @Test
    public void shouldGenerateADeckOfCardsConveretedToNumbers()
    {
        int[] deckOfCards = new int[54];
        for (int i = 0; i < deckOfCards.length; i++) 
        {
            deckOfCards[i] = i+1;
        }
        GenerateKey generateKey = new GenerateKey(deckOfCards);

        int[] expectedDeckOfCards = deckOfCards;
        int[] actualDeckOfCards = generateKey.mCreateDeckOfCards();

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    public void shouldReturnKeyWhenMessageLengthPassed()
    {
        int[] deckOfCards = new int[54];
        GenerateKey generateKey = new GenerateKey(deckOfCards);
        String message = "hello";
        String keyGenereated = "AAYYY";

        String expectedKeyGenerated = keyGenereated;
        String actualKeyGenereated = generateKey.mGenerateKey(message.length());

        assertEquals(expectedKeyGenerated, actualKeyGenereated);
    }

    @Test
    public void shouldReturnStringKeyLengthEqualToMessageLength()
    {
        int[] deckOfCards = new int[54];
        GenerateKey generateKey = new GenerateKey(deckOfCards);
        String message = "message"; 
        String keyGenerated = "adgergk";

        int expectedKeyLength = keyGenerated.length();
        int actualKeyLength = generateKey.mKeyLength(message);

        assertEquals(expectedKeyLength, actualKeyLength);
    }
}