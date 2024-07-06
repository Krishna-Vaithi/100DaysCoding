package Day37;

public class Day37 {
    public static void main(String[] args) {
        Day37 day37 = new Day37();
        System.out.println(day37.passThePillow(5, 5));
    }
    public int passThePillow(int n, int time) {
        int completed = time / (n-1);
        int remaining = time % (n-1);
        int ans = 0;
        if (completed % 2 != 0) {
            ans = n - remaining;
        } else {
            ans = remaining + 1;
        }
        return ans;
    }
}
