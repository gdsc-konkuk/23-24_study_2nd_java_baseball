package baseball.controller;

import baseball.model.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

	private final InputView inputView;
	private final OutputView outputView;
	private Player player;

	public GameController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void gameStart() {
		printGameLogo();
		createPlayer();
		printGreeting();

	}

	private void printGameLogo() {
		outputView.printGameLogo();
	}

	private void createPlayer() {
		outputView.printEnterPlayerName();
		this.player = new Player(inputView.readPlayerName());
	}

}
