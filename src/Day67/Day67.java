package Day67;

import java.util.HashMap;

public class Day67 {
    public static void main(String[] args) {
        Day67 day67 = new Day67();
        String arr[] = {"d","b","c","b","c","a"};
        int k = 2;
        System.out.println(day67.kthDistinct(arr, k));
    }
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Boolean> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], false);

            } else {
                map.put(arr[i], true);
            }
        }

        for (String item : arr) {
            if (map.get(item) == true) {
                count++;
                if (count == k) {
                    return item;
                }
            }
        }
        return "";
    }
}
