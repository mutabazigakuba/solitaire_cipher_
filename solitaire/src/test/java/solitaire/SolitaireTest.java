package solitaire;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolitaireTest
{

    @Test
    public void message_should_be_converted_into_upper_case()
    {
        Solitaire solitaire = new Solitaire();

        String expectedMessage = "HELLO";
        String actualMessage = solitaire.encoded_message("hello"); 

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void message_with_special_chars_should_be_converted_into_letters_only()
    {
        Solitaire solitaire = new Solitaire();

        String expectedMessage = "HELLO";
        String actualMessage = solitaire.encoded_message("hel,#$lo%");

        assertEquals(expectedMessage, actualMessage);
    }

    
    @Test
    public void message_with_numbers_should_be_converted_into_letters_only()
    {
        Solitaire solitaire = new Solitaire();

        String expectedMessage = "HELLO";
        String actualMessage = solitaire.encoded_message("hel37lo5");

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void message_without_space_should_be_grouped_into_fives()
    {
        Solitaire solitaire = new Solitaire();

        String expectedMessage = "HELLO HELLO";
        String actualMessage = solitaire.encoded_message("hellohello"); 

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void message_with_space_should_be_grouped_into_fives_when_message_has_space()
    {
        Solitaire solitaire = new Solitaire();

        String expectedMessage = "HELLO HELLO";
        String actualMessage = solitaire.encoded_message("hello hel lo"); 

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void message_should_be_grouped_in_fives_and_x_added_when_not_equal_five()
    {
        Solitaire solitaire = new Solitaire();

        String expectedMessage = "HELLO HELXX";
        String actualMessage = solitaire.encoded_message("hel lo hel"); 

        assertEquals(expectedMessage, actualMessage);

    }
    
}