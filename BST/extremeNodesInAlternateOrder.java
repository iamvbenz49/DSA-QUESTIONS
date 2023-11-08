class Solution{
    public  ArrayList<Integer> ExtremeNode(Node root)
      {
        //add code here.
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        boolean check = false;
        q.add(root);
        while(!q.isEmpty()){
            ArrayList<Integer> subList = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++){
                Node currentNode = q.poll();
                subList.add(currentNode.data);
                if(currentNode.left!=null)
                    q.add(currentNode.left);
                if(currentNode.right!=null)
                    q.add(currentNode.right);
            }
            if(check){
                list.add(subList.get(0));
            }else{
                list.add(subList.get(subList.size()-1));
            }
            check = !check;
        }
        return list;
      }
}
