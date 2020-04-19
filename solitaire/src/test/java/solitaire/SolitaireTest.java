package solitaire;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolitaireTest {
   @Test
   public void encryptesMessage() {
      String message = "HELLO WORLD@#@#";

      int[] _deckOfCards = new int[53];
      GenerateKey generateKey = new GenerateKey(_deckOfCards);
      Message cleanMessage = new Message(message);
      Solitaire solitaire = new Solitaire(message, generateKey, cleanMessage);

      String expectedMessage = "FGSWK FFDKK";
      String actualMessage = solitaire.mDencryptMessage();

      assertEquals(expectedMessage, actualMessage);
   }

   // encrpyt
   @Test
   public void messageShouldBeGivenInAString() {
      String message = "";
      int[] _deckOfCards = new int[53];
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
      int[] _deckOfCards = new int[53];
      GenerateKey generateKey = new GenerateKey(_deckOfCards);
      Message cleanMessage = new Message(message);
      Solitaire solitaire = new Solitaire(message, generateKey, cleanMessage);

      String expectedKey = "";
      String actualKey = solitaire.mEncryptMessage();

      assertEquals(expectedKey, actualKey);
   }

   @Test
   public void encryptMessageShouldBeTheSumOfMessageAndKey() {
      String message = "G";
      int[] _deckOfCards = new int[53];
      GenerateKey generateKey = new GenerateKey(_deckOfCards);
      Message cleanMessage = new Message(message);
      Solitaire solitaire = new Solitaire(message, generateKey, cleanMessage);
      String encryptedMessage = "B";

      String expectedEncryptedMessage = encryptedMessage;
      String actualEncryptedMessage = solitaire.mEncryptMessage();

      assertEquals(expectedEncryptedMessage, actualEncryptedMessage);
   }

   // Decrpyt

   @Test
   public void messageShouldBeGivenAsString() {
      String message = "";
      int[] _deckOfCards = new int[53];
      GenerateKey generateKey = new GenerateKey(_deckOfCards);
      Message cleanMessage = new Message(message);
      Solitaire solitaire = new Solitaire(message, generateKey, cleanMessage);

      String expectedMessage = "";
      String actualMessage = solitaire.mDencryptMessage();

      assertEquals(expectedMessage, actualMessage);
   }

   @Test
   public void keyShouldBeGivenAsString() {
      String message = "";
      int[] _deckOfCards = new int[53];
      GenerateKey generateKey = new GenerateKey(_deckOfCards);
      Message cleanMessage = new Message(message);
      Solitaire solitaire = new Solitaire(message, generateKey, cleanMessage);

      String expectedKey = "";
      String actualKey = solitaire.mDencryptMessage();

      assertEquals(expectedKey, actualKey);
   }

   @Test
   public void keyAndMessageShouldBeOfSameLength() {
      String message = "";
      int[] _deckOfCards = new int[53];
      GenerateKey generateKey = new GenerateKey(_deckOfCards);

      int expectedKeyLength = generateKey.mGenerateKey(message).length();
      int actualKeyLength = message.length();

      assertEquals(expectedKeyLength, actualKeyLength);
   }

   @Test
   public void dencryptMessageShouldBeTheDifferenceOfMessageAndKey() {
      String message = "E";
      int[] _deckOfCards = new int[53];
      GenerateKey generateKey = new GenerateKey(_deckOfCards);
      Message cleanMessage = new Message(message);
      Solitaire solitaire = new Solitaire(message, generateKey, cleanMessage);
      String dencryptedMessage = "B";

      String expectedDencryptedMessage = dencryptedMessage;
      String actualDencryptedMessage = solitaire.mDencryptMessage();

      assertEquals(expectedDencryptedMessage, actualDencryptedMessage);
   }

}