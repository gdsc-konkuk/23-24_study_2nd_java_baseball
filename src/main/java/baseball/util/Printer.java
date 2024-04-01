package baseball.util;

import java.io.BufferedWriter;
import java.io.IOException;

public class Printer {

	private final BufferedWriter bufferedWriter;

	public Printer(BufferedWriter bufferedWriter) {
		this.bufferedWriter = bufferedWriter;
	}

	public void globalPrintln(Message message) {
		try {
			bufferedWriter.write(message.getMessage());
			bufferedWriter.newLine();
			bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
			// might need refactoring(exception handling) here
		}
	}

	public void globalPrint(Message message) {
		try {
			bufferedWriter.write(message.getMessage());
			bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
			// might need refactoring(exception handling) here
		}
	}

	public void globalPrintlnWithPlayerName(Message message, String playerName) {
		try {
			bufferedWriter.write(message.getMessage());
			bufferedWriter.write(playerName);
			bufferedWriter.newLine();
			bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
			// might need refactoring(exception handling) here
		}
	}
}
