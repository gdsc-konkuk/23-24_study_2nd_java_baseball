package baseball.src.view;

import baseball.common.exceptions.InputException;
import baseball.utils.Conversion;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

import static baseball.common.constant.Constant.INPUT_NUMBER_STRING;
import static baseball.common.constant.Constant.RESTART_MESSAGE;

public class InputView {

    public String numberInput() {
        System.out.print(INPUT_NUMBER_STRING);
        String numberStr = Console.readLine();
        return numberStr;
    }

    public String restartInput() {
        System.out.println(RESTART_MESSAGE);
        String restartStr = Console.readLine();
        return restartStr;
    }
}
