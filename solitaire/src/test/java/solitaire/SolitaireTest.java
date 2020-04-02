package solitaire;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolitaireTest
{

    @Test
    public void message_should_be_converted_into_upper_case()
    {

        //arrange
        Solitaire solitaire = new Solitaire();

        //act
        String expectedMessage = "HELLO";
        String actualMessage = solitaire.encoded_message("hello"); 

        //assert
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void message_should_be_converted_into_letters_only()
    {

        //arrange
        Solitaire solitaire = new Solitaire();

        //act
        String expectedMessage = "HELLO";
        String actualMessage = solitaire.encoded_message("hel#$lo%"); 

        //assert
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void message_should_be_grouped_into_fives()
    {

        //arrange
        Solitaire solitaire = new Solitaire();

        //act
        String expectedMessage = "HELLO HELLO";
        String actualMessage = solitaire.encoded_message("hellohello"); 

        //assert
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void message_should_be_grouped_in_fives_and_x_added_when_not_equal_five()
    {

        //arrange
        Solitaire solitaire = new Solitaire();

        //act
        String expectedMessage = "HELLO HELXX";
        String actualMessage = solitaire.encoded_message("hello hel"); 

        //assert
        assertEquals(expectedMessage, actualMessage);

    }
    
}