package Day6;
import java.util.*;

public class Day6 {

    public static void main(String[] args) {
        Day6 day6 = new Day6();
        System.out.println(day6.commonChars(new String[]{"bella","label","roller"}));
        System.out.println(day6.commonChars(new String[]{"cool","lock","cook"}));
    }

    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        if (words.length == 0) return result;

        int[] minFreq = new int[26];
        for (int i = 0; i < 26; i++) {
            minFreq[i] = Integer.MAX_VALUE;
        }

        for (String word : words) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                result.add(Character.toString((char) (i + 'a')));
                minFreq[i]--;
            }
        }
        return result;
    }
}
