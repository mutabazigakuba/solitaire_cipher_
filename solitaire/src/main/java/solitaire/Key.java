package solitaire;

public class Key 
{
    public int[] deckOfCards = new int[54];
    
    public String mGenerateKey(int keyLength)
    {
        return "";
    }

    private int[] mCreateDeckOfCardsValues()
    {
        for (int i = 0; i < deckOfCards.length; i++) 
        {
            deckOfCards[i] = i+1;
        }
        return deckOfCards;
    }

    public int mSumOfDeck()
    {
        int sumOfDecks = 0;
        int[] deckOfCards = mCreateDeckOfCardsValues();
        for (int card : deckOfCards) {
            sumOfDecks += card;
        }
        return sumOfDecks;
    }

    public int[] mMoveJokerA(int jokerA)
    {
        int[] newDeck = mCreateDeckOfCardsValues();
        for (int j = 0; j < newDeck.length; j++) {
            if(newDeck[j] == jokerA){
                int x = newDeck[j-1];
                newDeck[j-1] = jokerA;
                newDeck[j] = x;
            } 
        }
        return newDeck;
    }

    public int[] mMoveJokerB(int jokerB)
    {
        int[] newDeck = mCreateDeckOfCardsValues();
        for (int j = 0; j < newDeck.length; j++) {
            if(newDeck[j] == jokerB){
                int x =  newDeck[j-2];
                newDeck[j-2] = jokerB;
                newDeck[j] = x;
            } 
        }
        return newDeck;
    }
} 