package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private List<Integer> numbers;

    public Numbers(int length) {
        this.numbers = createNumbers(length);
        System.out.println(numbers);
    }

    public int getNumberLength() {
        return numbers.toArray().length;
    }

    public int get(int digit){
        return numbers.get(digit);
    }

    public boolean contain(int number) {
        return numbers.contains(number);
    }

    public List<Integer> createNumbers(int length) {
        numbers = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int randomNumber = getRandomNumber();
            numbers.add(randomNumber);
        }
        return numbers;
    }

    private int getRandomNumber() {
        boolean isDuplicated = true;
        int pickedNumber = 0;
        while (isDuplicated) {
            pickedNumber = Randoms.pickNumberInRange(1, 9);
            isDuplicated = validateDuplicate(pickedNumber);
        }
        return pickedNumber;
    }

    private boolean validateDuplicate(int pickedNumber) {
        if (numbers.contains(pickedNumber)) {
            return true;
        }
        return false;
    }
}
