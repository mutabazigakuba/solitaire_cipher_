 package solitaire;

import java.util.ArrayList;
import java.util.List;

public class Key
{
    private int DECKOFCARDS_LENGTH = 54;
    public int[] DeckOfCards = new int[DECKOFCARDS_LENGTH];
    public static int JOKER_A = 53;
    public static int JOKER_B = 54;
    private int positionOfJokerA = 0;
    private int positionOfJokerB = 0;
    public int cardToConvert = 1;
    String keyGenerated= "";
    int ASCII_BASE = 64;
    int NUMBER_OF_ALPHABETS = 26;

    public Key(int[] _deckOfCards) 
    {
        DeckOfCards = _deckOfCards;
    }

    public String mGenerate(String message) 
    {
        mGenerateDeckOfCards();

        for (int i = 0; i < message.length(); i++) 
        {
            mMoveJokerA();
            mMoveJokerB();
            mTrippleCut();
            mCountCut();
            mOutPutCardInNumbers();
            String keyValue = cardValue();
            if(keyValue == ""){i = i-1;}
            keyGenerated += keyValue;
        }
        return keyGenerated;
    }

    private void mGenerateDeckOfCards() {
        int j = 54;
        for (int i = 0; i < DeckOfCards.length; i++) {
            DeckOfCards[i] = j;
            j--;
        }
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
                    int[] newDeckOfCards = new int[54];

                    newDeckOfCards[newPositionOfJoker] = JOKER_A;
                    for (int i = 0; i < 53; i++) 
                    {
                        newDeckOfCards[i] = DeckOfCards[i+1];
                    }
                    DeckOfCards = newDeckOfCards;
                    break;
                } 
                else 
                {
                    int cardToSwap = DeckOfCards[newPositionOfJoker];
                    DeckOfCards[newPositionOfJoker] = JOKER_A;
                    DeckOfCards[oldPostionOfJoker] = cardToSwap;
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

        numbercardsBetweenJokerAandJokerB = Math.abs(positionOfJokerB - positionOfJokerA);

        if (positionOfJokerA < positionOfJokerB) 
        {
            listOfCardsBelow = mCardsBelowBottomJoker(positionOfJokerA);
            
            listOfCardsAbove = mCardsAboveTopJoker(positionOfJokerB);
            
            listOfCardsBetweenJokers = mCardsBetweenJokers(numbercardsBetweenJokerAandJokerB, positionOfJokerA);
            
            trippleCutDeck = mFinalTrippleCutDeck(listOfCardsAbove, listOfCardsBetweenJokers, listOfCardsBelow, JOKER_A, JOKER_B);

        } 
        else 
        {
            listOfCardsAbove = mCardsAboveTopJoker(positionOfJokerA);
            
            listOfCardsBelow = mCardsBelowBottomJoker(positionOfJokerB);
            
            listOfCardsBetweenJokers = mCardsBetweenJokers(numbercardsBetweenJokerAandJokerB, positionOfJokerB);
            
            trippleCutDeck = mFinalTrippleCutDeck(listOfCardsAbove, listOfCardsBetweenJokers, listOfCardsBelow, JOKER_B, JOKER_A);

        }
        DeckOfCards = trippleCutDeck;
    }

    public void mCountCut()
    {
        int valueOfCardAtBottom = DeckOfCards[0];
        int[] newDeckOfCards = new int[54];   

        if(valueOfCardAtBottom == 54)
        {
            valueOfCardAtBottom = 53;
        }
        if(valueOfCardAtBottom ==53)
        {
            newDeckOfCards = DeckOfCards;
            DeckOfCards = newDeckOfCards;      
        }
        else
        { 
            newDeckOfCards[0] = valueOfCardAtBottom;

            for (int i = 0; i < valueOfCardAtBottom; i++) 
            {
                newDeckOfCards[i+1] = DeckOfCards[54 - valueOfCardAtBottom+i];
            }
            for (int i = 0; i < 53-valueOfCardAtBottom; i++) 
            {
                newDeckOfCards[valueOfCardAtBottom+i+1] = DeckOfCards[i+1];
            }
            DeckOfCards = newDeckOfCards;
        }
        
    }

    public void mOutPutCardInNumbers()
    {
        int valueOfCardAtTop = DeckOfCards[53]; 
        if(valueOfCardAtTop == 54)
        {
            valueOfCardAtTop = 53;
        }       
        cardToConvert = DeckOfCards[53 - valueOfCardAtTop];
    }

    public String cardValue() 
    {
        if(cardToConvert == JOKER_B || cardToConvert == JOKER_A)
        {
            return "";
        }
        else if(cardToConvert <= NUMBER_OF_ALPHABETS)
        {
            return String.valueOf((char) (ASCII_BASE + cardToConvert));
        }
        else
        {
            cardToConvert = cardToConvert - NUMBER_OF_ALPHABETS;
            return String.valueOf((char) (ASCII_BASE + cardToConvert));
        }  
    }

    private List<Integer> mChangeArrayToList(int[] array)
    {
        List<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }
        return list;
    }

    private List<Integer> mCardsBelowBottomJoker(int positionOfBottomJoker) 
    {
        int[] cardsBelowBottomJoker = new int[positionOfBottomJoker];
        for (int j = 0; j < positionOfBottomJoker; j++) 
        {
            cardsBelowBottomJoker[j] = DeckOfCards[j];
        }
        return mChangeArrayToList(cardsBelowBottomJoker);
    }

    private List<Integer> mCardsAboveTopJoker(int positionOfTopJoker) 
    {
        int[] cardsAboveTopJoker = new int[53 - positionOfTopJoker];
        for (int j = 0; j < 53 - positionOfTopJoker; j++) 
        {
            cardsAboveTopJoker[j] = DeckOfCards[positionOfTopJoker + j + 1];
        }
        return mChangeArrayToList(cardsAboveTopJoker);
    }

    private List<Integer> mCardsBetweenJokers(int numbercardsBetweenJokers, int positionOfJokerA) 
    {
        int[] cardsBetweenJokers = new int[numbercardsBetweenJokers - 1];
        for (int j = 0; j < cardsBetweenJokers.length; j++) 
        {
            cardsBetweenJokers[j] = DeckOfCards[j + positionOfJokerA + 1];
        }
        return mChangeArrayToList(cardsBetweenJokers);
    }

    private int[] mFinalTrippleCutDeck(List<Integer> cardsAbove, List<Integer> cardsBetween, List<Integer> cardsBelow,  int joker1, int joker2)
    {
        List<Integer> listOfTrippleCutDeck = new ArrayList<Integer>();

        for (int i : cardsAbove) 
            {
                listOfTrippleCutDeck.add(i);
            }
            listOfTrippleCutDeck.add(joker1);
            for (int i : cardsBetween) 
            {
                listOfTrippleCutDeck.add(i);
            }
            listOfTrippleCutDeck.add(joker2);
            for (int i : cardsBelow) 
            {
                listOfTrippleCutDeck.add(i);
            }

            int[] trippleCutDeck = new int[DECKOFCARDS_LENGTH];

            for (int i = 0; i < listOfTrippleCutDeck.size(); i++) 
            {
                trippleCutDeck[i] = listOfTrippleCutDeck.get(i);
            }

            return trippleCutDeck;
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
