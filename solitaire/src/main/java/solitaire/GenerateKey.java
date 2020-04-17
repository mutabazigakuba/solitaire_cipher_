package solitaire;

import java.util.ArrayList;
import java.util.List;

public class GenerateKey 
{
    public int[] DeckOfCards = new int[54];

    public GenerateKey(int[] _deckOfCards) 
    {
        DeckOfCards = _deckOfCards;
    }

    public String mGenerateKey(int messageLength) 
    {
        int[] DeckOfCards = mCreateDeckOfCards();
        DeckOfCards[10] = 53;
        DeckOfCards[34] = 54;
        String keyGenerated = "";
        for (int i = 0; i < messageLength; i++) {
            DeckOfCards = mMoveJokerA(53);
            DeckOfCards = mMoveJokerB(54);
            DeckOfCards = mTrippleCut();
            int number = getFinalCardNumberValue();
            String letter = getFinalCardStringValue(number);
            keyGenerated += letter;
        }
        return keyGenerated;
    }

    public int mSumOfDeck() 
    {
        int sumOfDecks = 0;
        for (int card : DeckOfCards) 
        {
            sumOfDecks += card;
        }
        return sumOfDecks;
    }

    public int[] mMoveJokerA(int jokerA) 
    {
        for (int j = 0; j < DeckOfCards.length; j++) 
        {
            if (DeckOfCards[j] == jokerA) 
            {
                int x = DeckOfCards[j - 1];
                DeckOfCards[j - 1] = jokerA;
                DeckOfCards[j] = x;
            }
        }
        return DeckOfCards;
    }

    public int[] mMoveJokerB(int jokerB) 
    {
        for (int j = 0; j < DeckOfCards.length; j++) 
        {
            if (DeckOfCards[j] == jokerB)
            {
                int x = DeckOfCards[j - 2];
                int y = DeckOfCards[j -1];
                DeckOfCards[j - 2] = jokerB;
                DeckOfCards[j - 1] = x;
                DeckOfCards[j] = y;
            }
        }
        return DeckOfCards;
    }

    public int[] mTrippleCut() 
    {
        int numberOfCardsBelowJokerA = 0;
        int numberOfCardsAboveJokerB = 0;
        int numbercardsBetweenJokerAandJokerB = 0;
        int jokerA = 53;
        int jokerB = 54;
        List<Integer> listOfCardsBelowJokerA = new ArrayList<Integer>();
        List<Integer> listOfCardsBetweenJokers = new ArrayList<Integer>();
        List<Integer> listOfCardsAboveJokerB = new ArrayList<Integer>();
        for (int i = 0; i < DeckOfCards.length; i++) 
        {
            if (DeckOfCards[i] == jokerA) 
            {
                numberOfCardsBelowJokerA = i;
                int[] cardsBelowJokerA = mReturnCardsBelowJokerA(numberOfCardsBelowJokerA);
                for (int j : cardsBelowJokerA) 
                {
                    listOfCardsBelowJokerA.add(j);
                }
            }
            if (DeckOfCards[i] == jokerB) 
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
        listOfTrippleCutDeck.add(53);
        for (int i : listOfCardsBetweenJokers) 
        {
            listOfTrippleCutDeck.add(i);            
        }
        listOfTrippleCutDeck.add(54);
        for (int i : listOfCardsBelowJokerA) 
        {
            listOfTrippleCutDeck.add(i);
        }

        int[] trippleCutDeck = new int[listOfTrippleCutDeck.size()];
        for (int i = 0; i < listOfTrippleCutDeck.size(); i++) 
        {
            trippleCutDeck[i] = listOfTrippleCutDeck.get(i);
        }
        return trippleCutDeck;
    }

    public int getFinalCardNumberValue()
    {
        int botttomCardValue = DeckOfCards[0];
        int cardNumberValue = DeckOfCards[53-botttomCardValue];
        return cardNumberValue; 
    }

    public String getFinalCardStringValue(int cardValue)
    {
        int remainder = cardValue % 26;
        return String.valueOf((char)(64+remainder));
    }

    public int[] mCreateDeckOfCards()
    {
        for (int i = 0; i < DeckOfCards.length; i++)
        {
            DeckOfCards[i] = i+1;
        }
        return DeckOfCards;
    }

    public int mKeyLength(String message)
    {
        String finalString = mGenerateKey(message.length());
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
