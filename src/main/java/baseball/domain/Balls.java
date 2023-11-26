package baseball.domain;

import static baseball.util.Constants.BALL_AMOUNT;
import static baseball.util.ExceptionMessage.INVALID_BALL_AMOUNT;

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
            throw new IllegalArgumentException(INVALID_BALL_AMOUNT.getMessage());
        }
        List<Ball> mappedBalls = mapBalls(answers);
        return new Balls(mappedBalls);
    }

    private static List<Ball> mapBalls(List<Integer> answers) {
        return IntStream.range(0, BALL_AMOUNT)
                .mapToObj(i -> new Ball(i + 1, answers.get(i)))
                .toList();
    }

    public BallStatus play(Ball userBall) {
        return answers.stream()
                .map(answer -> answer.play(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public PlayResult play(Balls userBalls) {
        PlayResult result = new PlayResult();
        answers.forEach(answerBall -> result.report(userBalls.play(answerBall)));
        return result;
    }
}
