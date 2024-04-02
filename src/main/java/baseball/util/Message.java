package baseball.util;

public enum Message {

	GAME_LOGO("\n"
		+ " _   _                    _                  ______                    _             _  _ \n"
		+ "| \\ | |                  | |                 | ___ \\                  | |           | || |\n"
		+ "|  \\| | _   _  _ __ ___  | |__    ___  _ __  | |_/ /  __ _  ___   ___ | |__    __ _ | || |\n"
		+ "| . ` || | | || '_ ` _ \\ | '_ \\  / _ \\| '__| | ___ \\ / _` |/ __| / _ \\| '_ \\  / _` || || |\n"
		+ "| |\\  || |_| || | | | | || |_) ||  __/| |    | |_/ /| (_| |\\__ \\|  __/| |_) || (_| || || |\n"
		+ "\\_| \\_/ \\__,_||_| |_| |_||_.__/  \\___||_|    \\____/  \\__,_||___/ \\___||_.__/  \\__,_||_||_|\n"
		+ "                                                                                          \n"
		+ "                                                                                          \n"),
	ENTER_PLAYER_NAME("플레이어 이름 입력: "),
	GREETING("반갑습니다, "),
	GAME_START("--- 숫자 야구 게임 시작 ---\n"),
	ENTER_NUMBER("> 숫자를 입력해주세요 : "),
	RESULT("결과: "),
	TRY_COUNT(">>> 도전 횟수: "),
	ENDING(">>> 3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
		+ ">>> 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

	private final String message;

	private Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
