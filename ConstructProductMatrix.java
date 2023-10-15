public class ConstructProductMatrix {

    public static int[][] solver(int[][] grid) {

        int[][] product = new int[grid.length][grid[0].length];

        int pref = grid[0][0];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                product[i][j] = pref % mod;
                pref = (pref * grid[i][j]) % mod;
            }
        }
        int suffix = 1;
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                product[i][j] = (product[i][j] * suffix) % mod;
                suffix = suffix * grid[i][j];
            }
        }

        return product;
    }

    static int mod = 12345;
}
