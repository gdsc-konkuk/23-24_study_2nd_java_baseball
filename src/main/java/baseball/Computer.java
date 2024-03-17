package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Computer {
    private int[] nums = new int[3];

    public Computer() {
        setNums();
    }
    private void setNums() {
        for (int i = 0; i < 3; i++) {
            nums[i] = pickNumberInRange(1, 9);
        }
    }

    public int[] getNums() {
        return  nums;
    }

}
