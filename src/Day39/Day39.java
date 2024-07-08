package Day39;

public class Day39 {
    public static void main(String[] args) {
        Day39 day39 = new Day39();
        System.out.println(day39.findTheWinner(5, 2));
    }
    public int findTheWinner(int n, int k) {
        int res = 0;
        for (int player_num = 2; player_num <= n; ++player_num) {
            res = (res + k) % player_num;
        }
        return res + 1;
    }
}
