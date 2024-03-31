package baseball.src.model;

import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static baseball.common.constant.Constant.*;
import static com.sun.corba.se.impl.activation.ServerMain.printResult;

public class Round {
    private final ArrayList<Integer> answer;
    private final ArrayList<Integer> guess;
    private int ball;
    private int strike;

    public Round(ArrayList<Integer> answer, ArrayList<Integer> guess) {
        this.answer = new ArrayList<>(answer);
        this.guess = new ArrayList<>(guess);
    }

    public String getGameResult() {
        int ballWithStrike = getBall(guess, answer);
        strike = getStrike(guess, answer);
        ball = ballWithStrike - strike;

        if (ball > NOTHING && strike > NOTHING) {
            return ball + BALL_STRING + " " + strike + STRIKE_STRING;
        }
        if (ball > 0 && strike == 0) {
            return ball + BALL_STRING;
        }
        if (ball == 0 && strike > 0) {
            return strike + STRIKE_STRING;
        }
        return NOTHING_STRING;
    }

    private int getBall(ArrayList<Integer> playerNumber, ArrayList<Integer> answer) {
        int ball = 0;
        for (int num : playerNumber) {
            if (answer.contains(num)) {
                ball++;
            }
        }
        return ball;
    }

    private int getStrike(ArrayList<Integer> guess, ArrayList<Integer> answer) {
        int strike = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).equals(guess.get(i))) {
                strike++;
            }
        }
        return strike;
    }
}
