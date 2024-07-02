package Day33;

import java.util.ArrayList;

public class Day33 {
    public static void main(String[] args) {
        Day33 day33 = new Day33();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] ans = day33.intersect(nums1, nums2);
        for(int x:ans){
            System.out.print(x+" ");
        }
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> l1=new ArrayList<>();
        ArrayList<Integer> l2=new ArrayList<>();

        for(int x:nums1){
            l1.add(x);
        }

        for(int x:nums2){
            if(l1.contains(x)){
                l2.add(x);
                l1.remove(Integer.valueOf(x));
            }
        }

        int [] ans=new int[l2.size()];
        int i=0;
        for(int x:l2){
            ans[i++]=x;
        }

        return ans;
    }
}
