package baseball.util;

import static baseball.util.Constants.BALL_AMOUNT;

import java.util.regex.Pattern;

public class InputValidator {
    public static final Pattern NUMBER_REGEX = Pattern.compile("^[1-9]+$");

    public static void validateUserNumber(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만 입력 가능합니다.");
        }
        if (isNumeric(input)) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }
        if (input.length() != BALL_AMOUNT) {
            throw new IllegalArgumentException("숫자는 세자리만 입력이 가능합니다.");
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
