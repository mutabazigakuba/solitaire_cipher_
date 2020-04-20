package solitaire;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Message 
{
    private String _message;
    public Message(String message)
    {
        _message = message;
    }

    public String mClean() 
    {
        _message = removeNonLetters();
        _message = changeToUpperCase();
        _message = AddXs();
        _message = groupLettersIntoFives();
        return _message;
    }

    public int[] mConvertsToNumber()
    {
        if(_message.isEmpty())
        {
            return new int[0];
        }

        int[] numbers = new int[_message.length()];
        char[] values = _message.toCharArray();
        for (int i = 0; i < values.length; i++) {
            int number = values[i] - 'A' +1;
            numbers[i] = number;
        }
        return numbers;
    }

    public String mConvertsNumberToMessage(int[] numbers)
    {        
        if(numbers.length == 0)
        {
            return "";
        }
        String message = "";
        for (int number : numbers) 
        {
            message +=  String.valueOf((char)(64 + number));
        }

        return message;
    }

    private String removeNonLetters() 
    {
        return _message.replaceAll("[^\\p{L}\\p{Z}]","");
    }

    private String changeToUpperCase() 
    {
        return _message.toUpperCase();
    }

    private String AddXs()
    {
        String removeSpace = _message.replaceAll("\\s+", "");
        int numberXtoAdd = removeSpace.length() % 5;
        if (numberXtoAdd == 0){
            return _message;
        }
        for (int i = 0; i < (5-numberXtoAdd); i++) 
        {
            _message = _message + "X";
        }
        return _message;
    }

    private String groupLettersIntoFives() 
    {
        return Arrays.toString(_message.replaceAll("\\s+", "").split("(?<=\\G.{" + 5 + "})"))
            .replaceAll("[^\\p{L}\\p{Z}]","");
    }
}