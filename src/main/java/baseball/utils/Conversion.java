package baseball.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Conversion {
    public static ArrayList<Integer> stringToArrayList(String input) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int digit = Character.getNumericValue(c);
            arrayList.add(digit);
        }
        return arrayList;
    }
}
