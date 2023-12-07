class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList), vis = new HashSet<>();
        if(!words.contains(endWord))
            return 0;
        int changes = 1;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        vis.add(beginWord);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String word = q.poll();
                if(endWord.equals(word)){
                    return changes;
                }
                for(int j=0;j<word.length();j++){
                    for(char k='a';k<='z';k++){
                        char[] wordArray = word.toCharArray();
                        wordArray[j] = k;
                        String s = String.valueOf(wordArray);
                        if(words.contains(s) && !vis.contains(s)){
                            q.add(s);
                            vis.add(s);
                        }
                    }
                }
            }
            changes++;
        }
        System.out.println(changes);
        return 0;
    }
}
