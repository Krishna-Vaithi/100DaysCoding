package Day43;

import java.util.Stack;

public class Day43 {
    public static void main(String[] args) {
        Day43 day43 = new Day43();
        String s = "cdbcbbaaabab";
        int x = 4;
        int y = 5;
        System.out.println(day43.maximumGain(s, x, y));
    }
    public int maximumGain(String s, int x, int y) {
        int totalScore = 0;
        String highPriorityPair = x > y ? "ab" : "ba";
        String lowPriorityPair = highPriorityPair.equals("ab") ? "ba" : "ab";

        String stringAfterFirstPass = removeSubstring(s, highPriorityPair);
        int removedPairsCount =
                (s.length() - stringAfterFirstPass.length()) / 2;

        totalScore += removedPairsCount * Math.max(x, y);

        String stringAfterSecondPass = removeSubstring(
                stringAfterFirstPass,
                lowPriorityPair
        );
        removedPairsCount = (stringAfterFirstPass.length() -
                stringAfterSecondPass.length()) /
                2;

        totalScore += removedPairsCount * Math.min(x, y);

        return totalScore;
    }

    private String removeSubstring(String input, String targetPair) {
        Stack<Character> charStack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (
                    currentChar == targetPair.charAt(1) &&
                            !charStack.isEmpty() &&
                            charStack.peek() == targetPair.charAt(0)
            ) {
                charStack.pop();
            } else {
                charStack.push(currentChar);
            }
        }

        StringBuilder remainingChars = new StringBuilder();
        while (!charStack.isEmpty()) {
            remainingChars.append(charStack.pop());
        }
        return remainingChars.reverse().toString();
    }
}
