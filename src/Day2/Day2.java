package Day2;

public class Day2 {
    public static void main(String[] args) {
        int [] nums = {1,9,2,10,5,7,4,3};
        System.out.println(smallestEqual(nums));
    }
    public static int smallestEqual(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if((i%10)==nums[i]){
                return i;
            }
        }
        return -1;
    }
}
