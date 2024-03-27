package baseballgame;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static constant.Constant.*;
import static exception.Exception.*;

public class Round {
    private final Computer computer;
    private final Player player;

    public void startRound() {
        System.out.println(computer.getAnswer());
        do {
            System.out.print(INPUT_NUMBER_STRING);
            player.guessNumberInput();
        } while(checkGameResult());
    }

    public Round() {
        this.computer = new Computer();
        this.player = new Player();
    }

    private boolean checkGameResult() {
        // player가 입력받은 수를 가져와서 컴퓨터의 수와 비교
        // 입력은 문자열로 받으므로, Round 클래스에서 String을 int형 배열로 바꿔주는 절차가 필요

        String inputString = player.getGuessString();
        int[] playerNumber = changeInputStringToIntArray(inputString);

        List<Integer> answer = computer.getAnswer();

        int ballWithStrike = getBall(playerNumber, answer);
        int strike = getStrike(playerNumber, answer);
        printResult(strike, ballWithStrike);

        if (strike == SUCCESS_STRIKE) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkRestart() {
        System.out.println(RESTART_MESSAGE);
        String inputString = Console.readLine();
        if (inputString.equals(RESTART_INPUT_STRING)) {
            return true;
        } else if (inputString.equals(EXIT_INPUT_STRING)) {
            return false;
        } else {
            throw new IllegalArgumentException(WRONG_INPUT_ERROR);
        }
    }

    private int[] changeInputStringToIntArray(String inputString) {
        int[] intArray = new int[NORMAL_INPUT_LENGTH];
        verifyInputStringLength(inputString, NORMAL_INPUT_LENGTH);
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) < '0' || inputString.charAt(i) > '9') {
                throw new IllegalArgumentException(WRONG_TYPE_INPUT_ERROR);
            }
            intArray[i] = Integer.parseInt(inputString.substring(i, i + 1));
        }
        return intArray;
    }

    private void verifyInputStringLength(String inputString, int correctLength) {
        if (inputString.length() != correctLength) {
            throw new IllegalArgumentException(WRONG_LENGTH_INPUT_ERROR + "\nExpect : " + correctLength + "\nInput : " + inputString.length());
        }
    }

    private int getBall(int[] playerNumber, List<Integer> answer) {
        int ball = 0;
        for (int num : playerNumber) {
            if (answer.contains(num)) {
                ball++;
            }
        }
        return ball;
    }

    private int getStrike(int[] playerNumber, List<Integer> answer) {
        int strike = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (playerNumber[i] == answer.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    private void printResult(int strike, int ballWithStrike) {
        int ball = ballWithStrike - strike;
        if (ballWithStrike == NOTHING) {
            printNothing();
        } else {
            printBall(ball);
            printStrike(strike);
            System.out.println();
        }
        printSuccess(strike);
    }

    private void printNothing() {
        System.out.println(NOTHING_STRING);
    }

    private void printBall(int ball) {
        if (ball > 0) {
            System.out.print(ball + BALL_STRING);
        }
    }

    private void printStrike(int strike) {
        if (strike > 0) {
            System.out.print(strike + STRIKE_STRING);
        }
    }

    private void printSuccess(int strike) {
        if (strike == SUCCESS_STRIKE) {
            System.out.println(SUCCESS_STRING);
        }
    }

}
