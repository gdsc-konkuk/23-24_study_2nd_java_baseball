package baseball;

public class Balls {

  public static final int NUM_OF_BALL = 3;
  public static final int BALL_VALUE_MIN = 1;
  public static final int BALL_VALUE_MAX = 9;
  private final int[] ballIndex;

  public Balls(int[] ballIndex) {
    validate(ballIndex);
    this.ballIndex = ballIndex;
  }

  public static Balls fromStr(String ballStr) {
    int[] ballIndex = new int[BALL_VALUE_MAX + 1];

    for (int index = 0; index < NUM_OF_BALL; index++) {
      ballIndex[ballStr.charAt(index) - '0'] = index;
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

    boolean isEqual = strikeCount == NUM_OF_BALL;

    return new BallCompareResult(ballCount, strikeCount, isEqual);
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
