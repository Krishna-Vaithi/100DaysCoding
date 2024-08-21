package Day82;

public class Day82 {
    public static void main(String[] args) {
        Day82 day82 = new Day82();
        System.out.println(day82.stoneGameII(new int[]{2, 7, 9, 4, 4}));
    }

    public int stoneGameII(int[] piles) {
        int dp[][][] = new int[piles.length + 1][piles.length + 1][2];
        int ps[] = new int[piles.length + 1];
        ps[0] = 0;
        for (int i = 1; i < ps.length; i++) {
            ps[i] = ps[i - 1] + piles[i - 1];
        }
        return helper(piles, 0, piles.length, 1, ps, 1, dp);
    }

    public int helper(int[] piles, int i, int j, int ch, int ps[], int m, int[][][] dp) {
        if (i == j) {
            return 0;
        }
        if (dp[i][m][ch] != 0) return dp[i][m][ch];
        int total = 0;
        int ans = ch == 1 ? 0 : Integer.MAX_VALUE;
        for (int k = 1; k <= 2 * m; k++) {
            if (i + k > j) break;
            total = total + piles[i + k - 1];
            if (ch == 1) {
                int sum = total + helper(piles, i + k, j, 0, ps, Math.max(m, k), dp);
                ans = Math.max(sum, ans);
            } else {
                int sum = helper(piles, i + k, j, 1, ps, Math.max(m, k), dp);
                ans = Math.min(ans, sum);
            }
        }
        return dp[i][m][ch] = ans;
    }
}