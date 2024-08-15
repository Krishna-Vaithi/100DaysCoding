package Day77;

public class Day77 {
    public static void main(String[] args) {
        Day77 day77 = new Day77();
        int[] bills = {5, 5, 5, 10, 20};
        System.out.println(day77.lemonadeChange(bills));
    }
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5)
                five++;
            else if (bill == 10) {
                five--;
                ten++;
            } else if (ten > 0) {
                five--;
                ten--;
            } else
                five -= 3;
            if (five < 0)
                return false;
        }
        return true;
    }
}
