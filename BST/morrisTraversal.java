class Node{
    public  int val;
    Node left;
    Node right;
    public Node(int val){
        this.val = val;
    }
}
public class morrisTraversal {
    public static void main(String[] args) {
        morrisTraversal morrisTraversal = new morrisTraversal();  // Create an instance
        Node root = new Node(6);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(5);
        morrisTraversal.morrisInorder(root);
    }
    public static void morrisInorder(Node root){
        if(root==null)
            return;
        Node curr = root;
        while(curr!=null){
            if(curr.left==null){
                System.out.println(curr.val+" ");
                curr = curr.right;
            }else{
                Node pre = curr.left;
                while(pre.right!=null && pre.right!=curr){
                    pre = pre.right;
                }
                if(pre.right==null){
                    pre.right = curr;
                    curr = curr.left;
                }else{
                    pre.right = null;
                    System.out.println(curr.val+" ");
                    curr = curr.right;
                }
            }
        }
    }
}
