package solitaire;

public class Validate 
{
    public String errorMessage;
    private String InputMessage;

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
        else if(mIsNumbersAndSpecialChars()){
            return errorMessage = "Should Not Be Numbers OR Special Characters only";
        }
        else{
            return errorMessage = "Accepted";
        }
    }

    private boolean mCheckIfEmpty()
    {
        return InputMessage.replaceAll("\\s+", "").isEmpty();
    }

    private boolean mCheckIfSpecialChararctersOnly()
    {
        return InputMessage.matches("[" + "-/@#!*$%^&.'_+={}()"+ "]+" );
    }

    private boolean mCheckIfNumbersOnly()
    {
        return InputMessage.matches("[0-9]+");
    }

    private boolean mIsNumbersAndSpecialChars()
    {
        return !InputMessage.matches( ".*[a-zA-Z]+.*");
    }
}