class Solution {
    public int minInsertions(String s) {
        Deque<Character> st = new ArrayDeque<>();
        int ans = 0;
        int i = 0;
        int n = s.length();

        while (i < n) {
            if (s.charAt(i) == '(') {
                st.push('(');
                i++;
            } else {
                // Ensure every closing pair contains two ')'.
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i += 2;
                } else {
                    ans++;
                    i++;
                }

                // Match the closing pair with an opening parenthesis.
                if (!st.isEmpty()) {
                    st.pop();
                } else {
                    ans++; // Insert a missing '('.
                }
            }
        }

        // Each unmatched '(' needs two closing parentheses.
        ans += 2 * st.size();

        return ans;
    }
}