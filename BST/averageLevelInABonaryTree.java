class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if(root==null)
            return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            double sum = 0;
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            list.add(sum/size);
        }
        return list;
    }
}
