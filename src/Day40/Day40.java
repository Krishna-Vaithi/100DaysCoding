package Day40;

public class Day40 {
    public static void main(String[] args) {
        Day40 day40 = new Day40();
        int[][] customers = {{1, 2}, {2, 5}, {4, 3}};
        System.out.println(day40.averageWaitingTime(customers));
    }
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double time_waiting = customers[0][1];
        int finished_prev = customers[0][0] + customers[0][1];
        for (int customer_ind = 1; customer_ind < n; ++customer_ind) {
            int[] times = customers[customer_ind];
            int arrive = times[0];
            int start_cook = Math.max(arrive, finished_prev);
            int end_time = start_cook + times[1];
            finished_prev = end_time;
            time_waiting += end_time - arrive;
        }
        return time_waiting / n;
    }
}
