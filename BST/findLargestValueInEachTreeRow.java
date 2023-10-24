class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxList = new ArrayList<Integer>();
        if(root==null)
            return maxList;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                max = Math.max(max,node.val);
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            maxList.add(max);
        }
        return maxList;
    }
}
