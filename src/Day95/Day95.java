package Day95;

public class Day95 {
    public static void main(String[] args) {
        Day95 day95 = new Day95();
        int[] chalk = {3,4,1,2};
        int k = 25;
        System.out.println(day95.chalkReplacer(chalk, k));
    }
    public int chalkReplacer(int[] chalk, int k) {
        int i =0;
        while(chalk[i]<=k){
            k = k-chalk[i];
            i++;
            if(i>chalk.length-1){
                i=0;
            }
        }
        return i;

    }
}
