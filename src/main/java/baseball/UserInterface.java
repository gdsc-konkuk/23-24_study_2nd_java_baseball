package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserInterface {

  private static final int REPLAY_OPTION_OK = 1;
  private static final int REPLAY_OPTION_NO = 2;

  public Balls getInput() {
    System.out.println("숫자를 입력해주세요 : ");
    String input = Console.readLine();
    return Balls.fromStr(input);
  }

  public void printSubmitResult(BallCompareResult result) {
    if (result.hasBall()) {
      System.out.printf("%d볼 ", result.ballCount);
    }

    if (result.hasStrike()) {
      System.out.printf("%d스트라이크\n", result.strikeCount);
    }

    if (result.isEqual) {
      System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", result.strikeCount);
    }
  }

  public boolean askRePlay() {
    System.out.printf("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.\n", REPLAY_OPTION_OK, REPLAY_OPTION_NO);
    String selection = Console.readLine();

    if (selection.equals(Integer.toString(REPLAY_OPTION_OK))) {
      return true;
    }

    if (selection.equals(Integer.toString(REPLAY_OPTION_NO))) {
      return false;
    }

    throw new IllegalArgumentException();
  }
}
