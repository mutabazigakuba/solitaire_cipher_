package solitaire;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolitaireTest{

    @Test
    public void solitaire_class_should_be_creatred(){

        Solitaire solitaire = new Solitaire();

        assertEquals(true, solitaire instanceof Solitaire);
    }

    @Test
    public void input_should_only_be_a_string(){

        Solitaire solitaire = new Solitaire();

        assertEquals("Hello", solitaire.encoded_message("Hello"));
    }
    
}