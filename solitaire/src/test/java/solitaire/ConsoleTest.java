package solitaire;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConsoleTest
{

    @Test
    public void shouldTakeInUserInput()
    {
        Console console = new Console();
        String inputMessage = "";

        String expectedMessage = inputMessage;
        String actualMessage = console.userInput;

        assertEquals(expectedMessage, actualMessage);
    }
}