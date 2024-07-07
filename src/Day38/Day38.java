package Day38;

public class Day38 {
    public static void main(String[] args) {
        Day38 solution = new Day38();
        System.out.println(solution.numWaterBottles(9, 3)); // 13
    }
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalBottles = numBottles;
        while (numBottles >= numExchange) {
            totalBottles += numBottles / numExchange;
            numBottles = (numBottles / numExchange) + (numBottles % numExchange);
        }
        return totalBottles;
    }
}
