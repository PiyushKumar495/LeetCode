class Solution {
    public int concatenatedBinary(int n) {
        long sum = 0;
        for(int i = 1; i <= n; i++) {
            String binary = Integer.toBinaryString(i);
            int len = binary.length();
            sum = sum << len;
            sum += i;
            sum %= 1000000007;
        }
        return (int)sum;
    }
}