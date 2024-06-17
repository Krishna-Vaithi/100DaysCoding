package Day18;

public class Day18 {
    public static void main(String[] args) {
        Day18 solution = new Day18();
        System.out.println(solution.judgeSquareSum(5));
    }

    public boolean judgeSquareSum(int c) {
        long left = 0, right = (long) Math.sqrt(c);
        while (left <= right) {
            if (left * left + right * right == c){
                return true;
            }
            else if(left * left + right * right > c){
                right--;
            }
            else{
                left++;
            }
        }
        return false;
    }
}
