package baseball;

public class BallCompareResult {

  public final int ballCount;
  public final int strikeCount;
  public final boolean isEqual;

  public BallCompareResult(int ballCount, int strikeCount, boolean isEqual) {
    this.ballCount = ballCount;
    this.strikeCount = strikeCount;
    this.isEqual = isEqual;
  }

  public boolean hasBall() {
    return this.ballCount != 0;
  }

  public boolean hasStrike() {
    return this.strikeCount != 0;
  }
}
