package solitaire;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolitaireTest{

    Solitaire solitaire = new Solitaire();
    String message = "HELLO";

    @Test
    public void input_should_only_be_a_string(){

        assertEquals(message, solitaire.encoded_message("Hello"));
    }

    @Test
    public void input_should_converted_to_upper_case(){

        assertEquals(message, solitaire.changeToUpperCase("hello"));
    }

    @Test
    public void input_should_be_converted_letters_only(){

        assertEquals(message, solitaire.removeNonLetters("@he%llo!"));
    }

    @Test
    public void input_string_should_be_grouped_in_fives(){
        assertEquals("HELLO HELLO", solitaire.groupLettersIntoFives("hellohello"));
    }

    @Test
    public void input_string_should_be_grouped_in_fives_and_x_added_when_not_five(){
        assertEquals("HELLO HELLO HELXX", solitaire.groupLettersIntoFives("hellohellohel"));

    }
    
}