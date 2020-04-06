package solitaire;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class NumberTest {

    @Test
    public void string_to_number_should_return_list()
    {
        Number number = new Number("");

        List<Integer> expectedMessage = list();
        List<Integer> actualMessage = number.convertedMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void abc_should_return_123()
    {
        Number number = new Number("abc");

        List<Integer> expectedMessage = list(1,2,3,24,24);
        List<Integer> actualMessage = number.convertedMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void any_word_should_be_converted_to_number()
    {
        Number number = new Number("hello");

        List<Integer> expectedMessage = list(8,5,12,12,15);
        List<Integer> actualMessage = number.convertedMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void any_sentence_should_be_converted_to_number()
    {
        Number number = new Number("Hello world");

        List<Integer> expectedMessage = list(8,5,12,12,15,23,15,18,12,4);
        List<Integer> actualMessage = number.convertedMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void any_sentence_with_special_characters_should_return_numbers()
    {
        Number number  = new Number("#$%23he866*ll+323o");

        List<Integer> expectedMessage = list(8,5,12,12,15);
        List<Integer> actualMessage = number.convertedMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    private List<Integer> list(int... number)
    {
        List<Integer> list = new ArrayList<Integer>();
        if(number.length ==0)
        {
            return list;
        }
        for (int i = 0; i < number.length; i++) 
        {
            list.add(number[i]);
        }
        return list;
    }
}
