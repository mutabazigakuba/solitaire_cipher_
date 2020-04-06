package solitaire;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolitaireTest
{

    @Test
    public void message_should_be_converted_into_upper_case()
    {
        Solitaire solitaire = new Solitaire("hello");

        String expectedMessage = "HELLO";
        String actualMessage = solitaire.encoded_message(); 

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void message_with_special_chars_should_be_converted_into_letters_only()
    {
        Solitaire solitaire = new Solitaire("hel,#$lo%");

        String expectedMessage = "HELLO";
        String actualMessage = solitaire.encoded_message();

        assertEquals(expectedMessage, actualMessage);
    }

    
    @Test
    public void message_with_numbers_should_be_converted_into_letters_only()
    {
        Solitaire solitaire = new Solitaire("hel37lo5");

        String expectedMessage = "HELLO";
        String actualMessage = solitaire.encoded_message();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void message_without_space_should_be_grouped_into_fives()
    {
        Solitaire solitaire = new Solitaire("hellohello");

        String expectedMessage = "HELLO HELLO";
        String actualMessage = solitaire.encoded_message(); 

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void message_with_space_should_be_grouped_into_fives()
    {
        Solitaire solitaire = new Solitaire("hello hel lo");

        String expectedMessage = "HELLO HELLO";
        String actualMessage = solitaire.encoded_message(); 

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void message_without_space_should_be_grouped_in_fives_and_x_added_when_not_modulus_five()
    {
        Solitaire solitaire = new Solitaire("hellohel");

        String expectedMessage = "HELLO HELXX";
        String actualMessage = solitaire.encoded_message(); 

        assertEquals(expectedMessage, actualMessage);
    }

    
    @Test
    public void message_with_space_should_be_grouped_in_fives_and_x_added_when_not_modulus_five()
    {
        Solitaire solitaire = new Solitaire("hel loh el");

        String expectedMessage = "HELLO HELXX";
        String actualMessage = solitaire.encoded_message(); 

        assertEquals(expectedMessage, actualMessage);
    }
    
}