package Day84;

public class Day84 {
    public static void main(String[] args) {
        Day84 day84 = new Day84();
        System.out.println(day84.findComplement(5));
    }
    public int findComplement(int num) {
        String str = Integer.toBinaryString(num);
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                res += '1';
            } else {
                res += '0';
            }
        }
        return Integer.parseInt(res, 2);
    }
}
