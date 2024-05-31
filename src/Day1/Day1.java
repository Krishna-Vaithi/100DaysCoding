package Day1;

public class Day1 {
    public static void main(String[] args) {
        System.out.println(countSymmetricIntegers(10,1200));
    }

    public static int countSymmetricIntegers(int low, int high) {
        int Count=0;
        for(int i=low;i<=high;i++){
            int digit=0;
            int temp=i;
            while(temp>0){
                temp/=10;
                digit++;
            }
            if(digit%2==0){
                int sum1=0;
                int sum2=0;
                temp=i;
                for(int j=0;j<digit;j++){
                    if(j<digit/2){
                        sum1 += temp%10;
                        temp/=10;
                    }
                    else{
                        sum2 += temp%10;
                        temp/=10;
                    }
                }
                if(sum1==sum2){
                    Count++;
                }
            }
        }
        return Count;
    }
}