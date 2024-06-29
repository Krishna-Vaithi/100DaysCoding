package Day30;

import java.util.*;

public class Day30 {
    public static void main(String[] args) {
        Day30 day30 = new Day30();
        int n = 8;
        int[][] edgeList  = {{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}};
        System.out.println(day30.getAncestors(n,edgeList));
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<TreeSet<Integer>> ancestorList = new ArrayList();
        List<List<Integer>> list = new ArrayList();
        Queue<Integer> queue = new LinkedList();
        int degree[] = new int[n];
        ArrayList<Integer>[] connections = new ArrayList[n];
        for(int i = 0;i<n;i++){
            connections[i] = new ArrayList<Integer>();
            ancestorList.add(new TreeSet<Integer>());
        }
        for(int edge[]: edges){
            connections[edge[0]].add(edge[1]);
            degree[edge[1]]++;
        }
        for(int i = 0;i<n;i++){
            if(degree[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int currNode = queue.poll();
            for(int node : connections[currNode]){
                ancestorList.get(node).addAll(new TreeSet(ancestorList.get(currNode)));
                ancestorList.get(node).add(currNode);
                degree[node]--;
                if(degree[node] == 0){
                    queue.add(node);
                }
            }
        }
        for(TreeSet<Integer> set : ancestorList){
            list.add(new ArrayList<Integer>(set));
        }
        return list;
    }
}
