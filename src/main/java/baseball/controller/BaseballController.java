package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.GameStatus;
import baseball.domain.PlayResult;
import baseball.domain.User;
import baseball.util.ComputerNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    private final InputView inputView;
    private final OutputView outputView;
    private Computer computer;
    private GameStatus gameStatus;

    public BaseballController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameStatus = GameStatus.PLAY;
    }

    public void play() {
        outputView.printMainMessage();
        playSingleGame();
    }

    private void playSingleGame() {
        initComputerBalls();
        PlayResult result = new PlayResult();
        while (result.isNotGameEnd()) {
            User user = readUserNumber();
            result = computer.play(user.getBalls());
            outputView.printGameResult(result);
        }
    }

    private void initComputerBalls() {
        computer = new Computer(new ComputerNumberGenerator());
    }

    private User readUserNumber() {
        return new User(inputView.readUserNumber());
    }
}
