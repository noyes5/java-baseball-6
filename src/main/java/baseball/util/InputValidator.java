package baseball.util;

import static baseball.util.Constants.BALL_AMOUNT;
import static baseball.util.ExceptionMessage.INVALID_NUMBER_LENGTH;
import static baseball.util.ExceptionMessage.INVALID_NUMBER_RANGE;
import static baseball.util.ExceptionMessage.INVALID_NUMERIC_INPUT;

import java.util.regex.Pattern;

public class InputValidator {
    public static final Pattern NUMBER_REGEX = Pattern.compile("^[1-9]+$");

    public static void validateUserNumber(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(INVALID_NUMERIC_INPUT.getMessage());
        }
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
        if (input.length() != BALL_AMOUNT) {
            throw new IllegalArgumentException(INVALID_NUMBER_LENGTH.getMessage());
        }
    }

    private static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}
