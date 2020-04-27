package solitaire;

import java.util.ArrayList;
import java.util.List;

public class GenerateKey 
{
    private int DECKOFCARDS_LENGTH = 54;
    public int[] DeckOfCards = new int[DECKOFCARDS_LENGTH];
    public static int JOKER_A = 53;
    public static int JOKER_B = 54;
    private int positionOfJokerA = 0;
    private int positionOfJokerB = 0;
    public int cardToConvert = 1;
    String keyGenerated = "";
    int ASCII_BASE = 64;
    int NUMBER_OF_ALPHABETS = 26;

    public GenerateKey(int[] _deckOfCards) 
    {
        DeckOfCards = _deckOfCards;
    }

    public String mGenerateKey(String message) 
    {
        for (int i = 0; i < message.length(); i++) 
        {
            mMoveJokerA();
            mMoveJokerB();
            mTrippleCut();
            mMoveCardsBasingOnBottomCard();
            mCountOffCardsFromTopBaseOnTopCardValue();
            keyGenerated += cardValue();
        }
        return keyGenerated;
    }

    public void mMoveJokerA() 
    {
        for (int j = 0; j < DECKOFCARDS_LENGTH; j++) 
        {
            if (DeckOfCards[j] == JOKER_A) 
            {
                int oldPostionOfJoker = j;
                int newPositionOfJoker = j - 1;
                if (oldPostionOfJoker == 0) 
                {
                    newPositionOfJoker = 53;
                    int[] newDeckOfCards = new int[JOKER_B];

                    newDeckOfCards[newPositionOfJoker] = JOKER_A;
                    for (int i = 0; i < JOKER_A; i++) 
                    {
                        newDeckOfCards[i] = DeckOfCards[i+1];
                    }
                    DeckOfCards = newDeckOfCards;
                    break;
                } 
                else 
                {
                    int x = DeckOfCards[newPositionOfJoker];
                    DeckOfCards[newPositionOfJoker] = JOKER_A;
                    DeckOfCards[oldPostionOfJoker] = x;
                    break;
                }
            }
        }
    }

    public void mMoveJokerB() 
    {
        for (int j = 0; j < DECKOFCARDS_LENGTH; j++) 
        {
            if (DeckOfCards[j] == JOKER_B) 
            {
                int oldPostionOfJoker = j;
                int newPositionOfJoker = j - 3;
                if (newPositionOfJoker < 0) 
                {
                    newPositionOfJoker = 54 + newPositionOfJoker;
                    DeckOfCards = mRearrangeDeck(newPositionOfJoker, oldPostionOfJoker);
                    break;
                } 
                else 
                {
                    int[] newDeckOfCards = new int[54];
                    for (int i = 0; i < newPositionOfJoker; i++) 
                    {
                        newDeckOfCards[i] = DeckOfCards[i];
                    }
                    newDeckOfCards[newPositionOfJoker] = JOKER_B;
                    for (int i = newPositionOfJoker; i < oldPostionOfJoker; i++) 
                    {
                        newDeckOfCards[i+1] = DeckOfCards[i];
                    }
                    for (int i = oldPostionOfJoker; i < 53; i++) {
                        newDeckOfCards[i+1] = DeckOfCards[i+1];
                    }
                    DeckOfCards = newDeckOfCards;
                    break;
                }
            }
        }
    }

    public void mTrippleCut() 
    {
        int numbercardsBetweenJokerAandJokerB = 0;

        List<Integer> listOfCardsBelow = new ArrayList<Integer>();
        List<Integer> listOfCardsBetweenJokers = new ArrayList<Integer>();
        List<Integer> listOfCardsAbove = new ArrayList<Integer>();

        int[] trippleCutDeck = new int[DECKOFCARDS_LENGTH];

        mFindPositionOfJokers();

        if (positionOfJokerA < positionOfJokerB) 
        {
            int[] cardsBelowJokerA = mCardsBelowBottomJoker(positionOfJokerA);
            listOfCardsBelow = mAddElementsToList(cardsBelowJokerA);
            
            int[] cardsAboveJokerB = mCardsAboveTopJoker(positionOfJokerB);
            listOfCardsAbove = mAddElementsToList(cardsAboveJokerB);
            
            numbercardsBetweenJokerAandJokerB = Math.abs(positionOfJokerB - positionOfJokerA);
            int[] cardsBetweenJokers = mCardsBetweenJokers(numbercardsBetweenJokerAandJokerB, positionOfJokerA);
            listOfCardsBetweenJokers = mAddElementsToList(cardsBetweenJokers);
            
            List<Integer> listOfTrippleCutDeck = new ArrayList<Integer>();
            for (int i : listOfCardsAbove) 
            {
                listOfTrippleCutDeck.add(i);
            }
            listOfTrippleCutDeck.add(JOKER_A);
            for (int i : listOfCardsBetweenJokers) 
            {
                listOfTrippleCutDeck.add(i);
            }
            listOfTrippleCutDeck.add(JOKER_B);
            for (int i : listOfCardsBelow) 
            {
                listOfTrippleCutDeck.add(i);
            }

            for (int i = 0; i < listOfTrippleCutDeck.size(); i++) 
            {
                trippleCutDeck[i] = listOfTrippleCutDeck.get(i);
            }
        } 
        else 
        {
            int[] cardsAboveJokerA = mCardsAboveTopJoker(positionOfJokerA);
            listOfCardsAbove = mAddElementsToList(cardsAboveJokerA);
            
            int[] cardsBelowJokerB = mCardsBelowBottomJoker(positionOfJokerB);
            listOfCardsBelow = mAddElementsToList(cardsBelowJokerB);
            
            numbercardsBetweenJokerAandJokerB = Math.abs(positionOfJokerA - positionOfJokerB);
            int[] cardsBetweenJokers = mCardsBetweenJokers(numbercardsBetweenJokerAandJokerB, positionOfJokerB);
            listOfCardsBetweenJokers = mAddElementsToList(cardsBetweenJokers);
            
            List<Integer> listOfTrippleCutDeck = new ArrayList<Integer>();
            for (int i : listOfCardsAbove) 
            {
                listOfTrippleCutDeck.add(i);
            }
            listOfTrippleCutDeck.add(JOKER_B);
            for (int i : listOfCardsBetweenJokers) 
            {
                listOfTrippleCutDeck.add(i);
            }
            listOfTrippleCutDeck.add(JOKER_A);
            for (int i : listOfCardsBelow) 
            {
                listOfTrippleCutDeck.add(i);
            }

            for (int i = 0; i < listOfTrippleCutDeck.size(); i++) 
            {
                trippleCutDeck[i] = listOfTrippleCutDeck.get(i);
            }
        }
        DeckOfCards = trippleCutDeck;
    }

