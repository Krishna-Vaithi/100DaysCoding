package Day11;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Day11 {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 1, 4, 2, 1, 3};
        System.out.println(heightChecker(arr));
    }
    public static int heightChecker(int[] heights) {
        int count=0;
        int[] arr = new int[heights.length];
        for(int i=0;i<heights.length;i++){
            arr[i] = heights[i];
        }
        Arrays.sort(arr);
        for(int i=0;i<heights.length;i++){
            if(arr[i]!=heights[i]){
                count++;
            }
        }
        return count;
    }
}
