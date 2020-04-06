package solitaire;

import java.util.Arrays;

public class Solitaire 
{
    private String _message;
    public Solitaire(String message)
    {
        _message = message;
    }

    public String encoded_message() 
    {
        _message = removeNonLetters();
        _message = changeToUpperCase();
        _message = groupLettersIntoFives();
        _message = AddXs();
        return _message;
    }

    private String removeNonLetters() 
    {
        return _message.replaceAll("[^\\p{L}\\p{Z}]","");
    }

    private String changeToUpperCase() 
    {
        return _message.toUpperCase();
    }

    private String groupLettersIntoFives() 
    {
        return Arrays.toString(_message.replaceAll("\\s+", "").split("(?<=\\G.{" + 5 + "})"))
            .replaceAll("[^\\p{L}\\p{Z}]","");
    }

    private String AddXs()
    {
        String removeSpace = _message.replaceAll("\\s+", "");
        int numberXtoAdd = removeSpace.length() % 5;

        for (int i = 1; i < numberXtoAdd; i++) 
        {
            _message = _message + "X";
        }
        return _message;
    }
}