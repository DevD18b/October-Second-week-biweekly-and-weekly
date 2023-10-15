public class findIndexWithGivenDifferenceAndValueDifference {

    public static int[] solver(int[] arr, int valueDifference, int indexDifference) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (Math.abs(i - j) == indexDifference && Math.abs(arr[i] - arr[j]) == valueDifference) {
                    return new int[] { i, j };
                }
            }
        }

        return new int[] { -1, -1 };

    }
}