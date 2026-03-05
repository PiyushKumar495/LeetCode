class Solution {
    public int minOperations(String s) {
        char c = '0', d = '1';
        int count1 = 0, count2 = 0;

        for (char t : s.toCharArray()) {
            if (t != c) count1++;
            c ^= 1;

            if (t != d) count2++;
            d ^= 1;
        } 

        return (count1 < count2) ? count1 : count2;
    }
}