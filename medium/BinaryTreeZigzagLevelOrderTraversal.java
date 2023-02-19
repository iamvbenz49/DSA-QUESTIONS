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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root==null)return list;
        q.add(root);
        int k = 0;
        while(!q.isEmpty()){
            List<Integer> subList = new ArrayList<Integer>();
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null)q.offer(curr.left);
                if(curr.right!=null)q.offer(curr.right);
                subList.add(curr.val);
            }
            k++;
            System.out.println(subList+" "+k);
             if(k%2==0)
                Collections.reverse(subList);
            list.add(subList);
        }
        return list;
    }
}
