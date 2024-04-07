package baseball;

public class Application {

  private Balls answer;

  private Application() {}

  public static void main(String[] args) {
    final Application app = new Application();

    do {
      app.initGame();
      app.playGame();
    } while (UserInterface.askRePlay());
  }

  private void initGame() {
    this.answer = new Balls();
  }

  private void playGame() {
    while (true) {
      final String userSelection = UserInterface.getSelection();
      final BallCompareResult result = submit(userSelection);
      UserInterface.printResult(result);

      if (isGameEnd(result)) {
        break;
      }
    }
  }

  private BallCompareResult submit(String userSelection) {
    final Balls selection = new Balls(userSelection);
    return this.answer.compare(selection);
  }

  private boolean isGameEnd(BallCompareResult submissionResult) {
    return submissionResult.isEqual;
  }
}
