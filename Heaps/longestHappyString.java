class Solution {
    class Node {
        char val;
        int count;
        public Node(char val, int count) {
            this.val = val;
            this.count = count;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> y.count - x.count);
        pq.add(new Node('a', a));
        pq.add(new Node('b', b));
        pq.add(new Node('c', c));
        String res = "";
        Node prevNode = null;
        while(pq.size() > 0) {
            Node node = pq.poll();
            if(node == prevNode) {
                break;
            }
            prevNode = node;
            int count = 2;
            while(count > 0 && node.count > 0) {
                res += node.val;
                count--;
                node.count--;
            }
            if(!pq.isEmpty()) {
                Node secondNode = pq.poll();
                if(secondNode.count > 0) {
                    res += secondNode.val;
                    secondNode.count--;
                    prevNode = secondNode;
                }
                if(secondNode.count > 0 && secondNode.count >= node.count) {
                    res += secondNode.val;
                    secondNode.count--;
                }
                if(secondNode.count > 0)
                    pq.add(secondNode);
            }
            if(node.count > 0)
                pq.add(node);
        }
        return res;
    }
}