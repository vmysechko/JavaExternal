package ua.ejc.vitaliy.javagamemvc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

    private Model playerModel;
    private View playerView;
    private boolean numberGuessed = false;
    private int hiddenNumber;

    public Controller(Model userModel, View userView) {
        this.playerModel = userModel;
        this.playerView = userView;
    }



    public int readUserInputInt(BufferedReader reader) {
        int playerInput = 0;

        playerView.printMessage(playerView.getInputMessage
                (playerModel.getMinBarrier(), playerModel.getMaxBarrier()));

        while (true) {
            // check int - value
            while (true) {
                try {
                    playerInput = Integer.parseInt(reader.readLine());
                    break;
                } catch (IOException e) {
                    playerView.printWrongIntInput(playerModel);
                    continue;
                }
            }
            // Check value in range
            if (playerInput <= playerModel.getMinBarrier() ||
                    playerInput >= playerModel.getMaxBarrier()) {
                playerView.printWrongRangeInput(playerModel);
                continue;
            }
            break;
        }
        return playerInput;
    }

    public void startGame(int maxUserAttempts) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        playerModel.setBarriers(GlobalConstants.MIN_BARRIER,
                GlobalConstants.MAX_BARRIER);
        playerModel.setSecretNumber();

        playerView.printGreetings();

        for (int i = 0; i < maxUserAttempts; i++) {

            if (playerModel.checkValue(readUserInputInt(reader))) {
                playerView.printCongratulation(playerModel);
                playerView.printNumbers(playerModel);
                break;
            } else if (i == maxUserAttempts - 1) {
                playerView.printDefeat();
                playerView.printNumbers(playerModel);
                break;
            }
        }
    }
}
