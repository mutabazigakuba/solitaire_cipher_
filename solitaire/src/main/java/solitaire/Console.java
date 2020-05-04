package solitaire;

import java.util.Scanner;

public class Console 
{

    public String userInput = "";
    private int[] deck = new int[54];


    public void mRunConsole()
    {
        mGetUserInput();
        generateDeckOfCards();
        mEncryptInput();
        generateDeckOfCards();
        mDecryptInput();
    }

    private void mGetUserInput()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter message");
        userInput = scanner.nextLine();
        if(userInput.isBlank())
        {
            System.out.println("Enter a valid message please!");
        }
        else
        {
            System.out.println("Your message is "+userInput);
        }
        scanner.close();
    }

    private void mEncryptInput()
    {
        Key generatedkKey = new Key(deck);
        Message message = new Message(userInput);
        Solitaire solitaire = new Solitaire(generatedkKey, message);
        userInput = solitaire.mEncryptMessage();
        System.out.println("Encrypted message is "+userInput);
    }

    private void mDecryptInput()
    {
        Key generatedkKey = new Key(deck);
        Message message = new Message(userInput);
        Solitaire solitaire = new Solitaire(generatedkKey, message);
        userInput = solitaire.mDecryptMessage();
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
}