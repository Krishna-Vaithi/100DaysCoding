package Day15;

import java.util.Arrays;

public class Day15 {
    public static void main(String[] args) {
        Day15 solution = new Day15();
        int[] nums = {1, 2, 2};
        System.out.println(solution.minIncrementForUnique(nums));
    }
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int numTracker = 0;
        int minIncrement = 0;
        for (int num : nums) {
            numTracker = Math.max(numTracker, num);
            minIncrement += numTracker - num;
            numTracker += 1;
        }
        return minIncrement;
    }
}
