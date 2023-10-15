import java.util.*;

public class longestUnequalAdjacentElement2 {

    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {

        List<List<Integer>> possibleNextIndex = new ArrayList<>();

        int[] dp = new int[n];
        int[] bestNextIndex = new int[n];

        for (int i = 0; i < n; i++) {
            possibleNextIndex.add(new ArrayList<>());
            dp[i] = -1;
            bestNextIndex[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (groups[j] != groups[i]) {
                    if (words[i].length() == words[j].length()) {
                        int distance = 0;
                        for (int k = 0; k < words[j].length(); k++) {
                            if (words[j].charAt(k) == words[i].charAt(k)) {
                                distance++;
                            }
                        }
                        if (distance == 1) {
                            // yeh precomputation kr liyaa.
                            possibleNextIndex.get(i).add(j);
                        }
                    }
                }
            }
        }

        int longest = 0;
        int index = -1;

        for (int j = 0; j < n; j++) {
            int len = longestSubseqStartingFrom(index, dp, bestNextIndex, possibleNextIndex);

            if (len > longest) {
                longest = len;
                index = j;
            }
        }

        List<String> result = new ArrayList<>();
        while (index != n) {
            result.add(words[index]);
            index = bestNextIndex[index];
        }
        return result;

    }

    public static int longestSubseqStartingFrom(int index, int[] dp, int[] bestIndex,
            List<List<Integer>> possibleNextIndex) {

        if (index == dp.length) {
            return 0;
        }
        int ans = dp[index];
        if (ans != -1) {
            return ans;
        }
        ans = 1;
        int bestNextIndex = bestIndex[index];
        bestNextIndex = dp.length;
        for (int i : possibleNextIndex.get(index)) {
            int val = longestSubseqStartingFrom(index, dp, bestIndex, possibleNextIndex) + 1;
            if (val > ans) {
                ans = val;
                bestNextIndex = i;
            }
        }
        dp[index] = ans;
        bestIndex[index] = bestNextIndex;
        return ans;
    }

}
