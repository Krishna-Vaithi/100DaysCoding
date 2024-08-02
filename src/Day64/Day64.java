package Day64;

import java.util.Arrays;

public class Day64 {
    public static void main(String[] args) {
        Day64 day64 = new Day64();
        int[] nums = {1, 0, 1, 0, 1};
        System.out.println(day64.minSwaps(nums));
    }
    public int minSwaps(int[] nums) {
        int k = Arrays.stream(nums).sum();
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < k; ++i) {
            cnt += nums[i];
        }
        int mx = cnt;
        for (int i = k; i < n + k; ++i) {
            cnt += nums[i % n] - nums[(i - k + n) % n];
            mx = Math.max(mx, cnt);
        }
        return k - mx;
    }
}
