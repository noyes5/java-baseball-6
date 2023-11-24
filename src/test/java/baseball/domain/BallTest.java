package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BallTest {

    @DisplayName("동일한 위치와 숫자일때, STRIKE 검증")
    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 7",
            "3, 9"
    })
    void 스트라이크(int position, int number) {
        Ball userBall = new Ball(position, number);
        Ball computer = new Ball(position, number);
        assertThat(computer.play(userBall)).isEqualTo(BallStatus.STRIKE);
    }

    @DisplayName("다른 위치, 동일 숫자일 때 STRIKE 검증")
    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 7",
            "3, 9"
    })
    void 볼(int position, int number) {
        Ball userBall = new Ball(position, number);
        Ball computer = new Ball(position + 1, number);
        assertThat(computer.play(userBall)).isEqualTo(BallStatus.BALL);
    }

    @DisplayName("다른 위치, 다른 숫자일떄 NOTHING 검증")
    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 7",
            "3, 9"
    })
    void 낫싱(int position, int number) {
        Ball userBall = new Ball(0, 0);
        Ball computer = new Ball(position, number);
        assertThat(computer.play(userBall)).isEqualTo(BallStatus.NOTHING);
    }
}