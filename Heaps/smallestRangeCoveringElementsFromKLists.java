class Solution {
    class Node {
        int index, row, val;
        public Node(int index, int row, int val) {
            this.index = index;
            this.row = row;
            this.val = val;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int start = -1, end = -1, range = (int)1e7, max = -(int)1e7;
        for(int i = 0; i < nums.size(); i++) {
            pq.add(new Node(0, i, nums.get(i).get(0)));
            max = Math.max(max, nums.get(i).get(0));
        }

        while(pq.size() == nums.size()) {
            Node node = pq.poll();

            if(max - node.val < range) {
                range = max - node.val;
                start = node.val;
                end = max;
            }
            if(node.index + 1 < nums.get(node.row).size()) {
                node.index++;
                node.val = nums.get(node.row).get(node.index);
                max = Math.max(max, node.val);
                pq.add(node);
            }
        }

        return new int[]{start, end};
    }
}