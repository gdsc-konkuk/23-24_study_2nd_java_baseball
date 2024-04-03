package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

  public static final int NUM_OF_BALL = 3;
  public static final int BALL_VALUE_MIN = 1;
  public static final int BALL_VALUE_MAX = 9;

  private final Machine machine;

  private Application() {
    this.machine = new Machine();
  }

  public static void main(String[] args) {
    final Application app = new Application();
    do {
      app.startGame();
    } while (getUserWantReGame());
  }

  private void startGame() {
    this.machine.generateAnswer();
    while (true) {
      Balls input = getInput();
      BallCompareResult result = this.machine.submit(input);
      printResult(result);

      if (isGameEnd(result)) {
        printGameEnd();
        break;
      }
    }
  }

  private static Balls getInput() {
    System.out.println("숫자를 입력해주세요 : ");
    String input = Console.readLine();
    return Balls.from(input);
  }

  private static void printResult(BallCompareResult result) {
    if (result.ballCount != 0) {
      System.out.printf("%d볼 ", result.ballCount);
    }

    if (result.strikeCount != 0) {
      System.out.printf("%d스트라이크\n", result.strikeCount);
    }
  }

  private static boolean isGameEnd(BallCompareResult result) {
    return result.strikeCount == NUM_OF_BALL;
  }

  private static boolean getUserWantReGame() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    String selection = Console.readLine();

    if (selection.equals("1")) {
      return true;
    }

    if (selection.equals("2")) {
      return false;
    }

    throw new IllegalArgumentException();
  }

  private static void printGameEnd() {
    System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", NUM_OF_BALL);
  }
}
