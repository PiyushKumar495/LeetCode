class Solution {
    public int longestBalanced(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int longestLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] counts = new int[26];
            char c1 = s.charAt(i);
            counts[c1 - 'a']++;
            for (int j = i + 1; j < s.length(); j++) {
                char c2 = s.charAt(j);
                counts[c2 - 'a']++;
                if (checkIfBalanced(counts)) {
                    longestLen = Math.max(longestLen, j - i + 1);
                }
            }
            counts[c1 - 'a']--;
        }
        return longestLen;
    }
    public boolean checkIfBalanced(int[] counts) {
        int balancedCount = -1;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) {
                continue;
            } else {
                if (balancedCount == -1) {
                    balancedCount = counts[i];
                } else {
                    if (balancedCount == counts[i]) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
     }
}