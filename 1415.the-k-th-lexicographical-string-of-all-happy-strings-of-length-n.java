class Solution {
    public String getHappyString(int n, int k) {
        List<String> ls = new ArrayList<>();
        help(n,ls,"",' ');
        if(ls.size()<k) return "";
        return ls.get(k-1);
    }
    public void help(int n, List<String> ls, String curr, char prev){
        if(curr.length()==n){
            ls.add(curr);
            return;
        }
        if(prev!='a') help(n,ls,curr+"a",'a');
        if(prev!='b') help(n,ls,curr+"b",'b');
        if(prev!='c') help(n,ls,curr+"c",'c');
    }
}