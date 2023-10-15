import java.util.*;

public class lastVisitedInteger {
    public static List<Integer> solver(String[] arr) {
        List<Integer> list = new ArrayList<>();
        // a stack for keeping the track of last seen integer.
        Stack<Integer> stack = new Stack<>();
        int lastSeenIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            if (word.equals("prev")) {
                if (stack.isEmpty() == false) {
                    int lastVisitedInteger = stack.size() > lastSeenIndex ? stack.get(stack.size() - 1 - lastSeenIndex)
                            : -1;
                    list.add(lastVisitedInteger);
                } else {
                    list.add(-1);
                }
            } else {
                int number = Integer.parseInt(arr[i]);
                stack.push(number);
                lastSeenIndex = 0;
            }
        }
        return list;
    }
}