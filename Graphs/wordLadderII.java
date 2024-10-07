class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList), vis = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();

        if(!words.contains(endWord))
            return ans;

        Queue<List<String>> q = new LinkedList<>();
        List<String> startList = new ArrayList<>(), usedOnThatLevel = new ArrayList<>();
        
        int level = 0;

        startList.add(beginWord);
        usedOnThatLevel.add(beginWord);
        vis.add(beginWord);

        q.add(startList);

        while(!q.isEmpty()){
            List<String> peek = q.poll();
            if(peek.size()>level){
                level++;
                for(String used:usedOnThatLevel){
                    vis.add(used);
                }
            }
            String word =peek.get(peek.size()-1);
            if(endWord.equals(word)){
                if(ans.size()==0)
                    ans.add(peek);
                else if(ans.get(0).size()==peek.size())
                    ans.add(peek);
            }
            for(int j=0;j<word.length();j++){
                for(char k='a';k<='z';k++){
                    char[] wordArray = word.toCharArray();
                    wordArray[j] = k;
                    String s = String.valueOf(wordArray);
                    if(words.contains(s) && !vis.contains(s)){
                        peek.add(s);
                        usedOnThatLevel.add(s);
                        q.add(new ArrayList<>(peek));
                        peek.remove(peek.size()-1);
                    }
                }                
            }
        }
        return ans;
    }
}
