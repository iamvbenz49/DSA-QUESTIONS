/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class posNode{
    TreeNode node;
    int row;
    int col;
    public posNode(TreeNode node,int row,int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue>> map = new TreeMap<>();
        Queue<posNode> q = new LinkedList<>();
        posNode firstElement = new posNode(root,0,0);
        q.add(firstElement);
        while(!q.isEmpty()){
            posNode currentNode = q.poll();
            int row = currentNode.row;
            int col = currentNode.col;
            TreeNode node = currentNode.node;
            if(!map.containsKey(row)){
                map.put(row,new TreeMap<>());
            }
            if(!map.get(row).containsKey(col)){
                map.get(row).put(col,new PriorityQueue<>());
            }
            map.get(row).get(col).offer(node.val);
            if(node.left!=null){
                q.add(new posNode(node.left,row-1,col+1));
            }
            if(node.right!=null){
                q.add(new posNode(node.right,row+1,col+1));
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue> keys:map.values()){
            List<Integer> subList = new ArrayList<>();
            for(PriorityQueue<Integer> pq:keys.values()){
                while(!pq.isEmpty()){
                    subList.add(pq.poll());
                }
            }
            list.add(subList);
        }
        return list;
    }
}
