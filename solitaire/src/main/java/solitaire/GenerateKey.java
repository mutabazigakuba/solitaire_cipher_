package solitaire;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateKey 
{
    private int DECKOFCARDS_LENGTH = 54;
    public int[] DeckOfCards = new int[DECKOFCARDS_LENGTH];
    public static int JOKER_A = 53;
    public static int JOKER_B = 54;
    private int positionOfJokerA = 0;
    private int positionOfJokerB = 0;

    public GenerateKey(int[] _deckOfCards) 
    {
        DeckOfCards = _deckOfCards;
    }

    public String mGenerateKey(String message)  
    {
        int messageLength = message.length();
        mCreateDeckOfCards();
        String keyGenerated = "";
        for (int i = 0; i < messageLength; i++) 
        {
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
        int numbercardsBetweenJokerAandJokerB = 0;

        List<Integer> listOfCardsBelowJokerA = new ArrayList<Integer>();
        List<Integer> listOfCardsBetweenJokers = new ArrayList<Integer>();
        List<Integer> listOfCardsAboveJokerB = new ArrayList<Integer>();
        
        for (int i = 0; i < DECKOFCARDS_LENGTH; i++) 
        {
            if (DeckOfCards[i] == JOKER_A) 
            {
                positionOfJokerA = i;
                int[] cardsBelowJokerA = mReturnCardsBelowJokerA(positionOfJokerA);
                for (int j : cardsBelowJokerA) 
                {
                    listOfCardsBelowJokerA.add(j);
                }
            }
            if (DeckOfCards[i] == JOKER_B) 
            {
                positionOfJokerB = 53 - i;
                int[] cardsAboveJokerB = mReturnCardsAboveJokerB(positionOfJokerB, i);
                for (int j : cardsAboveJokerB) 
                {
                    listOfCardsAboveJokerB.add(j);
                }
                numbercardsBetweenJokerAandJokerB = Math.abs(i - positionOfJokerA);
                int[] cardsBetweenJokers = mReturnCardsBetweenJokers(numbercardsBetweenJokerAandJokerB, positionOfJokerA); 
                for (int j : cardsBetweenJokers) 
                {
                    listOfCardsBetweenJokers.add(j);
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
        shuffleDeckOfCards(DeckOfCards);

        mFindPositionOfJoker(DeckOfCards, JOKER_A);
        mFindPositionOfJoker(DeckOfCards, JOKER_B);
        
        if(positionOfJokerA > positionOfJokerB){
            DeckOfCards[positionOfJokerA] = JOKER_B;
            DeckOfCards[positionOfJokerB] = JOKER_A;
        }
        return DeckOfCards;
    }

    private void mFindPositionOfJoker(int[] Deck, int joker)
    {
        for (int i = 0; i < Deck.length; i++) 
        {
            if(Deck[i] == JOKER_A)
            {
                positionOfJokerA = i;
            }
            if(Deck[i] == JOKER_B)
            {
                positionOfJokerB = i;
            }
        }
    }

    private void shuffleDeckOfCards(int card[])
    {
        Random random = new Random();
        for (int i = 0; i < DECKOFCARDS_LENGTH; i++) 
        {
            int r = i+random.nextInt(DECKOFCARDS_LENGTH - 1);
            if(r < DECKOFCARDS_LENGTH)
            {
                int temp = card[r];
                card[r] = card[i];
                card[i] = temp;
            } 
        }
    }

    public int mKeyLength(String message)
    {
        String finalString = mGenerateKey(message);
        return finalString.length();
    }

    private int[] mReturnCardsBelowJokerA(int positionOfJokerA)
    {
        int[] cardsBelowJokerA = new int[positionOfJokerA];
        for (int j = 0; j < positionOfJokerA; j++) 
        {
            cardsBelowJokerA[j] = DeckOfCards[j];
        }
        return cardsBelowJokerA;
    }

    private int[] mReturnCardsAboveJokerB(int positionOfJokerB, int i) 
    {
        int[] cardsAboveJokerB = new int[positionOfJokerB];
        for (int j = 0; j < positionOfJokerB; j++) 
        {
            cardsAboveJokerB[j] = DeckOfCards[i + j + 1];
        }
        return cardsAboveJokerB;
    }

    private int[] mReturnCardsBetweenJokers(int numbercardsBetweenJokers, int positionOfJokerA) 
    {
        int[] cardsBetweenJokers = new int[numbercardsBetweenJokers-1];
        for (int j = 0; j < cardsBetweenJokers.length; j++) 
        {
            cardsBetweenJokers[j] = DeckOfCards[j + positionOfJokerA + 1];
        }
        return cardsBetweenJokers;
    }
}
