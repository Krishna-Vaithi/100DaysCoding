package Day34;

import java.util.Arrays;

public class Day34 {
    public static void main(String[] args) {
        Day34 day34 = new Day34();
        int[] nums = {1, 5, 6, 13, 14, 15, 16, 17};
        System.out.println(day34.minDifference(nums));
    }
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) return 0;
        Arrays.sort(nums);
        int minDiff = Math.min(
                Math.min(nums[n - 1] - nums[3], nums[n - 2] - nums[2]),
                Math.min(nums[n - 3] - nums[1], nums[n - 4] - nums[0])
        );
        return minDiff;
    }
}
