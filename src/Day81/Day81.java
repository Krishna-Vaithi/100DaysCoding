package Day81;

public class Day81 {
    public static void main(String[] args) {
        Day81 solution = new Day81();
        int n = 3;
        System.out.println(solution.minSteps(n));
    }
    public int minSteps(int n) {
        if (n == 1) return 0;
        int steps = 0;
        int factor = 2;
        while (n > 1) {
            while (n % factor == 0) {
                steps += factor;
                n /= factor;
            }
            factor++;
        }
        return steps;
    }
}
