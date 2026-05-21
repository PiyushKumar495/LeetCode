class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        
        HashSet<Integer> st = new HashSet<>();    
        for(int x : arr2){
            while(x > 0){
                st.add(x);
                x /= 10;
            }
        }

        int ans = 0;
        for(int x : arr1){

            int n = (int)(Math.log10(x)) + 1;

            while(x > 0){

                if(st.contains(x)){
                    ans = Math.max(ans, n);
                    break;
                }

                x /= 10;
                n--;
            }
        }

        return ans;
    }
}