package Day79;

import java.util.Arrays;

public class Day79 {
    public static void main(String[] args) {
        Day79 day79 = new Day79();
        int[][] points = {{1,2,3},{1,5,1},{3,1,1}};
        System.out.println(day79.maxPoints(points));
    }
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[][] dp = new long[m][n];
        for (int j = 0; j < n; j++) dp[0][j] = points[0][j];
        for (int i = 1; i < m; i++) {
            long[] fmax = new long[n];
            long[] fmin = new long[n];
            fmin[0] = dp[i - 1][0] + 0;
            fmax[n - 1] = dp[i - 1][n - 1] - (n - 1);
            for (int j = 1; j < n; j++) {
                fmin[j] = Math.max(fmin[j - 1], dp[i - 1][j] + j);
            }
            for (int j = n - 2; j >= 0; j--) {
                fmax[j] = Math.max(fmax[j + 1], dp[i - 1][j] - j);
            }
            for (int j = 0; j < n; j++) {
                dp[i][j] = Math.max(points[i][j] + j + fmax[j], points[i][j] - j + fmin[j]);
            }
        }
        return Arrays.stream(dp[m - 1]).max().getAsLong();
    }
}
