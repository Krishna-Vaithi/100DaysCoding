package Day92;

import java.util.*;
import javafx.util.Pair;

public class Day92 {
    public static void main(String[] args) {
        Day92 day92 = new Day92();
        int n = 5, source = 0, destination = 4, target = 3;
        int[][] edges = new int[][]{{0, 1, 2}, {1, 2, 3}, {2, 3, 4}, {3, 4, 5}, {0, 4, 6}};
        int[][] res = day92.modifiedGraphEdges(n, edges, source, destination, target);
        for (int[] edge : res) {
            System.out.println(edge[0] + " " + edge[1] + " " + edge[2]);
        }
    }
    private static int INF = (int) 2e9;

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        Map<Integer, List<Pair<Integer, Integer>>> nodeNeighMp = new HashMap<>();

        for (var edge : edges) {
            int firstNode = edge[0], secondNode = edge[1], edgWt = edge[2];
            if (edgWt == -1) continue;
            nodeNeighMp.putIfAbsent(firstNode, new ArrayList<>());
            nodeNeighMp.putIfAbsent(secondNode, new ArrayList<>());
            nodeNeighMp.get(firstNode).add(new Pair<>(secondNode, edgWt));
            nodeNeighMp.get(secondNode).add(new Pair<>(firstNode, edgWt));
        }

        int srcDestDist = findShortestDist(n, source, destination, nodeNeighMp);

        if (srcDestDist < target) {
            return new int[][]{};
        }

        boolean distEqToTrgt = srcDestDist == target;

        for (int indx = 0; indx < edges.length; indx++) {
            var edge = edges[indx];
            int firstNode = edge[0], secondNode = edge[1], edgWt = edge[2];
            if (edgWt != -1) continue;

            edgWt = distEqToTrgt ? INF : 1;
            nodeNeighMp.putIfAbsent(firstNode, new ArrayList<>());
            nodeNeighMp.putIfAbsent(secondNode, new ArrayList<>());
            nodeNeighMp.get(firstNode).add(new Pair<>(secondNode, edgWt));
            nodeNeighMp.get(secondNode).add(new Pair<>(firstNode, edgWt));

            if (!distEqToTrgt) {
                srcDestDist = findShortestDist(n, source, destination, nodeNeighMp);
                if (srcDestDist <= target) {
                    edgWt += (target - srcDestDist);
                    distEqToTrgt = true;
                }
            }

            edge[2] = edgWt;
        }

        return distEqToTrgt ? edges : new int[][]{};
    }

    private int findShortestDist(int n, int startNode, int endNode, Map<Integer, List<Pair<Integer, Integer>>> nodeNeighMp) {
        PriorityQueue<Pair<Integer, Integer>> minDisFrmSrcHeap = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        int distFrmSrc[] = new int[n];
        Arrays.fill(distFrmSrc, INF);
        distFrmSrc[startNode] = 0;
        minDisFrmSrcHeap.offer(new Pair<>(distFrmSrc[startNode], startNode));

        while (!minDisFrmSrcHeap.isEmpty()) {
            var nodePr = minDisFrmSrcHeap.poll();
            int nodeVal = nodePr.getValue(), nodeDisFrmSrc = nodePr.getKey();
            if (!nodeNeighMp.containsKey(nodeVal)) continue;
            for (var neighPr : nodeNeighMp.get(nodeVal)) {
                int neighVal = neighPr.getKey(), neighNodeDist = neighPr.getValue();
                if (neighNodeDist + nodeDisFrmSrc < distFrmSrc[neighVal]) {
                    distFrmSrc[neighVal] = neighNodeDist + nodeDisFrmSrc;
                    minDisFrmSrcHeap.offer(new Pair<>(distFrmSrc[neighVal], neighVal));
                }
            }
        }

        return distFrmSrc[endNode];
    }
}
