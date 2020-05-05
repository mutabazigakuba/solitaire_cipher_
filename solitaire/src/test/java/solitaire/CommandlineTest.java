package solitaire;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CommandlineTest
{

    @Test
    public void shouldTakeInUserInput()
    {
        Commandline cmd = new Commandline();
        String inputMessage = "";

        String expectedMessage = inputMessage;
        String actualMessage = cmd.userInput;

        assertEquals(expectedMessage, actualMessage);
    }
}