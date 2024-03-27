package baseballgame;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static constant.Constant.NORMAL_INPUT_LENGTH;
import static exception.Exception.WRONG_LENGTH_INPUT_ERROR;
import static exception.Exception.WRONG_TYPE_INPUT_ERROR;

public class Player {

    private String inputString;

    public Player() {

    }

    public void guessNumberInput() {
        String inputString = Console.readLine();
        this.inputString = inputString;
    }

    public String getGuessString() {
        return inputString;
    }

}
