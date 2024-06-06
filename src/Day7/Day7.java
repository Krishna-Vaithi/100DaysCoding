package Day7;

import java.util.ArrayList;
import java.util.Arrays;

public class Day7 {
    public static void main(String[] args) {
        Day7 day7 = new Day7();
        int arr[] = new int[]{1,2,3,6,2,3,4,7,8};
        System.out.println(day7.isNStraightHand(arr,3));
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0)
            return false;
        if(groupSize==1||groupSize==0)
            return true;
        Arrays.sort(hand);
        ArrayList<Integer> arr=new ArrayList<>();
        for(int ii=0;ii<hand.length;ii++)
        {
            arr.add(hand[ii]);
        }
        while(arr.size()>0)
        {
            int c=0;
            int a=arr.remove(0);
            c++;
            for(int j=0;j<arr.size();j++)
            {
                if(arr.get(j)==a+1)
                {
                    a=arr.remove(j);
                    j--;
                    c++;
                }
                if(c==groupSize)
                    break;
            }
            if(c!=groupSize)
                return false;
        }
        return true;
    }
}
