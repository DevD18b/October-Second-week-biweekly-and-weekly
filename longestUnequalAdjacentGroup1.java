import java.util.*;

public class longestUnequalAdjacentGroup1 {

    public static List<String> solver(String[] word, int[] letter, int n) {
        List<String> list = new ArrayList<>();
        list.add(word[0]);
        int i = 0;
        int j = 1;
        while (j < n) {
            if (word[j] != word[i]) {
                list.add(word[j]);
                i = j;
            }
            j++;
        }
        return list;
    }
}
