package Day23;

public class Day23 {

    public static void main(String[] args) {
        Day23 day23 = new Day23();
        System.out.println(day23.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
    }
    public int numberOfSubarrays(int[] nums, int k) {
        for (int i=0; i<nums.length; i++){
            if(nums[i]%2 == 0){
                nums[i] = 0;
            }else {
                nums[i] =1;
            }
        }
        return calculateSum(nums, k) - calculateSum(nums, k-1);
    }
    public int calculateSum(int[] arr, int goal){
        if (goal < 0){
            return 0;
        }
        int sum = 0;
        int count =0;
        int start =0;
        int end =0;
        while (end < arr.length){
            sum = sum +arr[end];
            if(sum <= goal){
                count = count + (end - start + 1);
                end++;
            } while (sum > goal){
                sum = sum - arr[end] -arr[start];
                start++;
            }
        }
        return count;
    }
}