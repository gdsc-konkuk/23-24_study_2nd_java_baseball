package baseball;

public enum MESSAGE {
    INPUT("숫자를 입력하세요 : "),
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱"),
    SUCCESS("개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    REPLAY("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private String message;

    MESSAGE(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
