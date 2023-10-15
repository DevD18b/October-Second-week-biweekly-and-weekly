import java.util.*;

public class shortestLengthLexSmallerStringContainingKOnes {
    public static String solver(String str, int k) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                String substring = str.substring(i, j);
                if (countOnes(substring) == k) {
                    list.add(substring);
                }
            }
        }

        Collections.sort(list, (a, b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length());

        return list.get(0);
    }

    public static int countOnes(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '1') {
                count++;
            }
        }
        return count;
    }

    public static String optimized(String str, int k) {
        int i = 0;
        int j = 0;
        int count = 0;
        String ans = "";
        while (j < str.length()) {
            if (str.charAt(j) == '0') {
                continue;
            } else if (str.charAt(j) == '1') {
                count++;
                if (count == k) {
                    while (i <= j && str.charAt(i) == '0') {
                        i++;
                    }
                    String currentSubString = str.substring(i, j + 1);
                    if (ans.length() > currentSubString.length()
                            || ans.length() == currentSubString.length() && currentSubString.compareTo(ans) < 0) {
                        ans = currentSubString;
                    }
                    i++;
                    count--;
                }
            }
            j++;
        }
        return ans;
    }
}
