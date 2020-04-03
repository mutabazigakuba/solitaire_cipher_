package solitaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solitaire {

    public String encoded_message(String message) 
    {
        String cleanedMessage = removeNonLetters(message);
        String changeToUpper = changeToUpperCase(cleanedMessage);
        String groupedIntoFives = groupLettersIntoFives(changeToUpper);
        // String finalMessage = AddXs(groupedIntoFives);
        // return finalMessage;
        return groupedIntoFives;
    }

    private String changeToUpperCase(String message) {
        return message.toUpperCase();
    }

    private String removeNonLetters(String message) {
        return message.replaceAll("[^\\p{L}\\p{Z}]","");
    }

    private String groupLettersIntoFives(String message) 
    {
      return Arrays.toString(message.split("(?<=\\G.{" + 5 + "})"))
            .replaceAll("[^\\p{L}\\p{Z}]","");
    }

    private String AddXs (String Message)
    {
        int numberXtoAdd = 5 - Message.length() % 5;
        
        for (int i = 1; i < numberXtoAdd; i++) {
            Message = Message + "X";
        }
        
        return Message;
    }

}