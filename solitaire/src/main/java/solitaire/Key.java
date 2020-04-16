package solitaire;

public class Key 
{
    public int[] DeckOfCards = new int[54];

    public Key(int[] _deckOfCards)
    {
        DeckOfCards = _deckOfCards;
    }
    
    public String mGenerateKey(int keyLength)
    {
        return "";
    }

    public int mSumOfDeck()
    {
        int sumOfDecks = 0;
        for (int card : DeckOfCards) {
            sumOfDecks += card;
        }
        return sumOfDecks;
    }

    public int[] mMoveJokerA(int jokerA)
    {
        for (int j = 0; j < DeckOfCards.length; j++) {
            if(DeckOfCards[j] == jokerA){
                int x = DeckOfCards[j-1];
                DeckOfCards[j-1] = jokerA;
                DeckOfCards[j] = x;
            } 
        }
        return DeckOfCards;
    }

    public int[] mMoveJokerB(int jokerB)
    {
        for (int j = 0; j < DeckOfCards.length; j++) {
            if(DeckOfCards[j] == jokerB){
                int x =  DeckOfCards[j-2];
                DeckOfCards[j-2] = jokerB;
                DeckOfCards[j] = x;
            } 
        }
        return DeckOfCards;
    }
} 
