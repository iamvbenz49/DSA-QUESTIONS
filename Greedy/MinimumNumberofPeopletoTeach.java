class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int numUsers = languages.length;
        Set<Integer>[] set = new HashSet[numUsers + 1];
        
        for(int i = 0; i < numUsers; i++) {
            set[i + 1] = new HashSet<>();
            for(int number: languages[i]) {
                set[i + 1].add(number);
            }
        }
        Set<Integer> problematicUsers = new HashSet<>();
        for(int[] friends: friendships) {
            int u = friends[0];
            int v = friends[1];

            if(!canCommunicate(set, u, v)) {
                problematicUsers.add(u);
                problematicUsers.add(v);
            }
        }
        int[] freq = new int[n + 1];
        int maxFreq = 0;
        for(int user: problematicUsers) {
            for(int lang: set[user]) {
                freq[lang]++;
                maxFreq = Math.max(maxFreq, freq[lang]);
            }
        }
        
        return problematicUsers.size() - maxFreq;
    }
    public boolean canCommunicate(Set<Integer>[] set, int u, int v) {
        for(int val: set[u]) {
            if(set[v].contains(val)) {
                return true;
            }
        }
        return false;
    }
}
