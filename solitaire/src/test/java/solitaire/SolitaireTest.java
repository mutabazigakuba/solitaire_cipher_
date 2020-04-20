package solitaire;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolitaireTest {

   // encrpyt

   @Test
   public void encryptesMessage() {
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
   public void messageShouldBeGivenInAString() {
      String message = "";
      int[] _deckOfCards = new int[54];
      GenerateKey generateKey = new GenerateKey(_deckOfCards);
      Message cleanMessage = new Message(message);
      Solitaire solitaire = new Solitaire(message, generateKey, cleanMessage);

      String expectedMessage = "";
      String actualMessage = solitaire.mEncryptMessage();

      assertEquals(expectedMessage, actualMessage);
   }

   @Test
   public void keyShouldBeGivenInString() {
      String message = "";
      int[] _deckOfCards = new int[54];
      GenerateKey generateKey = new GenerateKey(_deckOfCards);
      Message cleanMessage = new Message(message);
      Solitaire solitaire = new Solitaire(message, generateKey, cleanMessage);

      String expectedKey = "";
      String actualKey = solitaire.mEncryptMessage();

      assertEquals(expectedKey, actualKey);
   }

   // Decrpyt

   @Test
   public void messageShouldBeGivenAsString() {
      String message = "";
      int[] _deckOfCards = new int[54];
      GenerateKey generateKey = new GenerateKey(_deckOfCards);
      Message cleanMessage = new Message(message);
      Solitaire solitaire = new Solitaire(message, generateKey, cleanMessage);

      String expectedMessage = "";
      String actualMessage = solitaire.mDecryptMessage();

      assertEquals(expectedMessage, actualMessage);
   }

   @Test
   public void keyShouldBeGivenAsString() {
      String message = "";
      int[] _deckOfCards = new int[54];
      GenerateKey generateKey = new GenerateKey(_deckOfCards);
      Message cleanMessage = new Message(message);
      Solitaire solitaire = new Solitaire(message, generateKey, cleanMessage);

      String expectedKey = "";
      String actualKey = solitaire.mDecryptMessage();

      assertEquals(expectedKey, actualKey);
   }

   @Test
   public void keyAndMessageShouldBeOfSameLength() {
      String message = "";
      int[] _deckOfCards = new int[54];
      GenerateKey generateKey = new GenerateKey(_deckOfCards);

      int expectedKeyLength = generateKey.mGenerateKey(message).length();
      int actualKeyLength = message.length();

      assertEquals(expectedKeyLength, actualKeyLength);
   }

   @Test
   public void decryptMessage() {
      String message = "QYUGY";
      int[] _deckOfCards = new int[54];
      GenerateKey generateKey = new GenerateKey(_deckOfCards);
      Message cleanMessage = new Message(message);
      Solitaire solitaire = new Solitaire(message, generateKey, cleanMessage);
      String dencryptedMessage = "HELLO";

      String expectedDencryptedMessage = dencryptedMessage;
      String actualDencryptedMessage = solitaire.mDecryptMessage();

      assertEquals(expectedDencryptedMessage, actualDencryptedMessage);
   }

}