class Solution {
    public String clearStars(String s) {
        int N = s.length();
        PriorityQueue<Integer>[] freq = new PriorityQueue[26];

        for (int i = 0; i < 26; i++) {
            freq[i] = new PriorityQueue<>((a, b) -> b - a);
        }

        for(int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if(c  == '*') {
                removeSmallest(freq);
            } else {
                freq[c - 'a'].add(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = N - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if(c != '*') {
                if(!freq[c - 'a'].isEmpty() && freq[c - 'a'].peek() == i) {
                    sb.append(c);
                    freq[c - 'a'].poll();
                }
            }
        }
        return sb.reverse().toString();
    }
    public void removeSmallest(PriorityQueue<Integer>[] freq) {
        for(int i = 0; i < 26; i++) {
            if(!freq[i].isEmpty()) {
                freq[i].poll();
                return;
            }
        }
    }
}
