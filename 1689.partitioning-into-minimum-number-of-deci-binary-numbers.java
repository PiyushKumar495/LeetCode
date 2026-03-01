class Solution {
    public int minPartitions(String n) {
        int max = 0;

        for (int i = 0; i < n.length(); i++) {
            int curr = Integer.parseInt(n.substring(i, i + 1));
            max = Math.max(max, curr);

        }

        return max;
    }
}