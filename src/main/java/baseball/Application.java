package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        ArrayList<Integer> computerNums = getComputerNums();
    }

    private static ArrayList<Integer> getComputerNums() {
        ArrayList<Integer> computerNums = new ArrayList<>();
        computerNums.add(Randoms.pickNumberInRange(1, 9));
        computerNums.add(Randoms.pickNumberInRange(1, 9));
        computerNums.add(Randoms.pickNumberInRange(1, 9));

        return computerNums;
    }
}
