package Day24;

import java.util.PriorityQueue;

public class Day24 {

    public static void main(String[] args) {
        Day24 day24 = new Day24();
        int[] nums = {8,2,4,7};
        int limit = 4;
        System.out.println(day24.longestSubarray(nums,limit));
    }

    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        int a=0,b=0;
        int res = 0;
        while(b<nums.length){
            min.add(nums[b]);
            max.add(nums[b]);
            while(Math.abs(max.peek()-min.peek()) >limit){
                min.remove(nums[a]);
                max.remove(nums[a]);
                a++;
            }
            res = Math.max(b-a+1,res);
            b++;
        }
        return res;
    }
}
