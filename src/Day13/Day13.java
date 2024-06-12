package Day13;

import java.util.Arrays;

public class Day13 {
    public static void main(String[] args) {
        new Day13().sortColors(new int[]{2,0,2,1,1,0});
    }
    public void sortColors(int[] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length-1;j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
