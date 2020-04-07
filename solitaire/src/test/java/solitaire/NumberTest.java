package solitaire;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class NumberTest {


    @Test 
    public void emptystringreturnsnonumber(){
      String message = "";

      List<Integer> expectedListofNumber = new ArrayList<Integer>();
      Number number = new Number(message);
      List<Integer> actualList = number.convertsMessageToNumber();

      assertEquals(expectedListofNumber, actualList);
    }

    @Test 
    public void singlestringreturnscorrespondingnumber(){
      String message = "A";

      List<Integer> expectedListofNumber = list(1);
      Number number = new Number(message);
      List<Integer> actualList = number.convertsMessageToNumber();

      assertEquals(expectedListofNumber, actualList);
    }

    @Test
    public void abc_should_return_123()
    {
        Number number = new Number("ABC");

        List<Integer> expectedMessage = list(1,2,3);
        List<Integer> actualMessage = number.convertsMessageToNumber();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void any_word_should_be_converted_to_number()
    {
        Number number = new Number("HELLO");

        List<Integer> expectedMessage = list(8,5,12,12,15);
        List<Integer> actualMessage = number.convertsMessageToNumber();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void any_sentence_should_be_converted_to_number()
    {
        Number number = new Number("HELLOWORLD");

        List<Integer> expectedMessage = list(8,5,12,12,15,23,15,18,12,4);
        List<Integer> actualMessage = number.convertsMessageToNumber();

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
