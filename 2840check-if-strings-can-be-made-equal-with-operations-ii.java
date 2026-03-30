import java.util.*;

class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        if(n != s2.length()) return false;

        String even = "";
        String odd = "";
        String even2 = "";
        String odd2 = "";

        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                even += s1.charAt(i);
                even2 += s2.charAt(i);
            } else {
                odd += s1.charAt(i);
                odd2 += s2.charAt(i);
            }
        }

        char[] e1 = even.toCharArray();
        char[] o1 = odd.toCharArray();
        char[] e2 = even2.toCharArray();
        char[] o2 = odd2.toCharArray();

        Arrays.sort(e1);
        Arrays.sort(o1);
        Arrays.sort(e2);
        Arrays.sort(o2);

        return Arrays.equals(e1, e2) && Arrays.equals(o1, o2);
    }
}