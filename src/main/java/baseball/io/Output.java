package baseball.io;

import baseball.MESSAGE;

public class Output {
    public void printInputMessage() {
        System.out.print(MESSAGE.INPUT.getMessage());
    }

    public void printBall(int ballCnt) {
        System.out.println(ballCnt + MESSAGE.BALL.getMessage());
    }

    public void printStrike(int strikeCnt) {
        System.out.println(strikeCnt + MESSAGE.STRIKE.getMessage());
    }

    public void printBallAndStrike(int ballCnt, int strikeCnt) {
        System.out.println(ballCnt + MESSAGE.BALL.getMessage() + " " + strikeCnt + MESSAGE.STRIKE.getMessage());
    }

    public void printSuccess() {
        System.out.println(MESSAGE.SUCCESS.getMessage());
        System.out.println(MESSAGE.REPLAY.getMessage());
    }

    public void printNothing() {
        System.out.println(MESSAGE.NOTHING.getMessage());
    }

}
