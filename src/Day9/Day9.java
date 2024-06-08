package Day9;

import java.util.HashMap;
import java.util.Map;

public class Day9 {
    public static void main(String[] args) {
        int arr[] = new int[]{23,2,4,6,7};
        int k = 6;
        System.out.println(new Day9().checkSubarraySum(arr,k));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (k != 0) sum %= k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
