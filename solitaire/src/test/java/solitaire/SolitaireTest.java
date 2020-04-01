package solitaire;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolitaireTest{

    Solitaire solitaire = new Solitaire();

    @Test
    public void input_should_only_be_a_string(){

        assertEquals("HELLO", solitaire.encoded_message("Hello"));
    }

    @Test
    public void input_should_converted_to_upper_case(){

        assertEquals("HELLO", solitaire.encoded_message("hello"));
    }

    @Test
    public void input_should_be_converted_letters_only(){

        assertEquals("HELLO", solitaire.encoded_message("@he%llo!"));
    }
    
}