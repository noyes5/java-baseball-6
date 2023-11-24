package baseball.domain;

import static baseball.util.Constants.BALL_AMOUNT;

import baseball.util.NumberGenerator;

public class Computer {
    private Balls balls;

    public Computer(NumberGenerator numberGenerator) {
        makeBalls(numberGenerator);
    }

    private void makeBalls(NumberGenerator numberGenerator) {
        Balls balls = Balls.create(numberGenerator.createUniqueNumbers(BALL_AMOUNT));
        this.balls = balls;
    }

    public PlayResult play(Balls userBalls) {
        return balls.play(userBalls);
    }
}
