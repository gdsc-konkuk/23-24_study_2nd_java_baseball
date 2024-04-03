package baseball;

import static baseball.Application.BALL_VALUE_MAX;
import static baseball.Application.BALL_VALUE_MIN;
import static baseball.Application.NUM_OF_BALL;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;

public class Balls {
  private final int[] ballIndex;

  public Balls(int[] ballIndex) {
    validate(ballIndex);
    this.ballIndex = ballIndex;
  }

  public static Balls from(String ballStr) {
    int[] ballIndex = new int[BALL_VALUE_MAX + 1];

    for (int index = 0; index < NUM_OF_BALL; index++) {
      ballIndex[ballStr.charAt(index) - '0'] = index;
    }

    return new Balls(ballIndex);
  }

  public static Balls rand() {
    int[] ballIndex = new int[BALL_VALUE_MAX + 1];
    Arrays.fill(ballIndex, -1);

    for (int index = 0; index < NUM_OF_BALL; index++) {
      int ball;

      do {
        ball = Randoms.pickNumberInRange(BALL_VALUE_MIN, BALL_VALUE_MAX);
      } while (ballIndex[ball] != -1);

      ballIndex[ball] = index;
    }
    return new Balls(ballIndex);
  }

  public BallCompareResult compare(Balls other) {
    int ballCount = 0;
    int strikeCount = 0;

    for (int i = BALL_VALUE_MIN; i <= BALL_VALUE_MAX; i++) {
      if (this.ballIndex[i] == -1 || other.ballIndex[i] == -1) {
        continue;
      }

      if (this.ballIndex[i] == other.ballIndex[i]) {
        strikeCount++;
      } else {
        ballCount++;
      }
    }

    return new BallCompareResult(ballCount, strikeCount);
  }

  private void validate(int[] ballIndex) {
    if (ballIndex.length != BALL_VALUE_MAX + 1) {
      throw new IllegalArgumentException();
    }

    for (int index = 0; index < NUM_OF_BALL; index++) {
      findBallByIndex(index);
    }
  }

  private int findBallByIndex(int index) {
    for (int ball = BALL_VALUE_MIN; ball <= BALL_VALUE_MAX; ball++) {
      if (this.ballIndex[ball] == index) {
        return ball;
      }
    }

    throw new IllegalArgumentException();
  }
}
