package baseball.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {

	private final List<Integer> answer;
	private int strikeCount;
	private int ballCount;
	private StringBuilder stringBuilder;
	private List<String> numberStringRecord;
	private static final String STRIKE = "스트라이크";
	private static final String BALL = "볼";
	private static final String NOTHING = "낫싱";
	private static final String BLANK = " ";
	private static final String NO_COUNT = "";

	public Game() {
		this.answer = Randoms.pickUniqueNumbersInRange(0, 9, 3);
		this.numberStringRecord = new ArrayList<>();
		System.out.println(answer.toString());
	}

	public List<Integer> getAnswer() {
		return answer;
	}

	public int getNumberStringRecordSize() {
		return numberStringRecord.size();
	}

	public void addToRecord(String numberString) {
		this.numberStringRecord.add(numberString);
	}

	public void compareWithAnswer(List<Integer> numberList) {
		initializeCount();
		for (int i = 0; i < numberList.size(); i++) {
			Integer number = numberList.get(i);
			if (!answer.contains(number)) {
				continue;
			}
			checkStrikeOrBall(number, i);
			// created `checkStrikeOrBall()` method to avoid indent restriction
		}
	}

	public String createResultString() {
		stringBuilder = new StringBuilder();
		stringBuilder.append(createBallString());
		stringBuilder.append(createStrikeString());
		if (stringBuilder.length() == 0) {
			stringBuilder.append(NOTHING);
		}
		return stringBuilder.toString();
	}

	private void initializeCount() {
		strikeCount = 0;
		ballCount = 0;
	}

	private void checkStrikeOrBall(Integer number, int index) {
		if (answer.indexOf(number) == index) {
			strikeCount++;
			return;
		}
		ballCount++;
	}

	private String createBallString() {
		if (ballCount > 0) {
			return ballCount + BALL;
		}
		return NO_COUNT;
	}

	private String createStrikeString() {
		if (strikeCount == 0) {
			return NO_COUNT;
		}
		if (stringBuilder.length() == 0) {
			return strikeCount + STRIKE;
		}
		return BLANK + strikeCount + STRIKE;
	}
}
