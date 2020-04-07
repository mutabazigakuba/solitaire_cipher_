package solitaire;
import java.util.ArrayList;
import java.util.List;

public class Number {

    String _message;

    public Number(String message)
    { 
        _message = message;      
    }

    public List<Integer> convertedMessage()
    {
        List<Integer> convertedMessage = changeLetterToNumber();
        return convertedMessage;
    }
    
    private List<Integer> changeLetterToNumber()
    {
        List<Integer> convertedMessage = new ArrayList<Integer>();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] _messageToArray = _message.toCharArray();

        if(_message.length() < 1)
        {
            return convertedMessage;
        }

        for (int i = 0; i < _message.length(); i++) 
        {
            for (int j = 0; j < alphabet.length; j++) 
            {
                if(_messageToArray[i] == alphabet[j])
                {
                    convertedMessage.add(j+1);
                } 
            }            
        }
        return convertedMessage;
    }
}