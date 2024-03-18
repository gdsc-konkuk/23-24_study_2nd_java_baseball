package baseball;

public class Computer {
    private Numbers numbers;

    public Computer(int length) {
        this.numbers = new Numbers(length);
    }

    public int getNumberLength() {
        return numbers.getNumberLength();
    }
    public String number(){
        return numbers.toString();
    }

    public int checkStrike(String inputString) {
        int strikeCnt = 0;
        for (int i = 0; i < inputString.length(); i++) {
            int number = Integer.parseInt(String.valueOf(inputString.charAt(i)));
            if (number == numbers.get(i)) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    public int checkBall(String inputString) {
        int ballCnt = 0;
        for (int i = 0; i < inputString.length(); i++) {
            int number = Integer.parseInt(String.valueOf(inputString.charAt(i)));
            if (number != numbers.get(i) && numbers.contain(number)) {
                ballCnt++;
            }
        }
        return ballCnt;
    }
}