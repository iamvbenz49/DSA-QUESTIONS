class MyCircularDeque {
    private int start, end, size, k;
    private int[] deque;
    public MyCircularDeque(int k) {
        this.start = -1;
        this.end = -1;
        this.deque = new int[k];
        this.k = k;
        this.size = 0;
        
    }
    
    public boolean insertFront(int value) {
        if(this.isFull()) {
            return false;
        }
        incrementStart();
        if(this.isEmpty()) {
            incrementEnd();
        }
        this.deque[this.start] = value;
        this.size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(this.isFull()) {
            return false;
        }
        incrementEnd();
        if(this.isEmpty()) {
            incrementStart();
        }
        this.deque[this.end] = value;
        this.size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(this.isEmpty()) return false;
        decrementStart();
        this.size--;
        if(this.size == 0) {
            this.start = -1;
            this.end = -1;
        }
        return true;
    }
    
    public boolean deleteLast() {
        if(this.isEmpty()) return false;
        decrementEnd();
        this.size--;
        if(this.size == 0) {
            this.start = -1;
            this.end = -1;
        }
        return true;
    }
    
    public int getFront() {
        if(this.isEmpty()) return -1;
        return this.deque[this.start];
    }
    
    public int getRear() {
        if(this.isEmpty()) return -1;
        return this.deque[this.end];
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public boolean isFull() {
        return this.size == k;
    }

    public void incrementStart() {
        if(this.start == -1) {
            this.start = 0;
        }
        else if(this.start == 0) {
            this.start = this.k - 1;
        } else {
            this.start--;
        }
    }

    public void incrementEnd() {
        this.end = (this.end + 1)%this.k;
    }

    public void decrementStart() {
        this.start = (this.start + 1)%this.k;
    }

    public void decrementEnd() {
        if(this.end == -1) {
            this.end = 0;
        }
        else if(this.end == 0) {
            this.end = this.k - 1;
        } else {
            this.end--;
        }
    }
}



/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */