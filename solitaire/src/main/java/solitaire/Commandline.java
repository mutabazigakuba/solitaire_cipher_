package solitaire;

import java.util.Scanner;

public class Commandline 
{

    public String userInput = "";
    private int[] deck = new int[54];


    public void mRunConsole()
    {
        mGetUserInput();
        generateDeckOfCards();
        mDisplayEncryptInput();
        generateDeckOfCards();
        mDisplayDecryptInput();
    }

    public void mGetUserInput()
    {
        Scanner scanner = new Scanner(System.in);
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
        scanner.close();
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
