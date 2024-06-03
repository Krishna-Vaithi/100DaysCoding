package Day4;

public class Day4 {

    public static void main(String[] args) {
        scoreOfString("Hello");
    }

    public static int scoreOfString(String s) {
        int len = s.length() - 1;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return sum;
    }
}