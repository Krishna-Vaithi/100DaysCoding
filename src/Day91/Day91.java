package Day91;

import java.util.*;
public class Day91 {
    public static void main(String[] args) {
        Day91 day91 = new Day91();
        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        System.out.println(day91.removeStones(stones));
    }
    private int n;

    public void dfs(List<int[]> stones, int index, boolean[] visited) {
        visited[index] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && (stones.get(i)[0] == stones.get(index)[0] || stones.get(i)[1] == stones.get(index)[1])) {
                dfs(stones, i, visited);
            }
        }
    }

    public int removeStones(int[][] stones) {
        n = stones.length;
        boolean[] visited = new boolean[n];
        List<int[]> stoneList = Arrays.asList(stones);

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(stoneList, i, visited);
                count++;
            }
        }
        return n - count;
    }
}
