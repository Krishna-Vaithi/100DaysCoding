package Day17;

public class Day17 {
    public static void main(String[] args) {
        Day17 day17 = new Day17();
        int[] nums = {1, 3};
        int n = 6;
        System.out.println(day17.minPatches(nums, n));
    }
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int result = 0;
        int i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                miss += miss;
                result++;
            }
        }
        return result;
    }
}
