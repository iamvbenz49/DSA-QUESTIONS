class Root{
    Node node;
    int col;
    public Root(Node node,int col){
        this.node = node;
        this.col = col;
    } 
}
class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<Root> q = new LinkedList<>();
        q.add(new Root(root,0));
        while(!q.isEmpty()){
            Root currentNode = q.poll();
            Node node = currentNode.node;
            int col = currentNode.col;
            map.put(col,node.data);
            if(node.left!=null){
                q.add(new Root(node.left,col-1));
            }
            if(node.right!=null){
                q.add(new Root(node.right,col+1));
            }
        }
        for(Integer x:map.values()){
            list.add(x);
        }
        return list;
    }
}
