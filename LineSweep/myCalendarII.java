class MyCalendarTwo {
    Map<Integer, Integer> books;
    public MyCalendarTwo() {
        this.books = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        books.put(start, books.getOrDefault(start, 0)+1);
        books.put(end, books.getOrDefault(end, 0)-1);
        int count = 0;
        for(Map.Entry<Integer, Integer> book: books.entrySet()) {
            count += book.getValue();
            if(count > 2) {
                books.put(start, books.getOrDefault(start, 0)-1);
                books.put(end, books.getOrDefault(end, 0)+1);
                return false;
            }
        }
        return true;
    }
}


/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */