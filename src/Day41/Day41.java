package Day41;

public class Day41 {
    public static void main(String[] args) {
        Day41 day41 = new Day41();
        String[] logs = {"d1/","d2/","../","d21/","./"};
        System.out.println(day41.minOperations(logs));
    }
    public int minOperations(String[] logs) {
        int step = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                if (step > 0){
                    step--;
                }
            }
            else if (!log.equals("./")) {
                step++;
            }
        }
        return step;
    }
}
