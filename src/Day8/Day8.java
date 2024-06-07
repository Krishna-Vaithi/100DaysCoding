package Day8;
import java.util.*;

public class Day8 {
    public static void main(String[] args) {
        Day8 day8 = new Day8();
        System.out.println(day8.replaceWords(List.of("cat", "bat", "rat"), "the cattle was rattled by the battery"));
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> s = new HashSet<>(dictionary);
        List<String> temp = new ArrayList<>(Arrays.asList(sentence.split(" ")));
        StringBuilder res = new StringBuilder();
        for (String t : temp) {
            int i = 0;
            while (i <= t.length()) {
                String curr = t.substring(0, i);
                if (s.contains(curr)) {
                    res.append(curr).append(" ");
                    break;
                }
                i++;
            }
            if (i == t.length() + 1) {
                res.append(t).append(" ");
            }
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}