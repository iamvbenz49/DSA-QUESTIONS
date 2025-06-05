class Solution {
    class UnionFind {
        private int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public int find(int x) {
            if(x == parent[x]) {
                return x;
            }
            parent[x] = find(parent[x]);
            return parent[x];
        }
        public void union(int u, int v) {
            int ulp_u = find(u);
            int ulp_v = find(v);

            if(ulp_u != ulp_v) {
                if(ulp_u < ulp_v) {
                    parent[ulp_v] = ulp_u;
                } else {
                    parent[ulp_u] = ulp_v;
                }
            }
        }
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind uf = new UnionFind(26);
        for(int i = 0; i < s1.length(); i++) {
            int u = s1.charAt(i) - 'a';
            int v = s2.charAt(i) - 'a';
            uf.union(u, v);
        }

        String res = "";

        for(int i = 0; i < baseStr.length(); i++) {
            res += (char)(uf.find(baseStr.charAt(i) - 'a') + 'a');
        }

        return res;
    }
}
