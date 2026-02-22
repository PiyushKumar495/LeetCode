class Solution {
    public int binaryGap(int n) {
        String s = Integer.toBinaryString(n);
        int index = s.indexOf('1'), max = 0, temp = 0;
        for (int i = index + 1; i < s.length(); i++)
            if (s.charAt(i) == '0')
                temp++;
            else {
                max = Math.max(max, temp + 1);
                temp = 0;
            }
        return max;
    }
}