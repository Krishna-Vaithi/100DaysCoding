package Day80;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Day80 {
    public static void main(String[] args) {
        Day80 day80 = new Day80();
        System.out.println(day80.nthUgleyNumber(1));
    }
    public int nthUgleyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(1L);
        int ct = 0;
        Set<Long> vis = new HashSet<>();
        vis.add(1L);

        while (ct < n) {
            long cur = pq.poll();
            ct++;
            if (ct == n) return (int) cur;
            if (!vis.contains(cur * 2)) {
                vis.add(cur * 2);
                pq.offer(cur * 2);
            }
            if (!vis.contains(cur * 3)) {
                vis.add(cur * 3);
                pq.offer(cur * 3);
            }
            if (!vis.contains(cur * 5)) {
                vis.add(cur * 5);
                pq.offer(cur * 5);
            }
        }
        return -1;
    }
}
