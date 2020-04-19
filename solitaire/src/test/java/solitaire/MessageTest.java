package solitaire;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

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
        Message cleanMessage  = new Message("hel,#$lo%");

        String expectedMessage = "HELLO";
        String actualMessage = cleanMessage.mClean();

        assertEquals(expectedMessage, actualMessage);
    }

    
    @Test
    public void message_with_numbers_should_be_converted_into_letters_only()
    {
        Message solitaire = new Message("hel37lo5");

        String expectedMessage = "HELLO";
        String actualMessage = solitaire.mClean();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void message_without_space_should_be_grouped_into_fives()
    {
        Message solitaire = new Message("hellohello");

        String expectedMessage = "HELLO HELLO";
        String actualMessage = solitaire.mClean(); 

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void message_with_space_should_be_grouped_into_fives()
    {
        Message solitaire = new Message("hello hel lo");

        String expectedMessage = "HELLO HELLO";
        String actualMessage = solitaire.mClean(); 

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void message_without_space_should_be_grouped_in_fives_and_x_added_when_not_modulus_five()
    {
        Message solitaire = new Message("hellohel");

        String expectedMessage = "HELLO HELXX";
        String actualMessage = solitaire.mClean(); 

        assertEquals(expectedMessage, actualMessage);
    }

    
    @Test
    public void message_with_space_should_be_grouped_in_fives_and_x_added_when_not_modulus_five()
    {
        Message solitaire = new Message("hel loh el");

        String expectedMessage = "HELLO HELXX";
        String actualMessage = solitaire.mClean(); 

        assertEquals(expectedMessage, actualMessage);
    } 
    
    //convert

    @Test
    public void single_string_returns_corresponding_number() 
    {
        String _message = "A";
        Message message = new Message(_message);

        List<Integer> expectedMessage = list(1);
        List<Integer> actualList = message.mConvertsToNumber();

        assertEquals(expectedMessage, actualList);
    }

    @Test
    public void abc_should_return_123() 
    {
        String _message = "ABC";
        Message message = new Message(_message);

        List<Integer> expectedMessage = list(1, 2, 3);
        List<Integer> actualMessage = message.mConvertsToNumber();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void any_word_should_be_converted_to_number() 
    {
        String _message = "HELLO";
        Message message = new Message(_message);

        List<Integer> expectedMessage = list(8, 5, 12, 12, 15);
        List<Integer> actualMessage = message.mConvertsToNumber();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void any_sentence_should_be_converted_to_number() 
    {
        String _message = "HELLOWORLD";
        Message message = new Message(_message);

        List<Integer> expectedMessage = list(8, 5, 12, 12, 15, 23, 15, 18, 12, 4);
        List<Integer> actualMessage = message.mConvertsToNumber();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void empty_list_should_return_empty_string() 
    {
        String _message = "";
        Message message = new Message(_message);

        String expectedMessage = "";
        String actualMessage = message.mConvertsNumberToMessage(list());

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void list_with_a_1_should_return_A()
    {
        String _message = "A";
        Message message = new Message(_message);

        String expectedMessage = "A";
        String actualMessage = message.mConvertsNumberToMessage(list(1));

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void list_with_any_number_should_return_respective_letters()
    {
        String _message = "HELLO";
        Message message = new Message(_message);

        String expectedMessage = "HELLO";
        String actualMessage = message.mConvertsNumberToMessage(list(8,5,12,12,15));

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void passing_a_string_should_return_list_of_numbers_then_list_should_return_back_to_orignal_string()
    {
        String _message = "HELLOWORLD";
        Message message = new Message(_message);

        String expectedMessage  = "HELLOWORLD";
        List<Integer> list = message.mConvertsToNumber();
        String actualMessage = message.mConvertsNumberToMessage(list);

        assertEquals(expectedMessage, actualMessage);
    }

    private List<Integer> list(int... number) {
        List<Integer> list = new ArrayList<Integer>();
        if (number.length == 0) {
            return list;
        }
        for (int i = 0; i < number.length; i++) {
            list.add(number[i]);
        }
        return list;
    }
}