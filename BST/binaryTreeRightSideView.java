class Solution {
    public List<Integer> rightSideView(TreeNode root) {
       List<Integer> list = new ArrayList<>();
        if(root==null)
            return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            int size = q.size();
            int val = -1;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                val = node.val;
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            list.add(val);
        }
        return list;
    }
}
