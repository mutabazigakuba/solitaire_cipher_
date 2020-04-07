package solitaire;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ASCIITest 
{

    @Test
    public void empty_string_returns_no_number() 
    {

        ASCII number = new ASCII();

        List<Integer> expectedMessage = new ArrayList<Integer>();
        List<Integer> actualList = number.convertsMessageToNumber("");

        assertEquals(expectedMessage, actualList);
    }

    @Test
    public void single_string_returns_corresponding_number() 
    {
        ASCII number = new ASCII();

        List<Integer> expectedMessage = list(1);
        List<Integer> actualList = number.convertsMessageToNumber("A");

        assertEquals(expectedMessage, actualList);
    }

    @Test
    public void abc_should_return_123() 
    {
        ASCII number = new ASCII();

        List<Integer> expectedMessage = list(1, 2, 3);
        List<Integer> actualMessage = number.convertsMessageToNumber("ABC");

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void any_word_should_be_converted_to_number() 
    {
        ASCII number = new ASCII();

        List<Integer> expectedMessage = list(8, 5, 12, 12, 15);
        List<Integer> actualMessage = number.convertsMessageToNumber("HELLO");

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void any_sentence_should_be_converted_to_number() 
    {
        ASCII number = new ASCII();

        List<Integer> expectedMessage = list(8, 5, 12, 12, 15, 23, 15, 18, 12, 4);
        List<Integer> actualMessage = number.convertsMessageToNumber("HELLOWORLD");

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void empty_list_should_return_empty_string() 
    {
        ASCII letter = new ASCII();

        String expectedMessage = "";
        String actualMessage = letter.convertsNumberToMessage(list());

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void list_with_a_1_should_return_A()
    {
        ASCII letter = new ASCII();

        String expectedMessage = "A";
        String actualMessage = letter.convertsNumberToMessage(list(1));

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void list_with_any_number_should_return_respective_letters()
    {
        ASCII letter = new ASCII();

        String expectedMessage = "HELLO";
        String actualMessage = letter.convertsNumberToMessage(list(8,5,12,12,15));

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
