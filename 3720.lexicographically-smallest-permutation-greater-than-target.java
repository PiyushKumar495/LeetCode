class Solution {
    public boolean dfs(int ind, String target, StringBuilder temp, int[] freq, StringBuilder ansHolder) {
        int n = target.length();
        if (ind == n) return false;

        int minChar = target.charAt(ind) - 'a';
        for (int ch = minChar; ch < 26; ch++) {
            if (freq[ch] == 0) continue;

            if (ch == minChar) {
                freq[ch]--;
                temp.append((char) ('a' + ch));
                if (dfs(ind + 1, target, temp, freq, ansHolder)) return true;
                temp.deleteCharAt(temp.length() - 1);
                freq[ch]++;
            } else {
                freq[ch]--;
                temp.append((char) ('a' + ch));

                StringBuilder can = new StringBuilder(temp);
                int[] tempCnt = freq.clone();

                for (int c = 0; c < 26; c++) {
                    while (tempCnt[c] > 0) {
                        can.append((char) ('a' + c));
                        tempCnt[c]--;
                    }
                }

                ansHolder.setLength(0);
                ansHolder.append(can);

                temp.deleteCharAt(temp.length() - 1);
                freq[ch]++;
                return true;
            }
        }
        return false;
    }

    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder temp = new StringBuilder();
        StringBuilder ansHolder = new StringBuilder();

        if (dfs(0, target, temp, freq, ansHolder)) {
            return ansHolder.toString();
        }
        return "";
    }
}