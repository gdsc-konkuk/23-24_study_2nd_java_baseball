package baseball.src.controller;

import baseball.src.model.Computer;
import baseball.src.model.Round;

import java.util.ArrayList;

import static baseball.common.constant.Constant.SUCCESS_RESULT;

public class GameController {

    private final IOController ioController;

    public GameController() {
        this.ioController = new IOController();
    }

    public void startGame() {
        inGame();
    }

    private void inGame() {
        Computer computer = new Computer();
        ArrayList<Integer> answer = computer.getAnswer();
        while (true) {
            ArrayList<Integer> guessNumber = ioController.guessNumberInput();
            Round round = new Round(answer, guessNumber);
            String result = round.getGameResult();
            ioController.showResult(result);

            if (result.equals(SUCCESS_RESULT)) {
                restartGame();
                break;
            }
        }
    }

    private void restartGame() {
        ioController.gameEndNotify();
        int restartNum = ioController.restartNumberInput();
        if (restartNum == 1) {
            inGame();
        }
    }
}
