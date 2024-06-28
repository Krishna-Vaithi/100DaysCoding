package Day29;

import java.util.Arrays;

public class Day29 {
    public static void main(String[] args) {
        Day29 day29 = new Day29();
        int n = 4;
        int[][] roads = {{1, 0}, {1, 2}, {1, 3}};
        System.out.println(day29.maximumImportance(n, roads));
    }
    public long maximumImportance(int n, int[][] roads) {
        long[] cnt = new long[50001];
        long res = 0;
        for (int[] r : roads) {
            ++cnt[r[0]];
            ++cnt[r[1]];
        }
        Arrays.sort(cnt, 0, n);
        for (int i = 0; i < n; ++i)
            res += cnt[i] * (i + 1);
        return res;
    }
}
