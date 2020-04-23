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
            mMoveJokerA();
            mMoveJokerB();
            mTrippleCut();
            keyGenerated += cardValue();
        }
        return keyGenerated;
    }

    public void mCreateDeckOfCards() 
    {
        for (int i = 0; i < DECKOFCARDS_LENGTH; i++) 
        {
            DeckOfCards[i] = i + 1;
        }
    }

    public void mMoveJokerA() {
        System.out.println(Arrays.toString(DeckOfCards));
        for (int j = 0; j < DECKOFCARDS_LENGTH; j++) 
        {
            if (DeckOfCards[j] == JOKER_A) 
            {
                int newPositionOfJoker = j + 1;
                if (newPositionOfJoker > 53) 
                {
                    newPositionOfJoker = newPositionOfJoker - 54;
                    int x = DeckOfCards[newPositionOfJoker];
                    DeckOfCards[newPositionOfJoker] = JOKER_A;
                    DeckOfCards[j] = x;
                    System.out.println(Arrays.toString(DeckOfCards));
                    break;
                } 
                else 
                {
                    int x = DeckOfCards[newPositionOfJoker];
                    DeckOfCards[newPositionOfJoker] = JOKER_A;
                    DeckOfCards[j] = x;
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
                int newPositionOfJoker = j + 2;
                if (newPositionOfJoker > 53) 
                {
                    newPositionOfJoker = newPositionOfJoker - 53;
                    DeckOfCards = mRearrangeDeck(newPositionOfJoker, j);
                    break;
                } 
                else 
                {
                    DeckOfCards = mRearrangeDeck(newPositionOfJoker, j);
                    break;
                }
            }
        }
    }

    private int[] mRearrangeDeck(int newPositionOfJoker, int oldPostionOfJoker) 
    {
        int[] newDeckOfCards = new int[DECKOFCARDS_LENGTH];
        for (int i = 0; i < newPositionOfJoker; i++) 
        {
            newDeckOfCards[i] = DeckOfCards[i];
        }
        newDeckOfCards[newPositionOfJoker] = JOKER_B;
        for (int i = newPositionOfJoker; i < oldPostionOfJoker; i++) 
        {
            newDeckOfCards[i + 1] = DeckOfCards[newPositionOfJoker];
            newPositionOfJoker++;
        }
        for (int i = oldPostionOfJoker; i < 53; i++) 
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
            for (int j : cardsBelowJokerA) 
            {
                listOfCardsBelow.add(j);
            }
            int[] cardsAboveJokerB = mCardsAboveTopJoker(positionOfJokerB);
            for (int j : cardsAboveJokerB) 
            {
                listOfCardsAbove.add(j);
            }
            numbercardsBetweenJokerAandJokerB = Math.abs(positionOfJokerB - positionOfJokerA);
            int[] cardsBetweenJokers = mCardsBetweenJokers(numbercardsBetweenJokerAandJokerB, positionOfJokerA);
            for (int j : cardsBetweenJokers) 
            {
                listOfCardsBetweenJokers.add(j);
            }
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
            for (int j : cardsAboveJokerA) 
            {
                listOfCardsAbove.add(j);
            }
            int[] cardsBelowJokerB = mCardsBelowBottomJoker(positionOfJokerB);
            for (int j : cardsBelowJokerB) 
            {
                listOfCardsBelow.add(j);
            }
            numbercardsBetweenJokerAandJokerB = Math.abs(positionOfJokerA - positionOfJokerB);
            int[] cardsBetweenJokers = mCardsBetweenJokers(numbercardsBetweenJokerAandJokerB, positionOfJokerB);
            for (int j : cardsBetweenJokers) 
            {
                listOfCardsBetweenJokers.add(j);
            }
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

    public String cardValue() 
    {
        int remainder = DeckOfCards[0] % 26;
        return String.valueOf((char) (64 + remainder));
    }

    public int mKeyLength(String message) 
    {
        String finalString = mGenerateKey(message);
        return finalString.length();
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
}
