package Day32;

public class Day32 {
    public static void main(String[] args) {
        Day32 obj = new Day32();
        int[] arr = {2,6,4,1};
        System.out.println(obj.threeConsecutiveOdds(arr));
        int [] arr1 = {1,2,34,3,4,5,7,23,12};
        System.out.println(obj.threeConsecutiveOdds(arr1));
    }
    public boolean threeConsecutiveOdds(int[] arr) {
        int a=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2!=0){
                a++;
            }
            else{
                a=0;
            }
            if(a==3){
                return true;
            }
        }
        return false;
    }
}
