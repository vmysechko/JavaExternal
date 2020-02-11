package ua.ejc.vitaliy.javagamemvc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class View {

    private static Locale locale = View.setViewLocale();



    //Resource Bundle Installation`s
    static String MESSAGES_BUNDLE_NAME = "messages";

    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME,
                    // new Locale("en", "EN"));    //English
                    //new Locale("ua", "UA"));     //Ukrainian
                    locale);

    // Text`s constants
    public static final String EQUAL_SIGN = "=";
    public static final String SPACE_SIGN = " ";
    public static final String COMMA_SIGN = ",";
    public static final String OPEN_SQUARE_BRACKET = "[";
    public static final String CLOSING_SQUARE_BRACKET = "]";

    public static final String CHOOSE_LANGUAGE = "Choose language/Обери мову гри: [1] - English, [2] - Українська";
    public static final String GREETINGS = "input.greetings";
    public static final String INPUT_INT_DATA_KEY = "input.int.data";
    public static final String WRONG_INPUT_INT_DATA = "input.wrong.data";
    public static final String WRONG_RANGE_DATA = "input.wrong.range";
    public static final String CONGRATULATION = "input.congratulation";
    public static final String DEFEAT = "input.defeat";
    public static final String YOUR_NUMBERS = "input.numbers";

    public static Locale setViewLocale() {

        Locale loc = new Locale("en");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        printChooseLanguage();
        int language = 0;

        while (true) {
            // check int - value
            while (true) {
                try {
                    language = Integer.parseInt(reader.readLine());
                    break;
                } catch (IOException e) {
                    System.out.println(e.toString());;
                    continue;
                }
            }

            if (language == 1) {
                loc = new Locale("en");
            } else if (language == 2) {
                loc = new Locale("ua");
            }
            break;
        }
        return loc;
    }

    static void printChooseLanguage(){
        System.out.println(CHOOSE_LANGUAGE);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    private String concatenateString(String...message){
        StringBuilder builder = new StringBuilder();
        for(String x: message){
            builder = builder.append(x);
        }
        return new String(builder.toString());
    }

    String getInputMessage(int minBarrier, int maxBarrier){
        String str = concatenateString(bundle.getString(INPUT_INT_DATA_KEY),
                SPACE_SIGN, OPEN_SQUARE_BRACKET, String.valueOf(minBarrier),
                COMMA_SIGN, SPACE_SIGN, String.valueOf(maxBarrier),
                CLOSING_SQUARE_BRACKET, SPACE_SIGN, EQUAL_SIGN);
        return str;
    }

    void printWrongRangeInput(Model model){
        printMessage(bundle.getString(WRONG_RANGE_DATA) +
                getInputMessage(model.getMinBarrier(), model.getMaxBarrier()));
    }

    void printWrongIntInput(Model model){
        printMessage(bundle.getString(WRONG_INPUT_INT_DATA) +
                getInputMessage(model.getMinBarrier(), model.getMaxBarrier()));
    }

    void printGreetings(){
        printMessage(bundle.getString(GREETINGS));
    }

    void printCongratulation(Model model){
        printMessage(bundle.getString(CONGRATULATION) +
                SPACE_SIGN + model.getSecretNumber());
    }

    void printDefeat(){
        printMessage(bundle.getString(DEFEAT));
    }

    void printNumbers(Model model){
        printMessage(bundle.getString(YOUR_NUMBERS) +
               String.valueOf(model.getUserData()));
    }
}
