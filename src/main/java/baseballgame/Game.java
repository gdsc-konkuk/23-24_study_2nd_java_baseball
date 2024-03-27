package baseballgame;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static constant.Constant.*;
import static exception.Exception.*;

/**
 * run -> 전체 프로그램 실행을 담당.
 * playOneGame -> 한번의 게임을 실행
 * restart -> 재시작 여부 확인
 * getStrike -> 스트라이크 개수 확인
 * getBall -> 볼 개수 확인
 */
public class Game {
    List<Integer> answer = new ArrayList<>();

    public Game() {
        while (answer.size() < ANSWER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public void run() {
        Game game;
        do {
            game = new Game();
            game.playGameOnce();
        } while (game.restart());
    }

    private void playGameOnce() {
        String inputString;
        do {
            System.out.print(INPUT_NUMBER_STRING);
            inputString = Console.readLine();
        } while (checkGameResult(inputString) != SUCCESS_BOOLEAN);
    }

    private boolean checkGameResult(String inputStringNum) {
        int[] inputNumArr = changeInputStringToIntArray(inputStringNum);
        int strike = getStrike(inputNumArr);
        int ballWithStrike = getBall(inputNumArr);
        printResult(strike, ballWithStrike);

        if (strike == SUCCESS_STRIKE) {
            return true;
        } else {
            return false;
        }
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

    private int[] changeInputStringToIntArray(String inputStringNum) {
        int[] intArray = new int[NORMAL_INPUT_LENGTH];
        verifyInputStringLength(inputStringNum, NORMAL_INPUT_LENGTH);
        for (int i = 0; i < inputStringNum.length(); i++) {
            if (inputStringNum.charAt(i) < '0' || inputStringNum.charAt(i) > '9') {
                throw new IllegalArgumentException(WRONG_TYPE_INPUT_ERROR);
            }
            intArray[i] = Integer.parseInt(inputStringNum.substring(i, i + 1));
        }
        return intArray;
    }

    private void verifyInputStringLength(String inputString, int correctLength) {
        if (inputString.length() != correctLength) {
            throw new IllegalArgumentException(WRONG_LENGTH_INPUT_ERROR + "\nExpect : " + correctLength + "\nInput : " + inputString.length());
        }
    }

    private boolean restart() {
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

    private int getStrike(int[] inputNumber) {
        int strike = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (inputNumber[i] == answer.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    private int getBall(int[] inputNumber) {
        int ball = 0;
        for (int num : inputNumber) {
            if (answer.contains(num)) {
                ball++;
            }
        }
        return ball;
    }

}
