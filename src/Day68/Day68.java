package Day68;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Day68 {
    public static void main(String[] args) {
        Day68 day68 = new Day68();
        System.out.println(day68.minimumPushes("abc"));
    }
    public int minimumPushes(String word) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Integer> frequencyQueue = new PriorityQueue<>(
                (a, b) -> b - a
        );
        frequencyQueue.addAll(frequencyMap.values());
        int totalPushes = 0;
        int index = 0;
        while (!frequencyQueue.isEmpty()) {
            totalPushes += (index / 8 + 1) * frequencyQueue.poll();
            index++;
        }
        return totalPushes;
    }
}
