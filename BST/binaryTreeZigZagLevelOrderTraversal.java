class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> mainList = new ArrayList<>();
        if(root==null)
            return mainList;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = true;
        while(!q.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                subList.add(node.val);
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            if(!flag)
                Collections.reverse(subList);
            mainList.add(subList);
            flag = !flag;
        }
        return mainList;
    }
}
