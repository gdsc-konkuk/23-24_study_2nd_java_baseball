package baseball;

public class Application {

  private final Machine machine;
  private final UserInterface ui;
  private Application() {
    this.machine = new Machine();
    this.ui = new UserInterface();
  }

  public static void main(String[] args) {
    final Application app = new Application();
    final UserInterface ui = new UserInterface();

    do {
      app.playGame();
    } while (ui.askRePlay());
  }

  private void playGame() {
    this.machine.generateAnswer();

    while (true) {
      Balls input = this.ui.getInput();
      BallCompareResult result = this.machine.submit(input);
      this.ui.printSubmitResult(result);

      if (isGameEnd(result)) {
        break;
      }
    }
  }

  private boolean isGameEnd(BallCompareResult submissionResult) {
    return submissionResult.isEqual;
  }
}
