package Day74;

import java.util.PriorityQueue;

public class Day74 {
    public static void main(String[] args) {
        Day74 day74 = new Day74();
        KthLargest kth = new KthLargest(3, new int[]{4,5,8,2});
        System.out.print(kth.add(3)); // return 4
        System.out.print(kth.add(5)); // return 5
        System.out.print(kth.add(10)); // return 5
        System.out.print(kth.add(9)); // return 8
        System.out.print(kth.add(4)); // return 8
    }
    static class KthLargest {
        private int k;
        private PriorityQueue<Integer> pq;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>(k);
            for (int num : nums) {
                pq.offer(num);
                if (pq.size() > k) pq.poll();
            }
        }

        public int add(int val) {
            pq.offer(val);
            if (pq.size() > k) pq.poll();
            System.out.print(" ");
            return pq.peek();
        }
    }
}
