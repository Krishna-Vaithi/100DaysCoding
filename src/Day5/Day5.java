package Day5;

public class Day5 {

    public static void main(String[] args) {
        Day5 day5 = new Day5();
        System.out.println(day5.firstUniqChar("aabb"));
    }

    public int firstUniqChar(String s) {
        int arr[]=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            arr[ch-'a']++;
        }
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(arr[ch-'a']==1){
                return i;
            }
        }
        return -1;
    }
}
