package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Round {
    private Player player;
    private Computer computer;
    private int strike;
    private int ball;

    Round(Computer computer) {
        this.computer = computer;
        this.strike = 0;
        this.ball = 0;
    }

    public void start() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = readLine();
        if (checkPlayerInput(input)) player = new Player(input);
        for (int i = 0; i <3; i++) {
            checkNum(player.getNums()[i], i);
        }
        printResult();
    }

    public Status getStatus() {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return Status.SUCCESS;
        }
        return Status.RUN;
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
    }

    private void checkNum(int num, int idx) {
        for (int i = 0; i < 3; i++) {
            if (computer.getNums()[i] == num && idx == i) {
                strike++;
            }
            if (computer.getNums()[i] == num && idx != i) {
                ball++;
            }
        }
    }

    private boolean checkPlayerInput(String input) {
        if (input.length() != 3) throw new IllegalArgumentException();
        for (int i = 0; i < 3; i++) {
            if (input.charAt(i) <= '0' || input.charAt(i) > '9') {
                throw new IllegalArgumentException();
            }
        }
        return true;
    }
}
