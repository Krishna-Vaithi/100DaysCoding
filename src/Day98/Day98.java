package Day98;

public class Day98 {
    public static void main(String[] args) {
        Day98 day98 = new Day98();
        int[] rolls = {3,2,4,3};
        int mean = 4;
        int n = 2;
        int[] res = day98.missingRolls(rolls, mean, n);
        for (int num: res) {
            System.out.print(num + " ");
        }
    }
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int num: rolls) sum += num;
        int x = (mean * (rolls.length + n)) - sum;

        int rollsLeft = n;
        int[] res = new int[n];

        int i = 0;
        while (rollsLeft > 0) {
            int currRoll = Math.min(6, x / rollsLeft--);
            currRoll = Math.max(1, currRoll);
            res[i++] = currRoll;
            x -= currRoll;
        }

        return (x == 0) ? res : new int[]{};
    }
}
