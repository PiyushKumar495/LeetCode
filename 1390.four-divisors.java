/*
 * @lc app=leetcode id=1390 lang=java
 *
 * [1390] Four Divisors
 */

// @lc code=start
class Solution {
    public int sumFourDivisors(int[] nums) {
         int finalSum = 0;
        for(int n : nums) {
            
            int divisorsCount = 0;
            int sum = 0;
            for(int i=1; i*i<=n; i++) {
                if(n%i == 0) {
                    divisorsCount++;
                    sum += i;
                    
                    if(i != n/i) {
                        divisorsCount++;
                        sum += (n/i);
                    }
                }
            }

            if (divisorsCount == 4) {
                finalSum += sum;
            }
        }
        return finalSum;
    }
}
// @lc code=end

