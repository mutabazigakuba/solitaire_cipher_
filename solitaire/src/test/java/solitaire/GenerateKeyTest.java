package solitaire;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GenerateKeyTest
{

    @Before
    public void keyClassShouldBeCreated()
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
        String actualString = generateKey.mGenerateKey("");

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
    public void generateKeyShouldReturnKeyWhenMessageLengthPassed()
    {
        int[] deckOfCards = new int[54];
        GenerateKey generateKey = new GenerateKey(deckOfCards);
        String message = "hell";
        String keyGenereated = "ITIU";

        String expectedKeyGenerated = keyGenereated;
        String actualKeyGenereated = generateKey.mGenerateKey(message);

        assertEquals(expectedKeyGenerated, actualKeyGenereated);
    }

    @Test
    public void shouldReturnStringKeyLengthEqualToMessageLength()
    {
        int[] deckOfCards = new int[54];
        GenerateKey generateKey = new GenerateKey(deckOfCards);
        String message = "helloo"; 
        String keyGenerated = "helloo";

        int expectedKeyLength = keyGenerated.length();
        int actualKeyLength = generateKey.mKeyLength(message);

        assertEquals(expectedKeyLength, actualKeyLength);
    }

    @Test
    public void movesJOKER_A_by_One_Position()
    {
        int[] deckOfCards = new int[54];
        deckOfCards[4] = 53;
        deckOfCards[3] = 5;
        GenerateKey generateKey = new GenerateKey(deckOfCards);
        int[] newDeckOfCards = new int[54];
        newDeckOfCards[4] = 5;
        newDeckOfCards[3] = 53;

        int[] expected = newDeckOfCards;
        generateKey.mMoveJokerA();
        int[] actual = generateKey.DeckOfCards;
        
        assertArrayEquals(expected, actual);       
    }
    
    // @Test
    // public void encryptsMessage()
    // {
    //     String message = "YOUR CIPHER IS WORKING";
    //     int[] deckOfCards = new int[54];
    //     GenerateKey generateKey = new GenerateKey(deckOfCards);

    //     Solitaire solitaire = new Solitaire(message, generateKey, new Message(message));
    //     String expectedMessage = "CLEPKHHNIYCFPWHFDFEH";
    //     String actualMessage = solitaire.mEncryptMessage();
      
    //     assertEquals(expectedMessage, actualMessage);       
    // } 
}