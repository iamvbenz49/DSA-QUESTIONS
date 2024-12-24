class Solution {
    class Node {
        private int val, dist;
        public Node(int val, int dist) {
            this.val = val;
            this.dist = dist;
        }
    }
    Node node;
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        // for maximising, we should connect the two extreme nodes
        // for minimising, we should consider the middle nodes

        List<List<Integer>> tree1 = makeGraph(edges1), tree2 = makeGraph(edges2);
        node = new Node(-1, -1);
        diameter(tree1, 0, -1, 0);
        // System.out.println(node1.val+" "+node1.dist);
        diameter(tree1, node.val, -1, 0);
        int diameter1 = node.dist;

        node = new Node(-1, -1);
        diameter(tree2, 0, -1, 0);
        diameter(tree2, node.val, -1, 0);
        int diameter2 = node.dist;

        return Math.max(
            Math.max(diameter1, diameter2),
            ((diameter1 + 1)/2) + ((diameter2 + 1)/2) + 1
        );
    }
    public void diameter(List<List<Integer>> adj, int start, int parent, int dist) {
        if(node.dist < dist) {
            node = new Node(start, dist);
            System.out.println(node.val+" "+node.dist);
        }
        System.out.println(start);
        for(int vertex: adj.get(start)) {
            if(parent != vertex) {
                diameter(adj, vertex, start, dist + 1);
            }
        }
    }
    public List<List<Integer>> makeGraph(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) 
            adj.add(new ArrayList<>());

        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    } 
}