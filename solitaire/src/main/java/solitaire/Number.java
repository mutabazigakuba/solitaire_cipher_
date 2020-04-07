package solitaire;
import java.util.ArrayList;
import java.util.List;

public class Number {

    String _message;
    List<Integer> numbers = new ArrayList<Integer>();

    public Number(String message)
    { 
        _message = message;      
    }

    public List<Integer> convertsMessageToNumber()
    {
        if(_message.isEmpty())
        {
            return new ArrayList<Integer>();
        }

        char[] values = _message.toCharArray();

        for (char value : values) {
            int something = value - 'A' + 1;
            numbers.add(something);
        }
        return numbers;
    }

    public String convertsNumberToMessage()
    {
        if(numbers.isEmpty())
        {
            return "";
        }

        // char[] values = new char[numbers.size()];
        String some = "";

        for (int number : numbers) 
        {
            // String something = ""+number.
            // values.add(something);
        }
        // return numbers;
    }
}