package baseball;

import static baseball.Balls.BALL_VALUE_MAX;
import static baseball.Balls.BALL_VALUE_MIN;
import static baseball.Balls.NUM_OF_BALL;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;

public class Machine {

  private Balls answer;

  public Machine() {}

  public void generateAnswer() {
    int[] ballIndex = new int[BALL_VALUE_MAX + 1];
    Arrays.fill(ballIndex, -1);

    for (int index = 0; index < NUM_OF_BALL; index++) {
      int ball;

      do {
        ball = Randoms.pickNumberInRange(BALL_VALUE_MIN, BALL_VALUE_MAX);
      } while (ballIndex[ball] != -1);

      ballIndex[ball] = index;
    }

    this.answer = new Balls(ballIndex);
  }

  public BallCompareResult submit(Balls input) {
    return this.answer.compare(input);
  }
}
