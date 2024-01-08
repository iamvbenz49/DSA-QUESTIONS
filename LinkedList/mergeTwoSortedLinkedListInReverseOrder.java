class GfG
{
    Node mergeResult(Node node1, Node node2)
    {
        Node node = null;
        Node h1 = node1, h2 = node2;
	    while(node1!=null && node2!=null){
	        if(node1.data<node2.data){
	            Node temp = node1;
	            node1 = node1.next;
	            temp.next = node;
	            node = temp;
	        }else{
	            Node temp = node2;
	            node2 = node2.next;
	            temp.next = node;
	            node = temp;
	        }
	    }
	    while(node1!=null){
	        Node temp = node1;
	        node1 = node1.next;
	        temp.next = node;
            node = temp;
	    }
	    while(node2!=null){
	        Node temp = node2;
	        node2 = node2.next;
	        temp.next = node;
            node = temp;
	    }
	    return node;
    }
}
