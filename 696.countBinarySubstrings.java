class Solution {
    public int countBinarySubstrings(String s) {
        int max=0;
        char prev=s.charAt(0);
        int a=0,b=0;
        for(int i=0;i<s.length();){
            if(s.charAt(i)==prev){
                a++;
            }
            else{
                max+=Math.min(a,b);
                prev=s.charAt(i);
                b=a;
                a=1;
            }
            i++;
        }
                max+=Math.min(a,b);
        return max;
    }
}