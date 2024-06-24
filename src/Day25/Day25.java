package Day25;

public class Day25 {
    public static void main(String[] args) {
        Day25 day25 = new Day25();
        int[] nums = {0, 0, 0, 1, 0, 1, 1, 0};
        int k = 3;
        System.out.println(day25.minKBitFlips(nums, k));
    }

    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int operation = 0, current = 0;
        for (int i = 0; i < n - k + 1; i++) {
            if (nums[i] == 0) {
                if (current % 2 == 0) {
                    dp[i] += 1;
                    dp[i + k - 1] -= 1;
                    operation += 1;
                }
            } else {
                if (current % 2 == 1) {
                    dp[i] += 1;
                    dp[i + k - 1] -= 1;
                    operation += 1;
                }
            }
            current += dp[i];
        }
        for (int i = n - k + 1; i < n; i++) {
            if (nums[i] == 0) {
                if (current % 2 == 0) {
                    return -1;
                }
            } else {
                if (current % 2 == 1) {
                    return -1;
                }
            }
            current += dp[i];
        }
        return operation;
    }
}
