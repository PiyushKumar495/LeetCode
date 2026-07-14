class Solution {
    long mod = (int) (1e9 + 7);
    private HashMap<Long, Long> map;
    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        map = new HashMap<>();
        return (int) dfs(0, 0, 0, nums);
    }
    private long dfs(long gcd1, long gcd2, int index, int[] arr) {
        if(index == arr.length) {
            if(gcd1 == gcd2 && gcd1 != 0) return 1;
            return 0;
        }
        if(map.containsKey(gcd1*1000000l + gcd2*1000l + index)) return map.get(gcd1*1000000l + gcd2*1000l + index);
        long res = 0;
        long next = (gcd1 == 0 ? arr[index] : gcd(gcd1, arr[index]));
        res += dfs(next, gcd2, index+1, arr);
        res %= mod;
        next = (gcd2 == 0 ? arr[index] : gcd(gcd2, arr[index]));
        res += dfs(gcd1, next, index+1, arr);
        res %= mod;
        res += dfs(gcd1, gcd2, index+1, arr);
        res %= mod;
        map.put(gcd1*1000000l + gcd2*1000l + index, res);
        return res;
    }
    private long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}