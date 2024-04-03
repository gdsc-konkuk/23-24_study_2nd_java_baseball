package baseball;

public class Machine {

  private Balls answer;

  public Machine() {}

  public void generateAnswer() {
    this.answer = Balls.rand();
  }

  public BallCompareResult submit(Balls input) {
    return this.answer.compare(input);
  }
}
