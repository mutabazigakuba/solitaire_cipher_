package solitaire;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolitaireTest
{
 @Test
 public void encryptesMessage()
 {
    String message = "HELLO WORLD@#@#";

    int [] _deckOfCards = new int[53];
    GenerateKey generateKey = new GenerateKey(_deckOfCards);
    String key = generateKey.mGenerateKey(message.length());

    Converter converter = new Converter();

    Solitaire solitaire = new Solitaire(message, key, converter);

    assertEquals(expectedMessage, actualMessage);
 }

}