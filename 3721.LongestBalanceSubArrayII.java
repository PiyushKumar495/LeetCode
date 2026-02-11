import java.util.*;

class Solution {
    static class Seg {
        int n;
        int[] mn, mx, lz;
        Seg(int n){
            this.n=n;
            mn=new int[4*n]; mx=new int[4*n]; lz=new int[4*n];
        }
        void add(int L,int R,int v){ if(L<=R) add(1,0,n-1,L,R,v); }
        void add(int i,int l,int r,int L,int R,int v){
            if(r<L||R<l) return;
            if(L<=l && r<=R){ mn[i]+=v; mx[i]+=v; lz[i]+=v; return; }
            push(i);
            int m=(l+r)>>>1;
            add(i<<1,l,m,L,R,v); add(i<<1|1,m+1,r,L,R,v);
            mn[i]=Math.min(mn[i<<1],mn[i<<1|1]);
            mx[i]=Math.max(mx[i<<1],mx[i<<1|1]);
        }
        void push(int i){
            int v=lz[i];
            if(v!=0){
                int a=i<<1,b=i<<1|1;
                mn[a]+=v; mx[a]+=v; lz[a]+=v;
                mn[b]+=v; mx[b]+=v; lz[b]+=v;
                lz[i]=0;
            }
        }
        int leftmostZero(int L,int R){ return find(1,0,n-1,L,R); }
        int find(int i,int l,int r,int L,int R){
            if(r<L||R<l || mn[i]>0 || mx[i]<0) return -1;
            if(l==r) return l;
            push(i);
            int m=(l+r)>>>1;
            int res=find(i<<1,l,m,L,R);
            return res!=-1?res:find(i<<1|1,m+1,r,L,R);
        }
    }
    public int longestBalanced(int[] nums) {
        int n=nums.length, ans=0;
        Seg st=new Seg(n);
        int[] last=new int[100001];
        Arrays.fill(last,-1);

        for(int r=0;r<n;r++){
            int x=nums[r], p=last[x];
            st.add(p+1, r, (x&1)==0 ? 1 : -1);
            last[x]=r;

            if(st.mn[1]<=0 && st.mx[1]>=0){
                int l=st.leftmostZero(0,r);
                if(l!=-1) ans=Math.max(ans, r-l+1);
            }
        }
        return ans;
    }
}