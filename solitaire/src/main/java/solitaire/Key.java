package solitaire;

import java.util.ArrayList;
import java.util.List;

public class Key {
    public int[] DeckOfCards = new int[54];

    public Key(int[] _deckOfCards) {
        DeckOfCards = _deckOfCards;
    }

    public String mGenerateKey(int keyLength) {
        return "";
    }

    public int mSumOfDeck() {
        int sumOfDecks = 0;
        for (int card : DeckOfCards) {
            sumOfDecks += card;
        }
        return sumOfDecks;
    }

    public int[] mMoveJokerA(int jokerA) {
        for (int j = 0; j < DeckOfCards.length; j++) {
            if (DeckOfCards[j] == jokerA) {
                int x = DeckOfCards[j - 1];
                DeckOfCards[j - 1] = jokerA;
                DeckOfCards[j] = x;
            }
        }
        return DeckOfCards;
    }

    public int[] mMoveJokerB(int jokerB) {
        for (int j = 0; j < DeckOfCards.length; j++) {
            if (DeckOfCards[j] == jokerB) {
                int x = DeckOfCards[j - 2];
                DeckOfCards[j - 2] = jokerB;
                DeckOfCards[j] = x;
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

        List<Integer> list = new ArrayList<Integer>();
        List<Integer> listA = new ArrayList<Integer>();
        List<Integer> listB = new ArrayList<Integer>();
        List<Integer> listC = new ArrayList<Integer>();

        for (int i = 0; i < DeckOfCards.length; i++) 
        {
            if (DeckOfCards[i] == jokerA) 
            {
                numberOfCardsBelowJokerA = i;
                int[] cardsBelowJokerA = mReturnCardsBelowJokerA(numberOfCardsBelowJokerA);
                for (int j : cardsBelowJokerA) {
                    listA.add(j);
                }
            }
            if (DeckOfCards[i] == jokerB) 
            {
                numbercardsBetweenJokerAandJokerB = Math.abs(i - numberOfCardsBelowJokerA);
                int[] cardsBetweenJokerAandJokerB = mReturnCardsBetweenJokers(numbercardsBetweenJokerAandJokerB, numberOfCardsBelowJokerA); 
                for (int j : cardsBetweenJokerAandJokerB) {
                    listB.add(j);
                }

                numberOfCardsAboveJokerB = 53 - i;
                int[] cardsAboveJokerB = mReturnCardsAboveJokerB(numberOfCardsAboveJokerB, i);
                for (int j : cardsAboveJokerB) {
                    listC.add(j);
                }
            }
        }

        for (int i : listC) {
            list.add(i);
        }
        list.add(53);
        for (int i : listB) {
            list.add(i);            
        }
        list.add(54);
        for (int i : listA) {
            list.add(i);
        }

        int[] trippleCutDeck = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            trippleCutDeck[i] = list.get(i);
        }
        return trippleCutDeck;
    }

    public int getFinalCardNumberValue()
    {
        int botttomCard = DeckOfCards[0];
        int finalCard = DeckOfCards[53-botttomCard];
        return finalCard;
    }

    public String getFinalCardStringValue(int cardValue)
    {
        int remainder = cardValue % 26;
        return String.valueOf((char)(64+remainder));
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
