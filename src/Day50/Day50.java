package Day50;

import java.util.ArrayList;
import java.util.List;

public class Day50 {
    public static void main(String[] args) {
        Day50 day50 = new Day50();
        int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
        System.out.println(day50.luckyNumbers(matrix));
    }
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            int rowMin = Integer.MAX_VALUE;
            int rowMinIndex = -1;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] < rowMin) {
                    rowMin = matrix[i][j];
                    rowMinIndex = j;
                }
            }
            boolean isLucky = true;
            for (int k = 0; k < n; k++) {
                if (matrix[k][rowMinIndex] > rowMin) {
                    isLucky = false;
                    break;
                }
            }
            if (isLucky) {
                ans.add(rowMin);
            }
        }
        return ans;
    }
}
