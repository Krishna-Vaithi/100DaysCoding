package Day96;

public class Day96 {
    public static void main(String[] args) {
        Day96 day96 = new Day96();
        String s = "iiii";
        int k = 1;
        System.out.println(day96.getLucky(s, k));
    }
    public int getLucky(String s, int k) {
        int sum=0;
        String s2=s;
        int n=s2.length();
        int j=0;
        String s3="";
        while(n-->0){
            char x=s2.charAt(j++);
            int y=(int)x-'a'+1;
            s3=s3+y;
        }
        for(int i=0;i<k;i++){
            sum=0;
            n=s3.length();
            j=0;
            while(n-->0){
                char x=s3.charAt(j++);
                int y=(int)x-'0';
                sum+=y;
            }
            s3=""+sum;
        }
        return sum;
    }
}
