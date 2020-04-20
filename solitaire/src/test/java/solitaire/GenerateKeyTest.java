package solitaire;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GenerateKeyTest
{ 

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
}