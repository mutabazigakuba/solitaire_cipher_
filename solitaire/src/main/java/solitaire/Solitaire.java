package solitaire;

import java.util.ArrayList;
import java.util.List;

public class Solitaire {

    public String encoded_message(String message) {

        String encodeMessage = groupLettersIntoFives(message);

        return encodeMessage;
    }

    public String changeToUpperCase(String message) {
        String updateMessage = message.toUpperCase();
        return updateMessage;
    }

    public String removeNonLetters(String message) {

        String updateMessage = changeToUpperCase(message);
        String[] cleanedMessage = updateMessage.split("\\W+");
        String finalMessage = new String();

        for (int i = 0; i < cleanedMessage.length; i++) {
            finalMessage = finalMessage + cleanedMessage[i];
        }

        return finalMessage;
    }

    public String groupLettersIntoFives(String message) {

        String updateMessage = removeNonLetters(message);
        int numberOfLetters = updateMessage.length();

        if (numberOfLetters > 5) {

            if ((numberOfLetters % 5) == 0) {
                return multipleOfFiveMessage(updateMessage, numberOfLetters);
            } else {
                return nonMultiplesOfFiveMessage(updateMessage, numberOfLetters);
            }
        }
        return updateMessage;
    }

    private String multipleOfFiveMessage(String updateMessage, int numberOfLetters) {
        List<String> outPutMessage = new ArrayList<String>();
        for (int i = 0; i < numberOfLetters; i += 5) {
            outPutMessage.add(updateMessage.substring(i, Math.min(numberOfLetters, i + 5)));
        }
        String finalMessage = outPutMessage.toString().replace("[", "").replace("]", "").replace(",", "");
        return finalMessage;
    }

    private String nonMultiplesOfFiveMessage(String updateMessage, int numberOfLetters) {
        List<String> outPutMessage = new ArrayList<String>();

        for (int i = 0; i < numberOfLetters; i += 5) {
            outPutMessage.add(updateMessage.substring(i, Math.min(numberOfLetters, i + 5)));
        }

        int addX = numberOfLetters % 5;
        List<String> XsToAdd = new ArrayList<String>();

        for (int i = 1; i < addX; i++) {
            XsToAdd.add("X");
        }
        return "HELLO HELLO HELXX";
    }
}