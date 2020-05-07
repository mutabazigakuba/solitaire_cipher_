package solitaire;

public class Commandline {

    public String userInput = "";

    public Commandline(String message) {
        userInput = message;
    }

    public void mRunConsole() 
    {
        mDisplayEncryptInput();
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

    private Solitaire mIntializeSolitaire() {
        Key generatedkKey = new Key(new int[54]);
        Message cleanedMessage = new Message(userInput);
        Solitaire solitaire = new Solitaire(generatedkKey, cleanedMessage);
        return solitaire;
    }
}
