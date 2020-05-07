package solitaire;

import java.util.Scanner;

public class Setup 
{
    Scanner scanner = new Scanner(System.in);

    public void mStart() 
    {
        int numberOfTimes = 0;

        while(numberOfTimes < 1)
        {
            
            String InputMessage = mGetInput("Enter Message");
            Validate validate = new Validate(InputMessage);
            validate.mValidateMessage();

            if (validate.errorMessage == "Accepted") 
            {
                Commandline cmd = new Commandline(InputMessage);
                cmd.mRunConsole();

                String Answer = mGetInput("Add another message? Type Y/N");
                switch (Answer) {
                    case "Y":
                        numberOfTimes = 0;
                        break;

                    case "N":
                        numberOfTimes = 1;
                        break;

                    default:
                        System.out.println("Unknown Input!");
                }
            } 
            else {
                System.out.println(validate.errorMessage);
            }
        }
    }

    private String mGetInput(String question)
    {
        System.out.println(question);
        return scanner.nextLine();    
    }
}