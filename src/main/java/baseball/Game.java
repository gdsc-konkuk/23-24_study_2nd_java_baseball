package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private Computer computer;
    private Player player;
    private int strike;
    private int ball;

    public Game() {
        computer = new Computer();
        player = new Player();
        strike = 0;
        ball = 0;
    }

    public void startGame() {
        int gameOver = 1;
        while (gameOver == 1) {
            playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = readLine();
            if (input.length() != 1) throw new IllegalArgumentException();
            if (input.charAt(0) != '1' && input.charAt(0) != '2') throw new IllegalArgumentException();
            gameOver = input.charAt(0) - '0';
        }
    }

    private void playGame() {
        while(strike != 3) {
            strike = 0;
            ball = 0;
            System.out.print("숫자를 입력해주세요 : ");
            String input = readLine();
            if (checkInput(input)) player.setNums(input);
            else throw new IllegalArgumentException();
            int nums[] = player.getNums();
            for (int i = 0; i < 3; i++) {
                checkNum(nums[i], i);
            }
            printResult();
        }
    }

    private void printResult() {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            strike = 0;
            ball = 0;
        }
    }

    private void checkNum(int num, int idx) {
        int computerNums[] = computer.getNums();
        for (int i = 0; i < 3; i++) {
            if (computerNums[i] == num && idx == i) {
                strike++;
            }
            if (computerNums[i] == num && idx != i) {
                ball++;
            }
        }
    }

    private boolean checkInput(String input) {
        if (input.length() != 3) return false;
        for (int i = 0; i < 3; i++) {
            if (input.charAt(i) <= '0' || input.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}
