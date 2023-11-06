import java.util.ArrayList;


class Node  { 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class boundaryTraversalOfBinaryTree
{
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        ArrayList <Integer> list = new ArrayList<>();
	    if (root.left == null && root.right == null) {
	        list.add(root.data);
	        return;
	    }
	    list.add(root.data);
	    leftTraverse(root.left,list);
	    leafTraverse(root,list);
	    rightTraverse(root.right,list); 
        System.out.println(list); 
    }
	static void leftTraverse(Node root, ArrayList <Integer> list){
	    if(root==null||(root.left==null&&root.right==null)){
	        return;
	    }
	    list.add(root.data);
	    if(root.left!=null)
	        leftTraverse(root.left,list);
	    else if (root.right != null)
	        leftTraverse(root.right,list);
	}
	static void rightTraverse(Node root, ArrayList <Integer> list){
	    if(root==null||(root.left==null&&root.right==null)){
	        return;
	    }
	    if(root.right!=null)
	        rightTraverse(root.right,list);
	    else if(root.left != null) 
	        rightTraverse(root.left,list);
	    list.add(root.data);
	}
	static void leafTraverse(Node root,ArrayList<Integer> list){
	    if (root == null) return;
	     if(root.left==null && root.right==null){
	        list.add(root.data);
	        return;
	    }
	    leafTraverse(root.left,list);
	    leafTraverse(root.right,list);
	    
	}
}
