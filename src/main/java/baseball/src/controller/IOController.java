package baseball.src.controller;

import baseball.common.exceptions.InputException;
import baseball.src.view.InputView;
import baseball.src.view.OutputView;
import baseball.utils.Conversion;

import java.util.ArrayList;

public class IOController {

    private final InputView inputView;
    private final OutputView outputView;

    public IOController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public ArrayList<Integer> guessNumberInput() {
        String guessNumberStr = inputView.numberInput();
        InputException.validateInput(guessNumberStr);
        return Conversion.stringToArrayList(guessNumberStr);
    }

    public int restartNumberInput() {
        String restartNumberStr = inputView.restartInput();
        InputException.validateRestartInput(restartNumberStr);
        return Integer.parseInt(restartNumberStr);
    }

    public void showResult(String result) {
        outputView.resultOutput(result);
    }

    public void gameEndNotify() {
        outputView.gameEnd();
    }


}
