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
            if(i==52 || i==53)
            {
                deckOfCards[i]=53;
            }
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
} 