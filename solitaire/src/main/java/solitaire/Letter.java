package solitaire;

import java.util.List;

public class Letter {

    public String convertMessage(List<Integer> numbers)
    {
        String message = "";
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
        for (int i = 0; i < numbers.size(); i++) 
        {
            for (int j = 0; j < 26; j++) 
            {
                if(numbers.get(i) < 1)
                {
                    return "check your inputs please";
                }
                if(numbers.get(i) == j)
                {
                    message += alphabet[j-1];
                }
            }
        }
        return message;
    }
}