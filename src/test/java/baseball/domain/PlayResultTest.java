package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayResultTest {
    private Balls answers;

    @BeforeEach
    void setUp() {
        answers = Balls.create(Arrays.asList(1, 2, 3));
    }

    @DisplayName("모두 다른 위치, 모두 다른 수 nothing 테스트")
    @Test
    void play_nothing() {
        List<Integer> userNumber = Arrays.asList(5, 7, 9);
        PlayResult result = answers.play(Balls.create(userNumber));
        assertThat(result).extracting(PlayResult::getStrike,PlayResult::getBall).containsExactly(0, 0);
    }

    @DisplayName("한개의 strike, 한개의 ball 테스트")
    @Test
    void play_1strike_1ball() {
        List<Integer> userNumber = Arrays.asList(1, 7, 2);
        PlayResult result = answers.play(Balls.create(userNumber));
        assertThat(result).extracting(PlayResult::getStrike,PlayResult::getBall).containsExactly(1, 1);
    }

    @DisplayName("3 strike 테스트")
    @Test
    void play_3strike() {
        List<Integer> userNumber = Arrays.asList(1, 2, 3);
        PlayResult result = answers.play(Balls.create(userNumber));
        assertThat(result).extracting(PlayResult::getStrike,PlayResult::getBall).containsExactly(3, 0);
    }
}