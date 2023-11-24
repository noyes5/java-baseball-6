package baseball.util;

import java.util.List;

public interface NumberGenerator {
    int generateRandomNumber(int min, int max);
    List<Integer> createUniqueNumbers(int size);
}
