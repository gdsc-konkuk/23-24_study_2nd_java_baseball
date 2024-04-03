package baseball;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import baseball.controller.GameController;
import baseball.util.Printer;

public class Application {
	public static void main(String[] args) {
		//TODO: 숫자 야구 게임 구현
		Printer printer = new Printer(new BufferedWriter(new OutputStreamWriter(System.out)));

		GameController gameController = new GameController(printer);

		gameController.gameStart();
	}
}
