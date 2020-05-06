package solitaire;

import java.util.Scanner;

public class App 
{
    public static void main(String[] args) 
    {
        int numberOfTimes = 1;
        for (int i = 0; i < numberOfTimes; i++) 
        {
            System.out.println("Enter message");
            Scanner scanner = new Scanner(System.in);

            Validate validate = new Validate(scanner.nextLine());
            validate.mValidateMessage();
            String validatedMessage = validate.validatedMessage;

            Commandline cmd = new Commandline(validatedMessage);
            cmd.mRunConsole();

            System.out.println("Add another message? ");
            System.out.println("Type Y/N ");
            Scanner scanner2 = new Scanner(System.in);

            switch (scanner2.nextLine()) 
            {
                case "Y":
                    numberOfTimes += 1;
                    break;

                case "N":
                    numberOfTimes -= 1;
                    scanner.close();
                    break;

                default:
                    System.out.println("Unknown Input! ");
                    scanner2.close();
                    scanner.close();
            }
        }

    }
}