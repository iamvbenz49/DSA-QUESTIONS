class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key,int val){
            this.key = key;
            this.val = val;
        }
            
    }
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    Map<Integer,Node> map = new HashMap<>();
    int size;
    public void addNode(Node newNode){
        Node temp = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = temp;
        temp.prev = newNode;
    }
    public void deleteNode(Node delNode){
        delNode.prev.next = delNode.next;
        delNode.next.prev = delNode.prev;
    }
    public LRUCache(int capacity) {
        size = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            deleteNode(curr);
            addNode(curr);
            return curr.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            deleteNode(map.get(key));
            map.remove(key);
        }
        if(size==map.size()){
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        Node newNode = new Node(key,value);
        addNode(newNode);
        map.put(key,newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
