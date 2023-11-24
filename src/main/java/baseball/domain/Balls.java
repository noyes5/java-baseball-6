package baseball.domain;

import static baseball.util.Constants.BALL_AMOUNT;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Balls {
    private final List<Ball> answers;

    private Balls(List<Ball> answers) {
        this.answers = new ArrayList<>(answers);
    }

    public static Balls create(List<Integer> answers) {
        if (answers.size() != BALL_AMOUNT) {
            throw new IllegalArgumentException("볼의 갯수는 3개여야 합니다.");
        }
        List<Ball> mappedBalls = mapBalls(answers);
        return new Balls(mappedBalls);
    }

    private static List<Ball> mapBalls(List<Integer> answers) {
        return IntStream.range(0, BALL_AMOUNT)
                .mapToObj(i -> new Ball(i + 1, answers.get(i)))
                .toList();
    }
}
