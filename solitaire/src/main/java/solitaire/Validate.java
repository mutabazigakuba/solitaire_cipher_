package solitaire;

public class Validate 
{
    public String errorMessage = "";
    private String InputMessage = "";

    public Validate(String message)
    {
        InputMessage = message;
    }

    public String mValidateMessage()
    {
        if(mCheckIfEmpty()){
            return errorMessage = "Empty String Not Accepted";
        }
        else if (mCheckIfSpecialChararctersOnly()){
            return errorMessage = "Should Not Be Special Chararacters Only";
        }
        else if (mCheckIfNumbersOnly()){
            return errorMessage = "Should Not Be Numbers Only";
        }
        else if(mCheckIfNumbersAndSpecialChars()){
            return errorMessage = "Should Not Be Numbers OR Special Characters only";
        }
        else{
            return errorMessage = "Accepted";
        }
    }

    private boolean mCheckIfEmpty()
    {
        InputMessage = InputMessage.replaceAll("\\s+", "");
        if(InputMessage.isBlank()){
            return true;
        }
        return false;
    }

    private boolean mCheckIfSpecialChararctersOnly()
    {
        String specialCharacters = "[" + "-/@#!*$%^&.'_+={}()"+ "]+" ;
        if(InputMessage.matches(specialCharacters)){
            return true;
        }
        return false;
    }

    private boolean mCheckIfNumbersOnly()
    {
        String numbers = "[0-9]+" ;
        if(InputMessage.matches(numbers)){
            return true;
        }
        return false;
    }

    private boolean mCheckIfNumbersAndSpecialChars()
    {
        String numbersAndSpecialChars = ".*[a-zA-Z]+.*";
        if(InputMessage.matches(numbersAndSpecialChars)){
            return false;
        }
        return true;
    }
}