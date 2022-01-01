
class ArrayOperations {
    public static int[][][] createCube() {
        // write your code here
        final int n = 3;
        int[][][] arr = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[i][j][k] = k + (n * j);
                }
            }
        }
        return arr;
    }
}