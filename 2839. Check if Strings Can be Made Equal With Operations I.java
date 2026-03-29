class Solution {
    public boolean canBeEqual(String s1, String s2) {
        int[] odd=new int[26];
        int[] ev=new int[26];
        int x=0;
        for(char i:s1.toCharArray()){
            if(x%2==0){
                odd[i-'a']++;
            }else{
                ev[i-'a']++;
            }
            x++;
        } x=0;for(char i:s2.toCharArray()){
            if(x%2==0){
                odd[i-'a']--;
            }else{
                ev[i-'a']--;
            }
            x++;
        }
        for(int i:odd){
            if(i!=0)return false;
        }
        for(int i:ev){
            if(i!=0)return false;
        }


        return true;
    }
}