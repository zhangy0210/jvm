class Solution {
    public static int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length, n = matrix[0].length;

        int[][] dp = new int[m][n];

        int maxLength = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j],
                                Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }

                    maxLength = Math.max(dp[i][j], maxLength);
                }
            }
        }

        return maxLength * maxLength;
    }
    public static void main(String[] args) {
        char[][] nums = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalSquare(nums));
    }
}