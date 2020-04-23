package solitaire;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GenerateKeyTest
{ 

    @Test
    public void emptyMessageShouldGenerateNoKey()
    {
        String message = "";
        int[] deckOfCards = new int[54];
        GenerateKey generateKey = new GenerateKey(deckOfCards);

        String expectedGeneratedKey = "";
        String actualGeneratedKey = generateKey.mGenerateKey(message);

        assertEquals(expectedGeneratedKey, actualGeneratedKey);
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
    public void generateADeckOfCardsShouldBeConveretedToNumbers()
    {
        int[] deckOfCards = mCreateDeckOfCards();
        GenerateKey generateKey = new GenerateKey(deckOfCards);

        int[] expectedDeckOfCards = deckOfCards;
        int[] actualDeckOfCards = generateKey.DeckOfCards;

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    public void moveJokerAoneCardDown()
    {
        int jokerA = 53;
        int[] deckOfCards = new int[54]; 
        deckOfCards[53] = 53;
        GenerateKey generateKey = new GenerateKey(deckOfCards);
        int[] newDeckOfCards = new int[54];
        newDeckOfCards[0] = jokerA;

        int[] expectedDeckOfCards = newDeckOfCards;
        generateKey.mMoveJokerA();
        int[] actualDeckOfCards = generateKey.DeckOfCards;

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    public void moveJokerBtwoCardsDown()
    {
        int jokerB = 54;
        int[] deckOfCards = new int[54];
        deckOfCards[52] = jokerB;
        deckOfCards[0] = 1;
        deckOfCards[1] =2;
        GenerateKey generateKey = new GenerateKey(deckOfCards);
        int[] newDeckOfCards = new int[54];
        newDeckOfCards[0] = 1;
        newDeckOfCards[1] = jokerB;
        newDeckOfCards[2] = 2;

        int[] expectedDeckOfCards = newDeckOfCards;
        generateKey.mMoveJokerB();
        int[] actualDeckOfCards = generateKey.DeckOfCards;

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    public void swapCardsBelowBottomJokerWithCardsAboveTopJokerCaseWhenJokerAisLower()
    {
        int jokerA = 53;
        int jokerB = 54;
        int[] deckOfCards = new int[54];
        deckOfCards[1] = jokerA;
        deckOfCards[50] = jokerB;
        GenerateKey generateKey = new GenerateKey(deckOfCards);
        int[] newDeckOfCards = new int[54];
        newDeckOfCards[3] = jokerA;
        newDeckOfCards[52] = jokerB;

        int[] expectedDeckOfCards = newDeckOfCards;
        generateKey.mTrippleCut();
        int[] actualDeckOfCards = generateKey.DeckOfCards;

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    public void swapCardsBelowBottomJokerWithCardsAboveTopJokerCaseWhenJokerBisLower()
    {
        int jokerA = 53;
        int jokerB = 54;
        int[] deckOfCards = new int[54];
        deckOfCards[53] = jokerA;
        deckOfCards[1] = jokerB;
        GenerateKey generateKey = new GenerateKey(deckOfCards);
        int[] newDeckOfCards = new int[54];
        newDeckOfCards[52] = jokerA;
        newDeckOfCards[0] = jokerB;

        int[] expectedDeckOfCards = newDeckOfCards;
        generateKey.mTrippleCut();
        int[] actualDeckOfCards = generateKey.DeckOfCards;

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    public void generateKeyShouldReturnKeyWhenMessagePassed()
    {
        int[] deckOfCards = mCreateDeckOfCards();
        GenerateKey generateKey = new GenerateKey(deckOfCards);
        String message = "hello";

        String expectedKeyGenerated = "BBCEH";
        String actualKeyGenereated = generateKey.mGenerateKey(message);

        assertEquals(expectedKeyGenerated, actualKeyGenereated);
    }

    @Test
    public void shouldReturnStringKeyLengthEqualToMessageLength()
    {
        int[] deckOfCards = mCreateDeckOfCards();
        GenerateKey generateKey = new GenerateKey(deckOfCards);
        String message = "hello"; 

        int expectedKeyLength = 5;
        int actualKeyLength = generateKey.mKeyLength(message);

        assertEquals(expectedKeyLength, actualKeyLength);
    }

    private int[] mCreateDeckOfCards() 
    {
        int[] deck = new int[54];
        for (int i = 0; i < deck.length; i++) 
        {
            deck[i] = i+1;
        }
        return deck;
    }
}