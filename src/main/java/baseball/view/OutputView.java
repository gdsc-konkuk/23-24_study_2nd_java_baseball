package baseball.view;

import static baseball.util.Message.*;

import baseball.util.Printer;

public class OutputView {

	private final Printer printer;

	public OutputView(Printer printer) {
		this.printer = printer;
	}

	public void printNewLine() {
		printer.globalNewLine();
	}

	public void printGameLogo() {
		printer.globalPrint(GAME_LOGO);
	}

	public void printEnterPlayerName() {
		printer.globalPrint(ENTER_PLAYER_NAME);
	}

	public void printGreeting(String playerName) {
		printer.globalPrintlnMessageWithString(GREETING, playerName);
	}

	public void printGameStart() {
		printer.globalPrintln(GAME_START);
	}

	public void printEnterNumber() {
		printer.globalPrint(ENTER_NUMBER);
	}

	public void printTryCount(int numberStringRecordSize) {
		printer.globalPrintlnMessageWithString(TRY_COUNT, Integer.toString(numberStringRecordSize));
	}

	public void printResult(String result) {
		printer.globalPrintlnMessageWithString(RESULT, result);
	}

	public void printEnding() {
		printer.globalPrintln(ENDING);
	}

}
