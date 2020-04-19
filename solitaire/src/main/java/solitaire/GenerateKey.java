package solitaire;

import java.util.ArrayList;
import java.util.List;

public class GenerateKey 
{
    private int DECKOFCARDS_LENGTH = 54;
    public int[] DeckOfCards = new int[DECKOFCARDS_LENGTH];
    public static int JOKER_A = 53;
    public static int JOKER_B = 54;

    public GenerateKey(int[] _deckOfCards) 
    {
        DeckOfCards = _deckOfCards;
    }

    public String mGenerateKey(String message)  
    {
        int messageLength = message.length();

        int[] DeckOfCards = mCreateDeckOfCards();
        DeckOfCards[10] = 53;
        DeckOfCards[34] = 54;
        String keyGenerated = "";
        for (int i = 0; i < messageLength; i++) {
            mMoveJokerA();
            mMoveJokerB();
            mTrippleCut();
            int number = getFinalCardNumberValue();
            String letter = getFinalCardStringValue(number);
            keyGenerated += letter;
        }
        return keyGenerated;
    }

    public void mMoveJokerA() 
    {
        for (int j = 0; j < DECKOFCARDS_LENGTH; j++) 
        {
            if (DeckOfCards[j] == JOKER_A) 
            {
                int x = DeckOfCards[j - 1];
                DeckOfCards[j - 1] = JOKER_A;
                DeckOfCards[j] = x;
            }
        }
    }

    public void mMoveJokerB() 
    {
        for (int j = 0; j < DECKOFCARDS_LENGTH; j++) 
        {
            if (DeckOfCards[j] == JOKER_B)
            {
                int x = DeckOfCards[j - 2];
                int y = DeckOfCards[j -1];
                DeckOfCards[j - 2] = JOKER_B;
                DeckOfCards[j - 1] = x;
                DeckOfCards[j] = y;
            }
        }
    }

    public void mTrippleCut() 
    {
        int numberOfCardsBelowJokerA = 0;
        int numberOfCardsAboveJokerB = 0;
        int numbercardsBetweenJokerAandJokerB = 0;

        List<Integer> listOfCardsBelowJokerA = new ArrayList<Integer>();
        List<Integer> listOfCardsBetweenJokers = new ArrayList<Integer>();
        List<Integer> listOfCardsAboveJokerB = new ArrayList<Integer>();
        
        for (int i = 0; i < DECKOFCARDS_LENGTH; i++) 
        {
            if (DeckOfCards[i] == JOKER_A) 
            {
                numberOfCardsBelowJokerA = i;
                int[] cardsBelowJokerA = mReturnCardsBelowJokerA(numberOfCardsBelowJokerA);
                for (int j : cardsBelowJokerA) 
                {
                    listOfCardsBelowJokerA.add(j);
                }
            }
            if (DeckOfCards[i] == JOKER_B) 
            {
                numbercardsBetweenJokerAandJokerB = Math.abs(i - numberOfCardsBelowJokerA);
                int[] cardsBetweenJokers = mReturnCardsBetweenJokers(numbercardsBetweenJokerAandJokerB, numberOfCardsBelowJokerA); 
                for (int j : cardsBetweenJokers) 
                {
                    listOfCardsBetweenJokers.add(j);
                }
                numberOfCardsAboveJokerB = 53 - i;
                int[] cardsAboveJokerB = mReturnCardsAboveJokerB(numberOfCardsAboveJokerB, i);
                for (int j : cardsAboveJokerB) 
                {
                    listOfCardsAboveJokerB.add(j);
                }
            }
        }
        List<Integer> listOfTrippleCutDeck = new ArrayList<Integer>();
        for (int i : listOfCardsAboveJokerB) 
        {
            listOfTrippleCutDeck.add(i);
        }
        listOfTrippleCutDeck.add(JOKER_A);
        for (int i : listOfCardsBetweenJokers) 
        {
            listOfTrippleCutDeck.add(i);            
        }
        listOfTrippleCutDeck.add(JOKER_B);
        for (int i : listOfCardsBelowJokerA) 
        {
            listOfTrippleCutDeck.add(i);
        }

        int[] trippleCutDeck = new int[listOfTrippleCutDeck.size()];
        for (int i = 0; i < listOfTrippleCutDeck.size(); i++) 
        {
            trippleCutDeck[i] = listOfTrippleCutDeck.get(i);
        }
        DeckOfCards = trippleCutDeck;
    }

    public int getFinalCardNumberValue()
    {
        int botttomCardValue = DeckOfCards[0];
        int cardNumberValue = DeckOfCards[JOKER_A - botttomCardValue];
        return cardNumberValue; 
    }

    public String getFinalCardStringValue(int cardValue)
    {
        int remainder = cardValue % 26;
        return String.valueOf((char)(64 + remainder));
    }

    public int[] mCreateDeckOfCards()
    {
        for (int i = 0; i < DECKOFCARDS_LENGTH; i++)
        {
            DeckOfCards[i] = i+1;
        }
        return DeckOfCards;
    }

    public int mKeyLength(String message)
    {
        String finalString = mGenerateKey(message);
        System.out.println(finalString);
        return finalString.length();
    }

    private int[] mReturnCardsBelowJokerA(int numberOfCardsBelowJokerA)
    {
        int[] cardsBelowJokerA = new int[numberOfCardsBelowJokerA];
        for (int j = 0; j < numberOfCardsBelowJokerA; j++) 
        {
            cardsBelowJokerA[j] = DeckOfCards[j];
        }
        return cardsBelowJokerA;
    }

    private int[] mReturnCardsAboveJokerB(int numberOfCardsAboveJokerB, int i) 
    {
        int[] cardsAboveJokerB = new int[numberOfCardsAboveJokerB];
        for (int j = 0; j < numberOfCardsAboveJokerB; j++) 
        {
            cardsAboveJokerB[j] = DeckOfCards[i + j + 1];
        }
        return cardsAboveJokerB;
    }

    private int[] mReturnCardsBetweenJokers(int numbercardsBetweenJokers, int numberOfCardsBelowJokerA) 
    {
        int[] cardsBetweenJokers = new int[numbercardsBetweenJokers-1];
        for (int j = 0; j < cardsBetweenJokers.length; j++) 
        {
            cardsBetweenJokers[0] = DeckOfCards[numberOfCardsBelowJokerA + 1];
        }
        return cardsBetweenJokers;
    }
}
