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

	public void globalPrint(String playerName) {
		try {
			bufferedWriter.write(playerName);
			bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
			// might need refactoring(exception handling) here
		}
	}
}
