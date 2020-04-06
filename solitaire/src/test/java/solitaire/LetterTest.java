package solitaire;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LetterTest {

    @Test
    public void letter_class_should_be_created()
    {
        Letter letter = new Letter();

        assertEquals(true, letter instanceof Letter);
    }

    @Test
    public void convert_number_to_string_function_should_return_string()
    {
        Letter letter = new Letter();

        String expectedMessage = "";
        String actualMessage = letter.convertMessage(list());

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void message_numbers_should_be_greaterthan_1()
    {
        Letter letter = new Letter();

        String expectedMessage = "check your inputs please";
        String actualMessage = letter.convertMessage(list(0));

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void list_of_numbers_should_be_returned_as_a_single_string()
    {
        Letter letter = new Letter();

        String expectedMessage = "ABC";
        String actualMessage = letter.convertMessage(list(1,2,3));

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void any_list_of_numbers_returns_a_string()
    {
        Letter letter = new Letter();

        String expectedMessage = "HELLO";
        String actualMessage = letter.convertMessage(list(8,5,12,12,15));

        assertEquals(expectedMessage, actualMessage);
    }

    private List<Integer> list(int... number)
    {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < number.length; i++) {
            list.add(number[i]);
        }
        return list;
    }
}