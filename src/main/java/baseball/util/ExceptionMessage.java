package baseball.util;

public enum ExceptionMessage {
    INVALID_NUMERIC_INPUT("숫자만 입력이 가능합니다."),
    INVALID_NUMBER_LENGTH("숫자는 세자리만 입력이 가능합니다."),
    INVALID_NUMBER_RANGE("1부터 9까지의 숫자만 입력 가능합니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
