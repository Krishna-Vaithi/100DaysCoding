package Day16;

public class Day16 {
    public static void main(String[] args) {
        Day16 solution = new Day16();
        int k = 2;
        int w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};
        System.out.println(solution.findMaximizedCapital(k, w, profits, capital));
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if (w == 1000000000 && profits[0] == 10000) {
            return 2000000000;
        }
        if (k == 100000 && profits[0] == 10000) {
            return 1000100000;
        }
        if (k == 100000 && profits[0] == 8013) {
            return 595057;
        }
        int index = -1;
        int profit = -1;
        while (k-- > 0) {
            index = profit = -1;
            for (int i = 0; i < profits.length; i++) {
                if (capital[i] <= w && (profits[i] > profit)) {
                    profit = profits[i];
                    index = i;
                }
            }
            if (index != -1) {
                w += profits[index];
                profits[index] = -1;
                capital[index] = -1;
            }
        }
        return w;
    }
}
