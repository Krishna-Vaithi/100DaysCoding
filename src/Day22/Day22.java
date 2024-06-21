package Day22;

public class Day22 {
    public static void main(String[] args) {
        Day22 day22 = new Day22();
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;
        System.out.println(day22.maxSatisfied(customers, grumpy, minutes));
    }
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int unstatisfied = -1;
        int satisfied = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                satisfied += customers[i];
            }
        }
        for (int i = 0; i < (n - minutes) + 1; i++) {
            int grumpyTempCount = 0;
            for (int j = i; j <= (i + minutes) - 1; j++) {
                if (grumpy[j] == 1) {
                    grumpyTempCount += customers[j];
                }
            }
            unstatisfied = Math.max(grumpyTempCount, unstatisfied);
        }
        return satisfied + unstatisfied;
    }
}
