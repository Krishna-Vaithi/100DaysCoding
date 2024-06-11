package Day12;

import java.util.Arrays;

public class Day12 {

    public static void main(String[] args) {
        int arr1[] = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int arr2[] = new int[]{2,1,4,3,9,6};
        System.out.println(Arrays.toString(new Day12().relativeSortArray(arr1, arr2)));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int a = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == arr2[i]) {
                    int temp = arr1[a];
                    arr1[a] = arr1[j];
                    arr1[j] = temp;
                    a++;
                }
            }
        }
        Arrays.sort(arr1, a, arr1.length);
        return arr1;
    }
}
