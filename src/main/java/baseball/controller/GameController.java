package baseball.controller;

import baseball.model.Game;
import baseball.model.Player;
import baseball.util.Printer;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

	private final InputView inputView;
	private final OutputView outputView;
	private Player player;
	private Game game;
	private int proceed;

	public GameController(Printer printer) {
		this.inputView = new InputView();
		this.outputView = new OutputView(printer);
		this.proceed = 1;
	}

	public void gameStart() {
		initialize();
		while (proceed == 1) {
			this.game = new Game();
			while (!game.getAnswer().equals(player.getNumberList())) {
				outputView.printEnterNumber();
				String numberString = inputView.readInput();
				game.addToRecord(numberString);
				player.convertToList(numberString);
				game.compareWithAnswer(player.getNumberList());
				String result = game.createResultString();
				outputView.printResult(result);
			}
			outputView.printTryCount(game.getNumberStringRecordSize());
			outputView.printEnding();
			proceed = Integer.parseInt(inputView.readInput());
		}
	}

	private void initialize() {
		outputView.printGameLogo();
		createPlayer();
		outputView.printGreeting(player.getPlayerName());
		outputView.printNewLine();
		outputView.printGameStart();
	}

	private void createPlayer() {
		outputView.printEnterPlayerName();
		this.player = new Player(inputView.readInput());
		outputView.printNewLine();
	}

}
