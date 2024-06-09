package Day10;

public class Day10 {

    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println("Output: " + new Day10().subarraysDivByK(nums, k));
    }

    public int subarraysDivByK(int[] nums, int k) {
        int ans = 0;
        int prefix = 0;
        int[] count = new int[k];
        count[0] = 1;
        for (final int num : nums) {
            prefix = (prefix + num % k + k) % k;
            ans += count[prefix];
            ++count[prefix];
        }
        return ans;
    }
}