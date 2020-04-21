package solitaire;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolitaireTest {

   @Test
   public void encryptesMessageWithOutSpecialChars() 
   {
      String message = "HELLO";
      int[] _deckOfCards = new int[54];
      GenerateKey generateKey = new GenerateKey(_deckOfCards);
      Message cleanMessage = new Message(message);
      Solitaire solitaire = new Solitaire(message, generateKey, cleanMessage);

      String expectedMessage = "QYUGY";
      String actualMessage = solitaire.mEncryptMessage();

      assertEquals(expectedMessage, actualMessage);
   }
 
   @Test
   public void encryptesMessageWithSpecialChars()
   {
      String message = "HEL 34LO WORL32@#d";
      int[] _deckOfCards = new int[54];
      GenerateKey generateKey = new GenerateKey(_deckOfCards);
      Message cleanMessage = new Message(message);
      Solitaire solitaire = new Solitaire(message, generateKey, cleanMessage);

      String expectedMessage = "QYUGYPIOES";
      String actualMessage = solitaire.mEncryptMessage();

      assertEquals(expectedMessage, actualMessage);
   }

   @Test
   public void keyAndMessageShouldBeOfSameLength() 
   {
      String message = "HELLO";
      int[] _deckOfCards = new int[54];
      GenerateKey generateKey = new GenerateKey(_deckOfCards);

      int expectedLength = 5;
      int actualKeyLength = generateKey.mGenerateKey(message).length();

      assertEquals(expectedLength, actualKeyLength);
      assertEquals(expectedLength, message.length());
   }

   @Test
   public void decryptMessage() 
   {
      String message = "QYUGY";
      int[] _deckOfCards = new int[54];
      GenerateKey generateKey = new GenerateKey(_deckOfCards);
      Message cleanMessage = new Message(message);
      Solitaire solitaire = new Solitaire(message, generateKey, cleanMessage);

      String expectedDencryptedMessage = "HELLO";
      String actualDencryptedMessage = solitaire.mDecryptMessage();

      assertEquals(expectedDencryptedMessage, actualDencryptedMessage);
   }

   @Test
   public void decryptesMessage() 
   {
      String message = "CLEPK HHNIY CFPWH FDFEH";
      int[] _deckOfCards = new int[54];
      GenerateKey generateKey = new GenerateKey(_deckOfCards);
      Message cleanMessage = new Message(message);
      Solitaire solitaire = new Solitaire(message, generateKey, cleanMessage);

      String expectedMessage = "YOURCIPHERISWORKINGX";
      String actualMessage = solitaire.mEncryptMessage();

      assertEquals(expectedMessage, actualMessage);
   }
   
}