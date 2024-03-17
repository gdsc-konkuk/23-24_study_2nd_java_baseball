package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        while (true) {
            startGame();
        }
    }

    private static void startGame() {

        ArrayList<Integer> computerNums = getComputerNums();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            ArrayList<Integer> playerNums = getPlayerNums();

            int ballCnt = getBallCount(computerNums, playerNums);
            int strikeCnt = getStrikeCount(computerNums, playerNums);

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

        for (int i = 0; i < inputNum.length(); i++) {
            playerNums.add(inputNum.charAt(i) - '0');
        }

        return playerNums;
    }

    private static void validateInputNum(String str){
        // null 이거나 3자리 수를 넘어서거나, 숫자 내에 1 ~ 9 가 아닌 수가 입력될 경우 예외 발생
        if (!(str != null && str.matches("[1-9.]+") && !str.isEmpty() && str.length() < 4)) {
            throw new IllegalArgumentException();
        }
    }

    private static int getBallCount(ArrayList<Integer> computerNums,
                                    ArrayList<Integer> playerNums) {
        int cnt = 0;
        for (int i = 0; i < playerNums.size(); i++) {
            int playerNum = playerNums.get(i);
            int computerNum = computerNums.get(i);

            if (playerNum != computerNum && computerNums.contains(playerNum)) {
                cnt += 1;
            }
        }
        return cnt;
    }

    private static int getStrikeCount(ArrayList<Integer> computerNums,
                                    ArrayList<Integer> playerNums) {
        int cnt = 0;
        for (int i = 0; i < playerNums.size(); i++) {
            int playerNum = playerNums.get(i);
            int computerNum = computerNums.get(i);

            if (playerNum == computerNum) {
                cnt += 1;
            }
        }
        return cnt;
    }

    private static void verifyResult(int ballCnt, int strikeCnt) {

        if (ballCnt == 0 && strikeCnt == 0) {
            System.out.println("낫싱");
        } else {
            if (ballCnt > 0) {
                System.out.print(ballCnt + "볼 ");
            }
            if (strikeCnt > 0) {
                System.out.print(strikeCnt + "스트라이크");
            }
            System.out.println();
        }
    }

    private static ArrayList<Integer> verifyContinueGame() {
        String num = Console.readLine();
        int isContinue = num.charAt(0) - '0';

        if (isContinue == 2) {
            System.exit(0);
        } else if (isContinue == 1) {
            return getComputerNums();
        } else {
            throw new IllegalArgumentException();
        }
        return null;
    }
}
