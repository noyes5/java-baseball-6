package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallsTest {
    @DisplayName("strike 검증 테스트")
    @Test
    void play_strike() {
        Balls computer = Balls.create(Arrays.asList(1, 2, 3));
        BallStatus status = computer.play(new Ball(1, 1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }
    @DisplayName("ball 검증 테스트")
    @Test
    void play_ball() {
        Balls computer = Balls.create(Arrays.asList(1, 2, 3));
        BallStatus status = computer.play(new Ball(2, 1));
        assertThat(status).isEqualTo(BallStatus.BALL);

    }
    @DisplayName("nothing 검증 테스트")
    @Test
    void play_nothing() {
        Balls computer = Balls.create(Arrays.asList(1, 2, 3));
        BallStatus status = computer.play(new Ball(1, 7));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}