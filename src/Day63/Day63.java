package Day63;

public class Day63 {
    public static void main(String[] args) {
        Day63 day63 = new Day63();
        String[] details = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        System.out.println(day63.countSeniors(details));
    }
    public int countSeniors(String[] details) {
        int ans = 0;
        for (String st : details) {
            int x = st.charAt(11) - '0';
            if (x > 6) {
                ans++;
            } else if (x == 6) {
                if (st.charAt(12) - '0' > 0) ans++;
            }
        }
        return ans;
    }
}
