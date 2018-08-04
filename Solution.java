import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    private ArrayList<String> hashSet;

    public int solution(int number) {
        char[] digits = String.valueOf(number).toCharArray();

        if (digits.length == 1) return 1;

        Arrays.sort(digits);

        hashSet = new ArrayList<>();

        recursiveFilling(new char[digits.length], digits, 0);

        return hashSet.size();
    }

    private void recursiveFilling(char[] current, char[] next, int position) {
        if (position < current.length) {

            for (int i = 0; i < next.length; i++) {

                if (position == 0 && next[i] == '0') continue;

                if (i > 0 && next[i] == next[i - 1]) continue;

                current[position] = next[i];

                char[] newNext = removeElement(next, i);

                int nextPosition = position + 1;

                if (nextPosition == current.length) {
                    hashSet.add(String.valueOf(current));
                } else {
                    recursiveFilling(current, newNext, nextPosition);
                }
            }
        }
    }

    private char[] removeElement(char[] source, int index) {
        char[] result = new char[source.length - 1];

        int position = 0;
        for (int i = 0; i < source.length; i++) {
            if (i == index) continue;

            result[position] = source[i];
            position++;
        }

        return result;
    }
}
