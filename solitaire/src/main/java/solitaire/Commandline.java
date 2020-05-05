package solitaire;

import java.util.Scanner;

public class Commandline 
{

    Scanner scanner = new Scanner(System.in);
    public String userInput = "";
    private int[] deck = new int[54];
    private int numberOfTimes = 1;

    public void mRunConsole()
    {
        for (int i = 0; i < numberOfTimes; i++) {
            mGetUserInput();
            generateDeckOfCards();
            mDisplayEncryptInput();
            generateDeckOfCards();
            mDisplayDecryptInput();
            mContinueCipher();
        }
    }

    public void mGetUserInput()
    {
        System.out.println("======================");
        System.out.println("Enter message");
        userInput = scanner.nextLine();
        if(userInput.isEmpty())
        {
            System.out.println("Enter a valid message please!");
        }
        else
        {
            System.out.println("Your message is "+userInput);
        }
    }

    private void mDisplayEncryptInput()
    {
        userInput = mIntializeSolitaire().mEncryptMessage();
        System.out.println("Encrypted message is "+userInput);
    }

    private void mDisplayDecryptInput()
    {
        userInput = mIntializeSolitaire().mDecryptMessage();
        System.out.println("Decrpyted message is "+userInput);
    }

    private void mContinueCipher()
    {
        System.out.println("======================");
        System.out.println("Add another message? ");
        System.out.println("Type Y/N ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        
        switch(answer){
            case "Y":
                numberOfTimes += 1;
                break;
            
            case "N":
                numberOfTimes -= 1;
                scanner.close();
                break;
            
            default: 
                System.out.println("Unknown Input! ");
                scanner.close();
        }
    }

    private void generateDeckOfCards()
    {
        int j = 54;
        for (int i = 0; i < deck.length; i++) 
        {
            deck[i] = j;
            j--;
        }
    }

    private Solitaire mIntializeSolitaire()
    {
        Key generatedkKey = new Key(deck);
        Message message = new Message(userInput);
        Solitaire solitaire = new Solitaire(generatedkKey, message);
        return solitaire;
    }
}
