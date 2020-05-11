package solitaire;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ValidateTest 
{
    
    @Test
    public void shouldNotAcceptEmptyString()
    {
        String message = "";
        Validate validate = new Validate(message);

        String expectedErrorMessage = "Empty String Not Accepted";
        validate.mValidateMessage();
        String actualErrorMessage = validate.errorMessage;

        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    public void shouldNotAcceptSpacesOnly()
    {
        String message = "  ";
        Validate validate = new Validate(message);

        String expectedErrorMessage = "Empty String Not Accepted";
        validate.mValidateMessage();
        String actualErrorMessage = validate.errorMessage;

        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    public void shouldNotAcceptMessageWithSpecialCharatersOnly()
    {
        String message = "#@$%&^";
        Validate validate = new Validate(message);

        String expectedErrorMessage = "Should Not Be Special Chararacters Only";
        validate.mValidateMessage();
        String actualErrorMessage = validate.errorMessage;

        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    public void shouldNotAcceptNumbersOnly()
    {
        String message = "12345";
        Validate validate = new Validate(message);

        String expectedErrorMessage = "Should Not Be Numbers Only";
        validate.mValidateMessage();
        String actualErrorMessage = validate.errorMessage;

        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    public void shouldNotBeSpecialCharsAndNumbersOnly()
    {
        String message = "@#134";
        Validate validate = new Validate(message);

        String expectedErrorMessage = "Should Not Be Numbers OR Special Characters only";
        validate.mValidateMessage();
        String actualErrorMessage = validate.errorMessage;

        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    public void shouldAcceptStringWithSpecialChars()
    {
        String message = "hello#$%^";
        Validate validate = new Validate(message);

        String expectedErrorMessage = "Accepted";
        validate.mValidateMessage();
        String actualErrorMessage = validate.errorMessage;

        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    public void shouldAcceptStringWithNumbers()
    {
        String message = "hello1234";
        Validate validate = new Validate(message);

        String expectedErrorMessage = "Accepted";
        validate.mValidateMessage();
        String actualErrorMessage = validate.errorMessage;

        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    public void shouldAcceptStringWithCharsOnly()
    {
        String message = "hello";
        Validate validate = new Validate(message);

        String expectedErrorMessage = "Accepted";
        validate.mValidateMessage();
        String actualErrorMessage = validate.errorMessage;

        assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}