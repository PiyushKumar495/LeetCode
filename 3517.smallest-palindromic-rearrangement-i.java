class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        char[] half = new char[n/2];
        for(int i = 0; i < half.length; i++) {
            half[i] = s.charAt(i);
        }
        Arrays.sort(half);
        String halfStr = new String(half);
        StringBuilder sb = new StringBuilder();
        sb.append(halfStr);
        if(n % 2 == 1) sb.append(s.charAt(n/2));
        for(int i = n/2 - 1; i >= 0; i--) {
            sb.append(half[i]);
        }
        return sb.toString();
    }
}