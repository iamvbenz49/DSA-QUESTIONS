class Solution {
    public int res = 0;
    public int widthOfBinaryTree(TreeNode root) {
        Map<Integer,Pair> map = new HashMap<>();
        dfs(root, 0, 0,map);
        for (Map.Entry<Integer,Pair> entry : map.entrySet())  
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue().start+" "+entry.getValue().end); 
        return res;
    }
    public void dfs(TreeNode root,int level, int pos,Map<Integer,Pair> map){
        if(root==null){
            return;
        }
        if(!map.containsKey(level)){
            map.put(level,new Pair(pos,pos));
            res = Math.max(res,1);
        }else{
            int start = Math.min(map.get(level).start,pos);
            int end = Math.max(map.get(level).end,pos);
            map.get(level).start = start;
            map.get(level).end = end;
            res = Math.max(res,Math.abs(end-start)+1);
        }
        dfs(root.left,level+1,2*pos,map);
        dfs(root.right,level+1,(2*pos)+1,map);
    }
}
