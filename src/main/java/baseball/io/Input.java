package baseball.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final String RESTART_FLAG = "1";
    private final String STOP_FLAG = "2";

    public String readGameNumbers(int length) {
        String inputNumber = Console.readLine();
        validationInputNumber(inputNumber, length);
        return inputNumber;
    }

    private void validationInputNumber(String inputNumber, int length) {
        isValidLength(inputNumber, length);
        areNumbers(inputNumber);
    }

    private void areNumbers(String inputNumber) {
        for (int i = 0; i < inputNumber.length(); i++) {
            if (inputNumber.charAt(i) < '1' && inputNumber.charAt(i) > '9') {
                throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
            }
        }
    }

    private void isValidLength(String inputNumber, int length) {
        if (inputNumber.length() != length) {
            throw new IllegalArgumentException("입력 길이가 유효하지 않습니다.");
        }
    }

    public String readRestartFlag() {
        String inputFlag = Console.readLine();
        validationRestartFlag(inputFlag);
        return inputFlag;
    }
    private void validationRestartFlag(String restartFlag) {
        if (!restartFlag.equals(RESTART_FLAG) && !restartFlag.equals(STOP_FLAG)) {
            throw new IllegalArgumentException("1, 2가 아닌 다른 값이 입력되었습니다.");
        }
    }
}
