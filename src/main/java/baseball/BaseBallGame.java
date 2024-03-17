package baseball;

import baseball.io.Input;
import baseball.io.Output;

import java.util.HashMap;
import java.util.Map;

public class BaseBallGame {
    private Computer computer;
    private int length;
    private Input input;
    private Output output;

    private final String STRIKE = "strike";
    private final String BALL = "ball";
    private final String RESTART_FLAG = "1";
    private final String STOP_FLAG = "2";

    public BaseBallGame(int length) {
        this.length = length;
        this.computer = new Computer(length);
        input = new Input();
        output = new Output();
    }

    public void run() {
        while (true) {
            GAMESTATUS gamestatus = processRound();
            if (processReplay(gamestatus)) {
                break;
            }
        }
    }

    private boolean processReplay(GAMESTATUS gamestatus) {
        if (gamestatus.equals(GAMESTATUS.SUCCESS)) {
            String restartFlag = input.readRestartFlag();
            if (restartFlag.equals(RESTART_FLAG)) {
                computer = new Computer(length);
            }
            if (restartFlag.equals(STOP_FLAG)) {
                return true;
            }
        }
        return false;
    }

    private GAMESTATUS processRound() {
        String inputString = processInput();
        Map<String, Integer> result = processComparison(inputString);
        GAMESTATUS gamestatus = processResult(result);
        return gamestatus;
    }

    private GAMESTATUS processResult(Map<String, Integer> result) {
        int strikeCnt = result.get(STRIKE);
        int ballCnt = result.get(BALL);
        GAMESTATUS gamestatus = GAMESTATUS.RUN;
        if (strikeCnt != 0 && ballCnt != 0) {
            output.printBallAndStrike(ballCnt, strikeCnt);
        }
        if (strikeCnt != 0 && ballCnt == 0) {
            output.printStrike(strikeCnt);
        }
        if (strikeCnt == 0 && ballCnt != 0) {
            output.printBall(ballCnt);
        }
        if (strikeCnt == 0 && ballCnt == 0) {
            output.printNothing();
        }
        if (strikeCnt == length) {
            output.printSuccess();
            gamestatus = GAMESTATUS.SUCCESS;
        }
        return gamestatus;
    }

    private Map<String, Integer> processComparison(String inputString) {
        Map<String, Integer> result = new HashMap<>();
        int strikeCnt = computer.checkStrike(inputString);
        int ballCnt = computer.checkBall(inputString);

        result.put(STRIKE, strikeCnt);
        result.put(BALL, ballCnt);
        return result;
    }

    private String processInput() {
        output.printInputMessage();
        String inputNumber = input.readGameNumbers(length);
        return inputNumber;
    }
}
