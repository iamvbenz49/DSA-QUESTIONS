class MedianFinder {
    PriorityQueue<Integer> maxHeap, minHeap;
    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(this.maxHeap.size() > this.minHeap.size()) {
            this.minHeap.add(num);
        } else {
            this.maxHeap.add(num);
            
        }
        if(this.maxHeap.size() >= this.minHeap.size()) {
            this.minHeap.add(this.maxHeap.poll());
        }
        if(this.maxHeap.size() < this.minHeap.size()) {
            this.maxHeap.add(this.minHeap.poll());
        }
    }
    
    public double findMedian() {
        int maxHeapSize = this.maxHeap.size();
        int minHeapSize = this.minHeap.size();
        if((maxHeapSize + minHeapSize)%2 == 0) {
            double maxHeapTop = this.maxHeap.peek();
            double minHeapTop = this.minHeap.peek();
            System.out.println(maxHeapTop+ " "+minHeapTop);
            return (maxHeapTop + minHeapTop)/2.0;
        } 
        if(maxHeapSize > minHeapSize) {
            return (double)this.maxHeap.peek();
        }
        return (double)this.minHeap.peek();
    }
}