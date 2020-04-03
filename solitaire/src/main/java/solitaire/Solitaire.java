package solitaire;

import java.util.Arrays;

public class Solitaire {

    public String encoded_message(String message) 
    {
        String cleanedMessage = removeNonLetters(message);
        String changeToUpper = changeToUpperCase(cleanedMessage);
        String groupedIntoFives = groupLettersIntoFives(changeToUpper);
        String finalGroupedMessage = AddXs(groupedIntoFives);
        return finalGroupedMessage;
    }

    private String changeToUpperCase(String message) {
        return message.toUpperCase();
    }

    private String removeNonLetters(String message) {
        return message.replaceAll("[^\\p{L}\\p{Z}]","");
    }

    private String groupLettersIntoFives(String message) 
    {
        return Arrays.toString(message.replaceAll("\\s+", "").split("(?<=\\G.{" + 5 + "})"))
            .replaceAll("[^\\p{L}\\p{Z}]","");
    }

    private String AddXs (String message)
    {
        String removeSpace = message.replaceAll("\\s+", "");
        int numberXtoAdd = removeSpace.length() % 5;

        for (int i = 1; i < numberXtoAdd; i++) {
            message = message + "X";
        }
        System.out.println(message);

        return message;
    }

}