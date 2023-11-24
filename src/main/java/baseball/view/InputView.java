package baseball.view;

import static baseball.util.InputValidator.validateUserNumber;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<Integer> readUserNumber() {
        System.out.print(Message.INPUT_MESSAGE.message);
        String input = Console.readLine();
        validateUserNumber(input);
        return parseUserInputToNumbers(input);
    }

    private List<Integer> parseUserInputToNumbers(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();
    }

    private enum Message {
        INPUT_MESSAGE("숫자를 입력해주세요 : ");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
