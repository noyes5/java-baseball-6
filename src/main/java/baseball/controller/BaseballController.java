package baseball.controller;

import baseball.domain.Computer;
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
        System.out.println("숫자 야구 게임을 시작합니다.");
        initComputerBalls();
        User user = readUserNumber();
        computer.play(user.getBalls());
    }

    private void initComputerBalls() {
        computer = new Computer(new ComputerNumberGenerator());
    }

    private User readUserNumber() {
        return new User(inputView.readUserNumber());
    }
}
