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
    public void moveJokerAoneCardDownCaseJokerAisAtTheBottom()
    {
        int jokerA = 53;
        int[] deckOfCards = new int[54]; 
        deckOfCards[53] = jokerA;
        deckOfCards[0] = 1;
        GenerateKey generateKey = new GenerateKey(deckOfCards);
        int[] newDeckOfCards = new int[54];
        newDeckOfCards[0] = jokerA;
        newDeckOfCards[1] = 1;

        int[] expectedDeckOfCards = newDeckOfCards;
        generateKey.mMoveJokerA();
        int[] actualDeckOfCards = generateKey.DeckOfCards;

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    public void moveJokerAoneCardDownCaseJokerAisNotAtTheBottom()
    {
        int jokerA = 53;
        int[] deckOfCards = new int[54]; 
        deckOfCards[52] = jokerA;
        deckOfCards[53] = 1;
        GenerateKey generateKey = new GenerateKey(deckOfCards);
        int[] newDeckOfCards = new int[54];
        newDeckOfCards[53] = jokerA;
        newDeckOfCards[52] = 1;

        int[] expectedDeckOfCards = newDeckOfCards;
        generateKey.mMoveJokerA();
        int[] actualDeckOfCards = generateKey.DeckOfCards;

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    public void moveJokerBtwoCardsDownCaseJokerIsInLastPositions()
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
    public void moveJokerBtwoCardsDownCaseJokerIsInFirstPositions()
    {
        int jokerB = 54;
        int[] deckOfCards = new int[54];
        deckOfCards[0] = 1;
        deckOfCards[1] = 2;
        deckOfCards[2] = jokerB;
        deckOfCards[3] = 3;
        deckOfCards[4] = 4;
        deckOfCards[5] = 5;
        deckOfCards[6] = 6;

        deckOfCards[53] = 7;
        GenerateKey generateKey = new GenerateKey(deckOfCards);
        int[] newDeckOfCards = new int[54];
        newDeckOfCards[0] = 7;
        newDeckOfCards[1] = 1;
        newDeckOfCards[2] =2;
        newDeckOfCards[3] = 3;
        newDeckOfCards[4] = 4;
        newDeckOfCards[5] = jokerB;
        newDeckOfCards[6] = 5;
        newDeckOfCards[7] = 6;

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
    public void countCardsOffTheTopBasingOnTheBottomCard()
    {
        int[] deckOfCards = new int[54];
        deckOfCards[53] = 54;
        deckOfCards[52] = 2;
        deckOfCards[51] = 3;
        deckOfCards[50] = 4;

        deckOfCards[2] = 52;
        deckOfCards[1] = 53;
        deckOfCards[0] = 2;
        GenerateKey generateKey = new GenerateKey(deckOfCards);
        int[] newDeckOfCards = new int[54];
        newDeckOfCards[53] = 3;
        newDeckOfCards[52] = 4;

        newDeckOfCards[4] = 52;
        newDeckOfCards[3] = 53;
        newDeckOfCards[2] = 2;
        newDeckOfCards[1] = 54;
        newDeckOfCards[0] = 2;

        int[] expectedDeckOfCards = newDeckOfCards;
        generateKey.mMoveCardsBasingOnBottomCard();
        int[] actualDeckOfCards = generateKey.DeckOfCards;

        assertArrayEquals(expectedDeckOfCards, actualDeckOfCards);
    }

    @Test
    public void countOffCardsFromTopToGetValueOfFinalCard()
    {
        int[] deckOfCards = new int[54];
        deckOfCards[53] = 2;
        deckOfCards[52] = 3;
        deckOfCards[51] = 4;

        deckOfCards[2] = 53;
        deckOfCards[1] = 54;
        deckOfCards[0] = 1;
        GenerateKey generateKey = new GenerateKey(deckOfCards);

        int expectedCardValue = 4;
        generateKey.mCountOffCardsFromTopBaseOnTopCardValue();
        int actualCardValue = generateKey.cardToConvert;

        assertEquals(expectedCardValue, actualCardValue);
    }

    @Test
    public void numberShouldReturnAstringValue()
    {
        int[] deckOfCards = new int[54];
        deckOfCards[53] = 4;
        GenerateKey generateKey = new GenerateKey(deckOfCards);

        String expectedValue = "A";
        generateKey.cardValue();
        String actualValue = generateKey.cardValue();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void generateKeyShouldReturnKeyWhenMessagePassed()
    {
        int[] deckOfCards = mCreateDeckOfCards();
        GenerateKey generateKey = new GenerateKey(deckOfCards);
        String message = "ab";

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