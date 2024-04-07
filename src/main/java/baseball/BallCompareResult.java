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

  @Override
  public String toString() {
    String result = "";

    if (hasBall()) {
      result += this.ballCount + "볼 ";
    }

    if (hasStrike()) {
      result += this.strikeCount + "스트라이크\n";
    }

    if (this.isEqual) {
      result += this.strikeCount + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }

    return result;
  }

  public boolean hasBall() {
    return this.ballCount != 0;
  }

  public boolean hasStrike() {
    return this.strikeCount != 0;
  }
}
