package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import sun.font.TrueTypeFont;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        while (true) {
            startGame();
        }
    }

    private static void startGame() {

        ArrayList<Integer> computerNums = getComputerNums();
        System.out.println(computerNums.get(0));
        System.out.println(computerNums.get(1));
        System.out.println(computerNums.get(2));

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            ArrayList<Integer> playerNums = getPlayerNums();

            int ballCnt = getBallCount(computerNums, playerNums);
            System.out.println(ballCnt);

            int strikeCnt = getStrikeCount(computerNums, playerNums);
            System.out.println(strikeCnt);

            if (strikeCnt == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                computerNums = verifyContinueGame();
            } else {
                verifyResult(ballCnt, strikeCnt);
            }
        }
    }

    private static ArrayList<Integer> getComputerNums() {
        ArrayList<Integer> computerNums = new ArrayList<>();
        int firstNum = Randoms.pickNumberInRange(1, 9);
        int secondNum = Randoms.pickNumberInRange(1, 9);

        while (firstNum == secondNum) {
            secondNum = Randoms.pickNumberInRange(1, 9);
        }

        int thirdNum = Randoms.pickNumberInRange(1, 9);

        while (firstNum == thirdNum || secondNum == thirdNum) {
            thirdNum = Randoms.pickNumberInRange(1, 9);
        }

        computerNums.add(firstNum);
        computerNums.add(secondNum);
        computerNums.add(thirdNum);
        return computerNums;
    }


    private static ArrayList<Integer> getPlayerNums() {
        ArrayList<Integer> playerNums = new ArrayList<>();
        String inputNum = Console.readLine();

        validateInputNum(inputNum); // 사용자가 입력한 수 검증

        playerNums.add(inputNum.charAt(0) - '0');
        playerNums.add(inputNum.charAt(1) - '0');
        playerNums.add(inputNum.charAt(2) - '0');

        return playerNums;
    }

    private static void validateInputNum(String str){
        // null 이거나 3자리 수가 아니거나, 숫자 내에 1 ~ 9 가 아닌 수가 입력될 경우 예외 발생
        if (!(str != null && str.matches("[1-9.]+") && str.length() == 3)) {
            throw new IllegalArgumentException();
        }
    }

    private static int getBallCount(ArrayList<Integer> computerNums,
                                    ArrayList<Integer> playerNums) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            int playerNum = playerNums.get(i);
            int computerNum = computerNums.get(i);
            System.out.println("playerNum : " + playerNum);
            System.out.println("computerNum : " + computerNum);

            if (playerNum != computerNum && computerNums.contains(playerNum)) {
                cnt += 1;
            }
        }
        return cnt;
    }

    private static int getStrikeCount(ArrayList<Integer> computerNums,
                                    ArrayList<Integer> playerNums) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            int playerNum = playerNums.get(i);
            int computerNum = computerNums.get(i);
            System.out.println("playerNum : " + playerNum);
            System.out.println("computerNum : " + computerNum);

            if (playerNum == computerNum) {
                cnt += 1;
            }
        }
        return cnt;
    }
}
