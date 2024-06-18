package Day19;

public class Day19 {
    public static void main(String[] args) {
        Day19 day19 = new Day19();
        int[] difficulty = {2, 4, 6, 8, 10};
        int[] profit = {10, 20, 30, 40, 50};
        int[] worker = {4, 5, 6, 7};
        System.out.println(day19.maxProfitAssignment(difficulty, profit, worker));
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxProfit = 0;
        for (int i = 0; i < worker.length; i++) {
            int max = 0;
            for (int j = 0; j < difficulty.length; j++) {
                if (difficulty[j] <= worker[i]) {
                    max = Math.max(max, profit[j]);
                }
            }
            maxProfit += max;
        }
        return maxProfit;
    }
}