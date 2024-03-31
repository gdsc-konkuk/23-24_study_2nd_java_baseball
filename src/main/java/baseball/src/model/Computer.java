package baseball.src.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.common.constant.Constant.*;

public class Computer {
    private final ArrayList<Integer> answer = new ArrayList<>();

    public Computer() {
        while (answer.size() < ANSWER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public ArrayList<Integer> getAnswer() {
        return answer;
    }

}
