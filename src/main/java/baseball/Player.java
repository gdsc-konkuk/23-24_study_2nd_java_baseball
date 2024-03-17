package baseball;

public class Player {
    private int[] nums = new int[3];

    public void setNums(String numString) {
        for (int i = 0; i < 3; i++) {
            nums[i] = numString.charAt(i) - '0';
        }
    }

    public int[] getNums() {
        return  nums;
    }
}
