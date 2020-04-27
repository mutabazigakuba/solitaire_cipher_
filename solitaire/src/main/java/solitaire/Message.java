package solitaire;
import java.util.Arrays;

public class Message 
{
    public String _message;
    private int NUMBER_OF_ALPHABETS = 26;
    private int ASCII_BASE = 64;
    private int GROUP_IN = 5;
    public Message(String message)
    {
        _message = message;
    }

    public String mClean() 
    {
        _message = removeNonLetters();
        _message = changeToUpperCase();
        _message = AddXs();
        _message = removeWhiteSpace(_message);
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
        for (int i = 0; i < values.length; i++) 
        {
            int number = values[i] - 'A' + 1;
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
            number = Math.abs(number);
            if(number > NUMBER_OF_ALPHABETS)
            {
                number -= NUMBER_OF_ALPHABETS;
            }
            if(number == 0)
            {
                number = NUMBER_OF_ALPHABETS;
            }
            message +=  String.valueOf((char)(ASCII_BASE + number));
        }

        return groupIntoFives(message);
    }

    private String changeToUpperCase() 
    {
        return _message.toUpperCase();
    }

    private String removeNonLetters() 
    {
        return _message.replaceAll("[^\\p{L}\\p{Z}]","");
    }

    public String removeWhiteSpace(String string)
    {
        return string.replaceAll("\\s+", "");
    }
    private String AddXs()
    {
        String removeSpace = removeWhiteSpace(_message);
        int numberXtoAdd = removeSpace.length() % GROUP_IN;
        if (numberXtoAdd == 0)
        {
            return _message;
        }
        for (int i = 0; i < (GROUP_IN -numberXtoAdd); i++) 
        {
            _message = _message + "X";
        }
        return _message;
    }

    private String groupIntoFives(String message) 
    {
        return Arrays.toString(message.replaceAll("\\s+", "").split("(?<=\\G.{" + 5 + "})"))
            .replaceAll("[^\\p{L}\\p{Z}]","");
    }
}