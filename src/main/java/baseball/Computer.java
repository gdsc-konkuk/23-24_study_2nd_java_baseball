package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Computer {
    private int[] nums = new int[3];

    public Computer() {
        setNums();
    }
    private void setNums() {
        for (int i = 0; i < 3; i++) {
            int x = pickNumberInRange(1, 9);
            if (checkNums(x, i)) nums[i] = x;
            else i--;
        }
    }
    private boolean checkNums(int x, int e) {
        for (int i = 0; i < e; i++) {
            if (x == nums[i]) {
                return false;
            }
        }
        return true;
    }

    public int[] getNums() {
        return  nums;
    }

}
