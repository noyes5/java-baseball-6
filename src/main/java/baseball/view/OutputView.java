package baseball.view;

import static baseball.domain.BallStatus.BALL;
import static baseball.domain.BallStatus.NOTHING;
import static baseball.domain.BallStatus.STRIKE;
import static baseball.util.Constants.SPACE;

import baseball.domain.PlayResult;

public class OutputView {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public void printMainMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printGameResult(PlayResult result) {
        System.out.println(getBallAndStrike(result));
    }

    private String getBallAndStrike(PlayResult result) {
        return getResultMessage(result.getStrike(),result.getBall());
    }

    private String getResultMessage(int strike, int ball) {
        StringBuilder gameResult = new StringBuilder();

        appendBallResult(ball, gameResult);
        appendStrikeResult(strike, gameResult);
        appendNothing(strike, ball, gameResult);
        return gameResult.toString();
    }

    private void appendStrikeResult(int strike, StringBuilder gameResult) {
        if (strike != 0) {
            gameResult.append(strike)
                    .append(STRIKE.getMessage());
        }
    }

    private void appendBallResult(int ball, StringBuilder gameResult) {
        if (ball != 0) {
            gameResult.append(ball)
                    .append(BALL.getMessage());
        }
        if (gameResult.length() != 0) {
            gameResult.append(SPACE);
        }
    }

    private void appendNothing(int strike, int ball, StringBuilder gameResult) {
        if (ball == 0 && strike == 0) {
            gameResult.append(NOTHING.getMessage());
        }
    }
}
