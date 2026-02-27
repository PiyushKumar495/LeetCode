import java.util.*;
class Solution {
    public int minOperations(String s, int k) {
         int n=s.length();
        int z=0;
    for(char c:s.toCharArray()) if(c=='0')++z;
          if(z==0) return 0;

        int[] d=new int[n+1];
         Arrays.fill(d,-1);
     Deque<Integer>q=new ArrayDeque<>();   d[z]=0;
        q.add(z);       TreeSet<Integer>[] u=new TreeSet[2];
        u[0]=new TreeSet<>();
          u[1]=new TreeSet<>();
           for(int i=0;i<=n;++i) {
     if(i==z) continue;
            u[i%2].add(i);
        }

      while(!q.isEmpty()) {
            int c=q.poll();
             int p=(c+k)%2;
    int hi=Math.min(k,c);
            int lo=Math.max(0,k-(n-c));
        int l=c+k-2*hi;
              int r=c+k-2*lo;

            NavigableSet<Integer> set=u[p].subSet(l,true,r,true);
             
            List<Integer>rem=new ArrayList<>(set);
    for(int v:rem) {
              u[p].remove(v);
                  d[v]=d[c]+1;
        if(v==0) return d[v];
                   q.add(v);
            }        }
        return -1;
    }}