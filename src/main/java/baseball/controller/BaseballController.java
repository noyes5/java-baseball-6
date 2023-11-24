package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.PlayResult;
import baseball.domain.User;
import baseball.util.ComputerNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    private final InputView inputView;
    private final OutputView outputView;
    private Computer computer;

    public BaseballController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        outputView.printMainMessage();
        initComputerBalls();
        User user = readUserNumber();
        PlayResult result = computer.play(user.getBalls());
        outputView.printGameResult(result);
    }

    private void initComputerBalls() {
        computer = new Computer(new ComputerNumberGenerator());
    }

    private User readUserNumber() {
        return new User(inputView.readUserNumber());
    }
}
