package baseball.view;

import static baseball.util.Message.*;

import baseball.util.Printer;

public class OutputView {

	private final Printer printer;

	public OutputView(Printer printer) {
		this.printer = printer;
	}

	public void printGameLogo() {
		printer.globalPrint(GAME_LOGO);
	}

	public void printEnterPlayerName() {
		printer.globalPrint(ENTER_PLAYER_NAME);
	}

	public void printGreeting() {
		printer.globalPrint(GREETING);
	}

	public void printPlayerName(String playerName) {
		printer.globalPrint(playerName);
	}
}
