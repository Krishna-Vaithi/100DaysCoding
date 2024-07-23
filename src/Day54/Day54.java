package Day54;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day54 {
    public static void main(String[] args) {
        Day54 day54 = new Day54();
        int[] nums = {1, 1, 2, 2, 2, 3};
        System.out.println(Arrays.toString(day54.frequencySort(nums)));
    }
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Integer[] newNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            newNums[i] = nums[i];
        }
        Arrays.sort(newNums, (n1, n2) -> {
            if (freq.get(n1) != freq.get(n2)) {
                return freq.get(n1) - freq.get(n2);
            } else {
                return n2 - n1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }
        return nums;
    }
}
