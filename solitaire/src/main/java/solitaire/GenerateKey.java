package solitaire;

import java.util.ArrayList;
import java.util.Arrays;
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

    public GenerateKey(int[] _deckOfCards) 
    {
        DeckOfCards = _deckOfCards;
    }

    public String mGenerateKey(String message) 
    {
        // mCreateDeckOfCards();
        String keyGenerated = "";
        for (int i = 0; i < message.length(); i++) 
        {
            System.out.println("=====ROUND "+i+"======");
            System.out.println("OG deck "+Arrays.toString(DeckOfCards));
            mMoveJokerA();
            System.out.println("Afte A "+Arrays.toString(DeckOfCards));
            mMoveJokerB();
            System.out.println("Afte B "+Arrays.toString(DeckOfCards));
            mTrippleCut();
            System.out.println("Tripple "+Arrays.toString(DeckOfCards));
            mMoveCardsBasingOnBottomCard();
            System.out.println("Move Cards "+Arrays.toString(DeckOfCards));
            mCountOffCardsFromTopBaseOnTopCardValue();
            System.out.println("Get value "+Arrays.toString(DeckOfCards));
            keyGenerated += cardValue();
        }
        return keyGenerated;
    }

    public void mCreateDeckOfCards() 
    {
        int j = 54;
        for (int i = 0; i < DECKOFCARDS_LENGTH; i++) 
        {
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
                System.out.println("As i am "+newPositionOfJoker);
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
        int[] newDeckOfCards = new int[54];
        newDeckOfCards[0] = valueOfCardAtBottom;
        if(valueOfCardAtBottom == 54)
        {
            valueOfCardAtBottom = 53;
        }

        /**
         * when the bottom card is a joker does not work. 
         * And that condition is not described in the doc.
         */

        for (int i = 0; i < valueOfCardAtBottom; i++) 
        {
            newDeckOfCards[i+1] = DeckOfCards[53-i];
        }
        for (int i = 0; i < 53-valueOfCardAtBottom; i++) 
        {
            newDeckOfCards[valueOfCardAtBottom+i+1] = DeckOfCards[i+1];
        }
        DeckOfCards = newDeckOfCards;
    }

    public void mCountOffCardsFromTopBaseOnTopCardValue()
    {
        int valueOfCardAtTop = DeckOfCards[53]; 
        if(valueOfCardAtTop == 54)
        {
            cardToConvert =DeckOfCards[0];
        }       
        cardToConvert = DeckOfCards[53-valueOfCardAtTop];
    }

    public String cardValue() 
    {
        if(cardToConvert == 53 || cardToConvert == 54)
        {
            return String.valueOf((char) (64 + cardToConvert));
        }
        else if(cardToConvert <= 26)
        {
            return String.valueOf((char) (64 + cardToConvert));
        }
        else
        {
            cardToConvert = cardToConvert % 26;
            return String.valueOf((char) (64 + cardToConvert));
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
