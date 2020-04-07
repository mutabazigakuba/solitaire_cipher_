package solitaire;
import java.util.ArrayList;
import java.util.List;

public class ASCII {

    public ASCII()
    {      
    }

    public static List<Integer> convertsMessageToNumber(String _message)
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

    public static String convertsNumberToMessage(List<Integer> numbers)
    {        
        if(numbers.isEmpty())
        {
            return "";
        }
        String message = "";
        for (int number : numbers) 
        {
            message +=  String.valueOf((char)(64+number));
        }

        return message;
    }
}