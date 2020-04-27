package solitaire;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolitaireTest 
{

   @Test
   public void encryptesMessageWithOutSpecialChars() 
   {
      String message = "HELLO";
      int[] _deckOfCards = mCreateDeckOfCards();
      GenerateKey generateKey = new GenerateKey(_deckOfCards);
      Message cleanMessage = new Message(message);
      Solitaire solitaire = new Solitaire(generateKey, cleanMessage);

      String expectedMessage = "LFLRQ";
      String actualMessage = solitaire.mEncryptMessage();

      assertEquals(expectedMessage, actualMessage);
   }
 
   @Test
   public void keyAndMessageShouldBeOfSameLength() 
   {
      String message = "";
      int[] _deckOfCards = mCreateDeckOfCards();
      GenerateKey generateKey = new GenerateKey(_deckOfCards);

      int expectedKeyLength = generateKey.mGenerateKey(message).length();
      int actualKeyLength = message.length();

      assertEquals(expectedKeyLength, actualKeyLength);
   }

   @Test
   public void decryptMessage() 
   {
      String message = "JGOQW";
      int[] _deckOfCards = mCreateDeckOfCards();
      GenerateKey generateKey = new GenerateKey(_deckOfCards);
      Message cleanMessage = new Message(message);
      Solitaire solitaire = new Solitaire(generateKey, cleanMessage);
      String dencryptedMessage = "FFOKU";

      String expectedDencryptedMessage = dencryptedMessage;
      String actualDencryptedMessage = solitaire.mDecryptMessage();

      assertEquals(expectedDencryptedMessage, actualDencryptedMessage);
   }

   private int[] mCreateDeckOfCards() 
   {
      int j = 54;
      int[] deck = new int[54];
      for (int i = 0; i < deck.length; i++) 
      {
          deck[i] = j;
          j--;
      }
      return deck;
  }

}