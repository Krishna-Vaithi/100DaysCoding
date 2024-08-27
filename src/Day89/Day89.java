package Day89;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class Day89 {
    public static void main(String[] args) {
        Day89 day89 = new Day89();
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = {0.5, 0.5, 0.2};
        int start_node = 0;
        int end_node = 2;
        System.out.println(day89.maxProbability(n, edges, succProb, start_node, end_node));
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair<Integer, Double>>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            map.get(edges[i][0]).add(new Pair<>(edges[i][1], succProb[i]));
            map.get(edges[i][1]).add(new Pair<>(edges[i][0], succProb[i]));
        }
        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>((a, b) -> {
            return b.getKey() > a.getKey() ? 1 : 0;
        });
        double[] maxProb = new double[n];
        pq.offer(new Pair<>(1.0, start_node));
        while (!pq.isEmpty()) {
            int node = pq.peek().getValue();
            double prob = pq.peek().getKey();
            pq.poll();
            if (maxProb[node] >= prob) {
                continue;
            }
            maxProb[node] = prob;
            for (int i = 0; i < map.get(node).size(); i++) {
                pq.offer(new Pair<>(map.get(node).get(i).getValue() * prob,
                        map.get(node).get(i).getKey()));
            }
        }
        return maxProb[end_node];
    }
}
