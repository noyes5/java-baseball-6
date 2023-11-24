package baseball.view;

import static baseball.util.InputValidator.validateUserNumber;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<Integer> readUserNumber() {
        String input = Console.readLine();
        validateUserNumber(input);
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();
    }
}
