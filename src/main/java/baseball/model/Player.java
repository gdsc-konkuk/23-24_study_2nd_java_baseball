package baseball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

	private final String playerName;
	private List<Integer> numberList;

	public Player(String playerName) {
		this.playerName = playerName;
		this.numberList = new ArrayList<>();
	}

	public String getPlayerName() {
		return playerName;
	}

	public List<Integer> getNumberList() {
		return numberList;
	}

	public void convertToList(String numberString) {
		numberList = numberString.chars()
			.mapToObj(Character::getNumericValue)
			.collect(Collectors.toList());
		// Stream API practice
	}

}
