package baseball.common.exceptions;

import static baseball.common.constant.Constant.*;

public class InputException {

    public static void validateInput(String input) {
        checkNumberLength(input);
        isNumeric(input);
        checkDuplicateNumber(input);
    }

    public static void validateRestartInput(String input) {
        checkRestartNumberLength(input);
        checkRestartNumberType(input);
    }

    private static void checkNumberLength(String input) {
        if (input.length() != NORMAL_INPUT_LENGTH) {
            throw new IllegalArgumentException(WRONG_LENGTH_INPUT_ERROR);
        }
    }

    private static void isNumeric(String input) {
        try {
            int number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_TYPE_INPUT_ERROR);
        }
    }

    private static void checkDuplicateNumber(String input) {
        char firstChar = input.charAt(0);
        char secondChar = input.charAt(1);
        char thirdChar = input.charAt(2);
        if (firstChar == secondChar || secondChar == thirdChar || firstChar == thirdChar) {
            throw new IllegalArgumentException(WRONG_SAME_INPUT_ERROR);
        }
    }

    private static void checkRestartNumberLength(String input) {
        if (input.length() != RESTART_INPUT_LENGTH) {
            throw new IllegalArgumentException(WRONG_LENGTH_INPUT_ERROR);
        }
    }

    private static void checkRestartNumberType(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException(WRONG_TYPE_INPUT_ERROR);
        }
    }

}