    public void mMoveCardsBasingOnBottomCard()
    {
        int valueOfCardAtBottom = DeckOfCards[0];
        int[] newDeckOfCards = new int[JOKER_B];   
        newDeckOfCards[0] = valueOfCardAtBottom;

        if(valueOfCardAtBottom == 54)
        {
            valueOfCardAtBottom = 53;
        }
        for (int i = 0; i < valueOfCardAtBottom; i++) 
        {
            newDeckOfCards[i+1] = DeckOfCards[53-i];
        }
        for (int i = 0; i < JOKER_A-valueOfCardAtBottom; i++) 
        {
            newDeckOfCards[valueOfCardAtBottom+i+1] = DeckOfCards[i+1];
        }
        DeckOfCards = newDeckOfCards;
    }

    public void mCountOffCardsFromTopBaseOnTopCardValue()
    {
        int valueOfCardAtTop = DeckOfCards[JOKER_A]; 
        if(valueOfCardAtTop == JOKER_B)
        {
            cardToConvert =DeckOfCards[0];
        }       
        cardToConvert = DeckOfCards[JOKER_A - valueOfCardAtTop];
    }

    public String cardValue() 
    {
        if(cardToConvert == JOKER_B)
        {
            cardToConvert = JOKER_A;
        }
        if(cardToConvert == JOKER_A)
        {
            return "@";
        }
        else if(cardToConvert <= NUMBER_OF_ALPHABETS)
        {
            return String.valueOf((char) (ASCII_BASE + cardToConvert));
        }
        else
        {
            cardToConvert = cardToConvert % NUMBER_OF_ALPHABETS;
            return String.valueOf((char) (ASCII_BASE + cardToConvert));
        }  
    }

    private List<Integer> mAddElementsToList(int[] array)
    {
        List<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }
        return list;
    }

    private int[] mCardsBelowBottomJoker(int positionOfBottomJoker) 
    {
        int[] cardsBelowBottomJoker = new int[positionOfBottomJoker];
        for (int j = 0; j < positionOfBottomJoker; j++) 
        {
            cardsBelowBottomJoker[j] = DeckOfCards[j];
        }
        return cardsBelowBottomJoker;
    }

    private int[] mCardsAboveTopJoker(int positionOfTopJoker) 
    {
        int[] cardsAboveTopJoker = new int[53 - positionOfTopJoker];
        for (int j = 0; j < 53 - positionOfTopJoker; j++) 
        {
            cardsAboveTopJoker[j] = DeckOfCards[positionOfTopJoker + j + 1];
        }
        return cardsAboveTopJoker;
    }

    private int[] mCardsBetweenJokers(int numbercardsBetweenJokers, int positionOfJokerA) 
    {
        int[] cardsBetweenJokers = new int[numbercardsBetweenJokers - 1];
        for (int j = 0; j < cardsBetweenJokers.length; j++) 
        {
            cardsBetweenJokers[j] = DeckOfCards[j + positionOfJokerA + 1];
        }
        return cardsBetweenJokers;
    }

    
    private int[] mRearrangeDeck(int newPositionOfJoker, int oldPostionOfJoker) 
    {
        int[] newDeckOfCards = new int[DECKOFCARDS_LENGTH];

        for (int i = 0; i < oldPostionOfJoker; i++) 
        {
            newDeckOfCards[i] = DeckOfCards[i];
        }
        for (int i = oldPostionOfJoker; i < newPositionOfJoker; i++) 
        {
            newDeckOfCards[i] = DeckOfCards[i+1];
        }
        newDeckOfCards[newPositionOfJoker] = JOKER_B;
        for (int i = newPositionOfJoker; i < 53; i++) 
        {
            newDeckOfCards[i + 1] = DeckOfCards[i + 1];
        }
        return newDeckOfCards;        
    }

    private void mFindPositionOfJokers() 
    {
        for (int i = 0; i < DECKOFCARDS_LENGTH; i++) 
        {
            if (DeckOfCards[i] == JOKER_A) 
            {
                positionOfJokerA = i;
            }
            if (DeckOfCards[i] == JOKER_B) 
            {
                positionOfJokerB = i;
            }
        }
    }
}
