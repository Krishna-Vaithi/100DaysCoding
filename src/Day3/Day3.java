package Day3;

public class Day3 {
    public static void main(String[] args) {
        char[] s=new char[]{'H','e','l','l','o'};
        reverseString(s);
        System.out.println(s);
    }

    public static void reverseString(char[] s) {
        int l = s.length;
        for (int i = 0; i < l / 2; i++) {
            char temp = s[i];
            s[i] = s[l - i - 1];
            s[l - i - 1] = temp;
        }
    }
}