package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        startGame();
    }

    private static void startGame() {
        ArrayList<Integer> computerNums = getComputerNums();
        ArrayList<Integer> playerNums = getPlayerNums();
    }

    private static ArrayList<Integer> getPlayerNums() {
        ArrayList<Integer> playerNums = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String inputNum = Console.readLine();

        validateInputNum(inputNum); // 사용자가 입력한 수 검증

        playerNums.add((int) inputNum.charAt(0));
        playerNums.add((int) inputNum.charAt(1));
        playerNums.add((int) inputNum.charAt(2));

        return playerNums;
    }

    private static void validateInputNum(String str){
        // null 이거나 3자리 수가 아니거나, 숫자 내에 1 ~ 9 가 아닌 수가 입력될 경우 예외 발생
        if (!(str != null && str.matches("[1-9.]+") && str.length() == 3)) {
            throw new IllegalArgumentException();
        }
    }

    private static ArrayList<Integer> getComputerNums() {
        ArrayList<Integer> computerNums = new ArrayList<>();
        computerNums.add(Randoms.pickNumberInRange(1, 9));
        computerNums.add(Randoms.pickNumberInRange(1, 9));
        computerNums.add(Randoms.pickNumberInRange(1, 9));

        return computerNums;
    }
}
