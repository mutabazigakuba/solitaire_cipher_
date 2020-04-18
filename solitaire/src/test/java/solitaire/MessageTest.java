package solitaire;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MessageTest
{

    @Test
    public void message_should_be_converted_into_upper_case()
    {
        Message cleanMessage = new Message("hello");

        String expectedMessage = "HELLO";
        String actualMessage = cleanMessage.mClean(); 

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void message_with_special_chars_should_be_converted_into_letters_only()
    {
        CleanMessage cleanMessage  = new cleanMessage("hel,#$lo%");

        String expectedMessage = "HELLO";
        String actualMessage = cleanMessage.mClean();

        assertEquals(expectedMessage, actualMessage);
    }

    
    @Test
    public void message_with_numbers_should_be_converted_into_letters_only()
    {
        cleanMessage solitaire = new cleanMessage("hel37lo5");

        String expectedMessage = "HELLO";
        String actualMessage = solitaire.mClean();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void message_without_space_should_be_grouped_into_fives()
    {
        cleanMessage solitaire = new cleanMessage("hellohello");

        String expectedMessage = "HELLO HELLO";
        String actualMessage = solitaire.mClean(); 

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void message_with_space_should_be_grouped_into_fives()
    {
        cleanMessage solitaire = new cleanMessage("hello hel lo");

        String expectedMessage = "HELLO HELLO";
        String actualMessage = solitaire.mClean(); 

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void message_without_space_should_be_grouped_in_fives_and_x_added_when_not_modulus_five()
    {
        cleanMessage solitaire = new cleanMessage("hellohel");

        String expectedMessage = "HELLO HELXX";
        String actualMessage = solitaire.mClean(); 

        assertEquals(expectedMessage, actualMessage);
    }

    
    @Test
    public void message_with_space_should_be_grouped_in_fives_and_x_added_when_not_modulus_five()
    {
        cleanMessage solitaire = new cleanMessage("hel loh el");

        String expectedMessage = "HELLO HELXX";
        String actualMessage = solitaire.mClean(); 

        assertEquals(expectedMessage, actualMessage);
    }   
}