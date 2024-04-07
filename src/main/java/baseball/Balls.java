package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;

public class Balls {

  public static final int NUM_OF_BALL = 3;
  public static final int BALL_VALUE_MIN = 1;
  public static final int BALL_VALUE_MAX = 9;

  private final int[] ballArr;

  public Balls() {
    int[] ballArr;

    do {
      ballArr = generateRandomArray(NUM_OF_BALL, BALL_VALUE_MIN, BALL_VALUE_MAX);
    } while (hasDuplicate(ballArr));

    this.ballArr = ballArr;
  }

  public Balls(String ballStr) {
    checkLength(ballStr);
    final int[] ballArr = str2ballArr(ballStr);
    checkDuplicate(ballArr);

    this.ballArr = ballArr;
  }

  public BallCompareResult compare(Balls other) {
    final int ballCount = countBall(other);
    final int strikeCount = countStrike(other);
    final boolean isEqual = strikeCount == NUM_OF_BALL;

    return new BallCompareResult(ballCount, strikeCount, isEqual);
  }

  private int countStrike(Balls other) {
    int count = 0;
    for (int i = 0; i < NUM_OF_BALL; i++) {
      if (this.ballArr[i] == other.ballArr[i]) {
        count++;
      }
    }
    return count;
  }

  private int countBall(Balls other) {
    int count = 0;
    for (int i = 0; i < NUM_OF_BALL; i++) {
      if (contains(other.ballArr[i]) && this.ballArr[i] != other.ballArr[i]) {
        count++;
      }
    }
    return count;
  }

  private boolean contains(int target) {
    return Arrays.stream(this.ballArr).anyMatch(ball -> ball == target);
  }

  private void checkLength(String ballStr) {
    if (ballStr.length() != NUM_OF_BALL) {
      throw new IllegalArgumentException();
    }
  }

  private void checkDuplicate(int[] ballArr) {
    if (hasDuplicate(ballArr)) {
      throw new IllegalArgumentException();
    }
  }

  private boolean hasDuplicate(int[] ballArr) {
    for (int target : ballArr) {
      if (Arrays.stream(ballArr).filter(ball -> ball == target).toArray().length > 1) {
        return true;
      }
    }
    return false;
  }

  private int[] generateRandomArray(int length, int min, int max) {
    final int[] randomArray = new int[length];
    for (int i = 0; i < length; i++) {
      randomArray[i] = Randoms.pickNumberInRange(min, max);
    }
    return randomArray;
  }

  private int[] str2ballArr(String ballStr) {
    final int[] ballArr = new int[ballStr.length()];
    for (int i = 0; i < ballStr.length(); i++) {
      ballArr[i] = ballStr.charAt(i) - '0';
    }
    return ballArr;
  }
}
