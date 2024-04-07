package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserInterface {

  private static final int REPLAY_OPTION_OK = 1;
  private static final int REPLAY_OPTION_NO = 2;

  public static String getSelection() {
    System.out.print("숫자를 입력해주세요 : ");
    return Console.readLine();
  }

  public static void printResult(BallCompareResult result) {
    System.out.println(result);
  }

  public static boolean askRePlay() {
    System.out.printf("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.\n", REPLAY_OPTION_OK, REPLAY_OPTION_NO);
    final String selection = Console.readLine();

    if (selection.equals(Integer.toString(REPLAY_OPTION_OK))) {
      return true;
    }

    if (selection.equals(Integer.toString(REPLAY_OPTION_NO))) {
      return false;
    }

    throw new IllegalArgumentException();
  }
}
