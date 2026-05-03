class Solution {
    public boolean rotateString(String s, String goal) {
          if (s.length() != goal.length()) {
            return false;
        }
        s += s;
        for (int i = 0; i < goal.length(); i++) {
            if (goal.equals(s.substring(i,i + goal.length()))) {
                return true;
            }
        }
        return false;
    }
}