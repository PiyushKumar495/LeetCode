class Solution {
    static final long MOD = 1_000_000_007L;
    
    static long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0] - 1].add(e[1] - 1);
            adj[e[1] - 1].add(e[0] - 1);
        }
        List<int[]>[] queriesAdj = new List[n];
        for (int i = 0; i < n; i++) {
            queriesAdj[i] = new ArrayList<>();
        }
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            queriesAdj[q[0] - 1].add(new int[] {q[1] - 1, i});
            queriesAdj[q[1] - 1].add(new int[] {q[0] - 1, i});
        }
        UnionFind uf = new UnionFind(n);
        int[] ancestor = new int[n];
        for (int i = 0; i < n; i++) {
            ancestor[i] = i;
        }
        int[] dist = new int[n];
        boolean[] seen = new boolean[n];
        int[] res = new int[queries.length];
        dfs(adj, uf, ancestor, queriesAdj, dist, res, seen, 0);
        for (int i = 0; i < res.length; i++) {
            if (queries[i][0] == queries[i][1]) {
                res[i] = 0;
                continue;
            }
            res[i] = (int) modPow(2L, res[i] - 1);
        }
        return res;
    }

    static void dfs(List<Integer>[] adj, UnionFind uf, int[] ancestor, List<int[]>[] queries, int[] dist, int[] res, boolean[] seen, int u) {
        seen[u] = true;
        for (int[] q : queries[u]) {
            res[q[1]] += dist[u];
            if (seen[q[0]]) {
                res[q[1]] -= 2 * dist[ancestor[uf.find(q[0])]];
            }
        }
        for (int v : adj[u]) {
            if (seen[v]) {
                continue;
            }
            dist[v] = dist[u] + 1;
            dfs(adj, uf, ancestor, queries, dist, res, seen, v);
            ancestor[uf.combine(u, v)] = u;
        }
    }
}

class UnionFind {
    int[] representative;

    UnionFind(int n) {
        representative = new int[n];
        for (int i = 0; i < n; i++) {
            representative[i] = i;
        }
    }

    int find(int u) {
        if (u == representative[u]) {
            return u;
        } else {
            return representative[u] = find(representative[u]);
        }
    }

    int combine(int u, int v) {
        u = find(u);
        v = find(v);

        if (u == v) {
            return u;
        } else {
            return representative[u] = v;
        }
    }
}