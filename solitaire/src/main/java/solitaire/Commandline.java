package solitaire;

public class Commandline {

    public String userInput = "";
    private int[] deck = new int[54];

    public Commandline(String message) {
        userInput = message;
    }

    public void mRunConsole() 
    {
        generateDeckOfCards();
        mDisplayEncryptInput();
        generateDeckOfCards();
        mDisplayDecryptInput();
    }

    private void mDisplayEncryptInput() {
        userInput = mIntializeSolitaire().mEncryptMessage();
        System.out.println("Encrypted message is " + userInput);
    }

    private void mDisplayDecryptInput() {
        userInput = mIntializeSolitaire().mDecryptMessage();
        System.out.println("Decrpyted message is " + userInput);
    }

    private void generateDeckOfCards() {
        int j = 54;
        for (int i = 0; i < deck.length; i++) {
            deck[i] = j;
            j--;
        }
    }

    private Solitaire mIntializeSolitaire() {
        Key generatedkKey = new Key(deck);
        Message cleanedMessage = new Message(userInput);
        Solitaire solitaire = new Solitaire(generatedkKey, cleanedMessage);
        return solitaire;
    }
}
