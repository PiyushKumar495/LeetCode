class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ans = letters[0];
        for (char ch : letters) {
            if (ch > target) {
                if (ch < ans || ans <= target) {
                    ans = ch;
                }
            }
        }
        return ans;
    }
}