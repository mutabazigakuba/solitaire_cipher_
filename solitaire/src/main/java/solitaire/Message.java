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
        _message = groupLettersIntoFives();
        _message = AddXs();
        return _message;
    }

    public List<Integer> mConvertsToNumber()
    {
        if(_message.isEmpty())
        {
            return new ArrayList<Integer>();
        }

        List<Integer> numbers = new ArrayList<Integer>();
        char[] values = _message.toCharArray();

        for (char value : values) {
            int number = value - 'A' + 1;
            numbers.add(number);
        }
        return numbers;
    }

    public String mConvertsNumberToMessage(List<Integer> numbers)
    {        
        if(numbers.isEmpty())
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