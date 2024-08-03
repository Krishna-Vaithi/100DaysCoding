package Day65;

import java.util.Arrays;

public class Day65 {
    public static void main(String[] args) {
        Day65 day65 = new Day65();
        int[] target = {1,2,3,4};
        int[] arr = {2,4,1,3};
        System.out.println(day65.canBeEqual(target, arr));
    }
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        boolean flag = true;
        for(int i=0;i<arr.length;i++){
            if(target[i]!=arr[i]){
                flag = false;
            }
        }
        return flag;
    }
}
