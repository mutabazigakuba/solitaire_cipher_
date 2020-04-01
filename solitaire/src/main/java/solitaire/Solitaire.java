package solitaire;


public class Solitaire{

    public String encoded_message(String message){

        String make_upper_case = message.toUpperCase();

        String[] string_values = make_upper_case.split("\\W+");

        String new_message = new String();

        for (int i = 0; i < string_values.length; i++) {
            new_message = new_message + string_values[i];
        }

        return new_message;
    }
}