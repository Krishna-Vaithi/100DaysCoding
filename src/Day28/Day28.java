package Day28;

public class Day28 {

    public static void main(String[] args) {
        Day28 day28 = new Day28();
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        System.out.println(day28.findCenter(edges));
    }

    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] degreeCount = new int[n + 1];
        for (int[] edge : edges) {
            degreeCount[edge[0]]++;
            degreeCount[edge[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (degreeCount[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
