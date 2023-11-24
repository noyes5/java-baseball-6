package baseball.util;

import static baseball.util.ExceptionMessage.INVALID_NUMBER_LENGTH;
import static baseball.util.ExceptionMessage.INVALID_NUMBER_RANGE;
import static baseball.util.ExceptionMessage.INVALID_NUMERIC_INPUT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @Nested
    class InvalidInput {
        @DisplayName("입력크기를 벗어나면 예외 테스트")
        @ParameterizedTest
        @ValueSource(strings = {"223232934839448394893434934893493", "1890273490312390218920139201213890"})
        void 초과_크기_검증(String input) {
            assertThatThrownBy(() -> InputValidator.validateUserNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INVALID_NUMERIC_INPUT.getMessage());
        }

        @DisplayName("입력이 세자리 아닌경우 예외 테스트")
        @ParameterizedTest
        @ValueSource(strings = {"12", "7891"})
        void 세자리_검증(String input) {
            assertThatThrownBy(() -> InputValidator.validateUserNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INVALID_NUMBER_LENGTH.getMessage());
        }

        @DisplayName("입력이 유효한 범위가 아니면 예외 테스트")
        @ParameterizedTest
        @ValueSource(strings = {"012", "804", "430"})
        void 범위내_숫자검증(String input) {
            assertThatThrownBy(() -> InputValidator.validateUserNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INVALID_NUMBER_RANGE.getMessage());
        }
    }
}