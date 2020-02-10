package ua.ejc.vitaliy.javagamemvc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller {

    private Model playerModel;
    private View playerView;
    private boolean numberGuessed = false;
    private int hiddenNumber;

    public Controller(Model userModel, View userView) {
        this.playerModel = userModel;
        this.playerView = userView;
    }

    public int randomNumber(int min, int max) {
        if (min > max) {
            int temp = max;
            max = min;
            min = temp;
        }

        int rand = (int) (Math.random() * (max - min));

        return rand;
    }

    public int readUserInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int playerInput = 0;

        try {
            playerInput = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return playerInput;
    }

    public void printGameStatistics() {
        if (playerModel.getUserData().length == 10) {
            playerView.printMessage("You lose! Try again.");
        } else {
            playerView.printMessage("Congratulations, you win!");
            playerView.printMessage("-------------------------");
        }
        playerView.printMessage("Game statistics:");
        playerView.printMessage("HIDDEN NUMBER is: " + hiddenNumber);
        playerView.printMessage("Numbers you entered: " + Arrays.toString(playerModel.getUserData()));
        playerView.printMessage("Amount of attempts you did: " + playerModel.getUserData().length);
    }

    public void startGame(int min, int max, int maxUserAttempts) {
        playerView.printMessage(String.format("Hello stranger!\nLet`s play a dangerous game...\n" +
                "Guess a number between %d and %d. You have %d attempts for that", min, max, maxUserAttempts));

        hiddenNumber = randomNumber(min, max);
        playerModel.setUserData(maxUserAttempts);

        for (int i = 0; i < maxUserAttempts; i++) {
            playerView.printMessage(String.format("Type your number between %d and %d:", min, max));
            int typedNumber = readUserInput();
            playerModel.extendUserData(i, typedNumber);

            if (hiddenNumber == typedNumber) {
                playerModel.updateUserData(i + 1);
                printGameStatistics();
                numberGuessed = true;
                break;
            } else {
                if (typedNumber > hiddenNumber && typedNumber <= max) {
                    max = typedNumber;
                    playerView.printMessage(String.format("Your number %d is bigger then HIDDEN NUMBER. " +
                            "Insert new number in range between %d and %d", typedNumber, min, max));
                } else if (typedNumber < hiddenNumber && typedNumber >= min) {
                    min = typedNumber;
                    playerView.printMessage(String.format("Your number %d is smaller then HIDDEN NUMBER. " +
                            "Insert new number in range between %d and %d", typedNumber, min, max));
                } else if ((typedNumber < min && typedNumber > max)) {
                    playerView.printMessage(String.format("Be more attentive! \n" +
                            "Your inserted number %d is out of range: %d and %d", typedNumber, min, max));
                }
            }
        }
        if (!numberGuessed) {
            printGameStatistics();
        }
    }
}
