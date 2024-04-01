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
	GREETING("반갑습니다, ");

	private final String message;

	private Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
