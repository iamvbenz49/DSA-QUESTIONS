class Solution {
    int LevelX = 0;
    int LevelY = 0;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,x,y,0);
        System.out.print(LevelX+" "+LevelY);
        return LevelX!=-1 && LevelX==LevelY;
    }
    public void dfs(TreeNode root,int x,int y,int depth){
        if(root==null)
            return;        
        if(root.left!=null)
            dfs(root.left,x,y,depth+1);
        if(root.right!=null)
            dfs(root.right,x,y,depth+1);
        if(root.left!=null && root.right!=null && ((root.left.val==x && root.right.val==y)||(root.left.val==y && root.right.val==x))){
            LevelX = -1;
            return;
        }
        if(root.val==x)
            LevelX = depth;
        if(root.val==y)
            LevelY = depth;
    }
}
