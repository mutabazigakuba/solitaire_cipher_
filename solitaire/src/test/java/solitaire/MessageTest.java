package solitaire;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MessageTest
{

    @Test
    public void messageWithSpecialCharsShouldBeRemoved()
    {
        Message cleanMessage  = new Message("hel,#$lo%");

        String expectedMessage = "HELLO";
        String actualMessage = cleanMessage.mClean();

        assertEquals(expectedMessage, actualMessage);
    }

    
    @Test
    public void messageWithNumberShouldBeRemoved()
    {
        Message solitaire = new Message("hel37lo5");

        String expectedMessage = "HELLO";
        String actualMessage = solitaire.mClean();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void messageWithSpaceShouldBeRemoved()
    {
        Message solitaire = new Message("he  ll o hel lo");

        String expectedMessage = "HELLO HELLO";
        String actualMessage = solitaire.mClean(); 

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void messageShouldBeGroupedIntoFives()
    {
        Message solitaire = new Message("hellohello");

        String expectedMessage = "HELLO HELLO";
        String actualMessage = solitaire.mClean(); 

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void messageShouldBeModulusOfFive()
    {
        Message solitaire = new Message("h");

        String expectedMessage = "HXXXX";
        String actualMessage = solitaire.mClean(); 

        assertEquals(expectedMessage, actualMessage);
    }

    
    @Test
    public void messageWithSpaceShouldBeGroupedInFivesAndXAddedWhenNotModulusFive()
    {
        Message solitaire = new Message("hel loh el");

        String expectedMessage = "HELLO HELXX";
        String actualMessage = solitaire.mClean(); 

        assertEquals(expectedMessage, actualMessage);
    } 
    
    @Test
    public void singleStringReturnsCorrespondingNumber() 
    {
        String _message = "A";
        Message message = new Message(_message);

        int[] expectedMessage = new int[]{1};
        int[] actualList = message.mConvertsToNumber();

        assertArrayEquals(expectedMessage, actualList);
    }

    @Test
    public void abcShouldReturn123() 
    {
        String _message = "ABC";
        Message message = new Message(_message);

        int[] expectedMessage = new int[]{1, 2, 3};
        int[] actualMessage = message.mConvertsToNumber();

        assertArrayEquals(expectedMessage, actualMessage);
    }

    @Test
    public void anyWordShouldBeConvertedToNumber() 
    {
        String _message = "HELLO";
        Message message = new Message(_message);

        int[] expectedMessage = new int[]{8, 5, 12, 12, 15};
        int[] actualMessage = message.mConvertsToNumber();

        assertArrayEquals(expectedMessage, actualMessage);
    }

    @Test
    public void anySentenceShouldBeConvertedToNumber() 
    {
        String _message = "HELLOWORLD";
        Message message = new Message(_message);

        int[] expectedMessage = new int[]{8, 5, 12, 12, 15, 23, 15, 18, 12, 4};
        int[] actualMessage = message.mConvertsToNumber();

        assertArrayEquals(expectedMessage, actualMessage);
    }

    @Test
    public void emptyListShouldReturnEmptyString() 
    {
        String _message = "";
        Message message = new Message(_message);

        String expectedMessage = "";
        String actualMessage = message.mConvertsNumberToMessage(new int[0]);

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void listWithOneShouldReturnA()
    {
        String _message = "A";
        Message message = new Message(_message);

        String expectedMessage = "A";
        String actualMessage = message.mConvertsNumberToMessage(new int[]{1});

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void listWithAnyNumberShouldReturnRespectiveLetters()
    {
        String _message = "HELLO";
        Message message = new Message(_message);

        String expectedMessage = "HELLO";
        String actualMessage = message.mConvertsNumberToMessage(new int[]{8,5,12,12,15});

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void passingStringShouldReturnListOfNumbersThenListShouldReturnBackToOrignalString()
    {
        String _message = "HELLOWORLD";
        Message message = new Message(_message);

        String expectedMessage  = "HELLOWORLD";
        int[] list = message.mConvertsToNumber();
        String actualMessage = message.mConvertsNumberToMessage(list);

        assertEquals(expectedMessage, actualMessage);
    }
}