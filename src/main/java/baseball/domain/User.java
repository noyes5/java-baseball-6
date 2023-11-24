package baseball.domain;

import java.util.List;

public class User {
    private final Balls balls;

    public User(List<Integer> userNumber) {
        this.balls = createByNumber(userNumber);
    }

    private Balls createByNumber(List<Integer> userNumber) {
        return Balls.create(userNumber);
    }
}
