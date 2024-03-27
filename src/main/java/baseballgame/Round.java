package baseballgame;

import java.util.List;

import static com.sun.corba.se.impl.activation.ServerMain.printResult;
import static constant.Constant.INPUT_NUMBER_STRING;
import static constant.Constant.NORMAL_INPUT_LENGTH;
import static exception.Exception.WRONG_LENGTH_INPUT_ERROR;
import static exception.Exception.WRONG_TYPE_INPUT_ERROR;

public class Round {
    private final Computer computer;
    private final Player player;

    public void startRound() {
        do {
            System.out.print(INPUT_NUMBER_STRING);
            player.guessNumberInput();
        } while(getResult());
    }

    public Round(Computer computer, Player player) {
        this.computer = computer;
        this.player=  player;
    }

    private Boolean getResult() {
        // player가 입력받은 수를 가져와서 컴퓨터의 수와 비교
        // 입력은 문자열로 받으므로, Round 클래스에서 String을 int형 배열로 바꿔주는 절차가 필요

        String inputString = player.getGuessString();
        int[] playerNumber = changeInputStringToIntArray(inputString);

        List<Integer> answer = computer.getAnswer();

        Integer ball = getBall(playerNumber, answer);
        Integer strike = getStrike(playerNumber, answer);
        printResult(ball, strike);
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

    private Integer getBall(int[] playerNumber, List<Integer> answer) {

    }

    private Integer getStrike(int[] playerNumber, List<Integer> answer) {

    }

    private void printResult(Integer ball, Integer strike) {

    }

}
