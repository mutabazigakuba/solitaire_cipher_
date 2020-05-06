package solitaire;

public class Validate 
{
    public String errorMessage = "";
    private String InputMessage = "";
    public String validatedMessage = "";

    public Validate(String message)
    {
        InputMessage = message;
    }

    public void mValidateMessage()
    {
        mRemoveSpace();
        mRemoveNumbers();
        mRemoveSpecialChars();
        validatedMessage = InputMessage;
    }

    public void mRemoveSpace()
    {
        String newInputString = InputMessage.replaceAll("\\s+", "");
        InputMessage = newInputString;
        mStringIsEmpty("Empty String Not Accepted");
    }

    public void mRemoveSpecialChars()
    {
        String newInputString = InputMessage.replaceAll("[^a-zA-Z0-9]", "");
        InputMessage = newInputString;
        mStringIsEmpty("Should Not Be Special Chararacters Only");
    }

    public void mRemoveNumbers()
    {
        String newInputString = InputMessage.replaceAll("[^a-zA-Z]", "");
        InputMessage = newInputString;
        mStringIsEmpty("Should Not Be Numbers Only");
    }

    private void mStringIsEmpty(String message)
    {
        if(InputMessage.isEmpty()){
            errorMessage = message;
            System.out.println(errorMessage);
        }
        else{
            errorMessage = "Accepted";
        }
    }
}