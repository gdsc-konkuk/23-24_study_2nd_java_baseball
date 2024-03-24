package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private Computer computer;
    private Status status;

    public Game() {
        this.status = Status.RUN;
    }

    private void init() {
        this.computer = new Computer();
    }

    public void start() {
        while (status == Status.RUN) {
            init();
            play();
            checkReplay();
        }
    }

    private void play(){
        while(status == Status.RUN) {
            Round round = new Round(computer);
            round.start();
            status = round.getStatus();
        }
    }

    private void checkReplay() {
        int check = 0;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = readLine();
        if (checkGameInput(input)) check = input.charAt(0) - '0';
        if (check == 1) status = Status.RUN;
        else status = Status.SUCCESS;
    }

    private boolean checkGameInput(String input) {
        if (input.length() != 1) throw new IllegalArgumentException();
        if (input.charAt(0) != '1' && input.charAt(0) != '2') throw new IllegalArgumentException();
        return true;
    }
}
