package Day94;

public class Day94 {
    public static void main(String[] args) {
        Day94 day94 = new Day94();
        int[] original = {1,2,3,4};
        int m = 2;
        int n = 2;
        int[][] ans = day94.construct2DArray(original, m, n);
        for(int i = 0; i < ans.length; i++) {
            for(int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n != original.length) {
            return new int[0][0];
        }
        int count = 0;
        int ans[][] = new int[m][n];
        int j = 0;
        while(m-- > 0) {
            n = ans[m].length;
            int i = 0;
            while(n-- > 0 && count < original.length) {
                ans[j][i++] = original[count++];
            }
            j++;
        }

        return ans;
    }
}
