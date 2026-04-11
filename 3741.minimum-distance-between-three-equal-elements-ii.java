class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int ans = Integer.MAX_VALUE;

        for (List<Integer> v : map.values()) {
            if (v.size() >= 3) {
                for (int i = 0; i + 2 < v.size(); i++) {
                    int d = 2 * (v.get(i + 2) - v.get(i));
                    ans = Math.min(ans, d);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}