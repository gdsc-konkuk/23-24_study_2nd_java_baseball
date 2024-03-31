package baseball.src.view;

import static baseball.common.constant.Constant.SUCCESS_STRING;

public class OutputView {

    public void resultOutput(String output) {
        System.out.println(output);
    }

    public void gameEnd() {
        System.out.println(SUCCESS_STRING);
    }
}
