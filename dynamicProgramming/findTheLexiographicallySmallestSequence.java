class Solution {
    public int[] validSequence(String word1, String word2) {
        Set<String> memo = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        if(find(memo, word1, word2, 0, 0, 1, res)) {
            return reverseList(res);
        }
        return new int[]{};
    }   
    public boolean find(Set<String> memo, String word1, String word2, int firstIndex, int secondIndex, int flag, List<Integer> res) {
        if(secondIndex == word2.length()) return true;
        if(firstIndex == word1.length()) return false;
        String currentIndex = firstIndex + " " + secondIndex + " " + flag;
        if(memo.contains(currentIndex)) return false;
        if(word1.charAt(firstIndex) == word2.charAt(secondIndex)) {
            if(find(memo, word1, word2, firstIndex + 1, secondIndex + 1, flag, res)) {
                res.add(firstIndex);
                return true;
            }
        } else {
            if(flag == 1) {
                if(find(memo, word1, word2, firstIndex + 1, secondIndex + 1, 0,res)) {
                    res.add(firstIndex);
                    return true;
                }
            }
            while(firstIndex < word1.length() && word1.charAt(firstIndex) != word2.charAt(secondIndex)) {
                firstIndex++;
            }
            if(firstIndex < word1.length()) {
                if(find(memo, word1, word2, firstIndex + 1, secondIndex + 1, flag, res)) {
                    res.add(firstIndex);
                    return true;
                }
            }
        }
        memo.add(currentIndex);
        return false;
    }
    private int[] reverseList(List<Integer> inputList) {
        Collections.reverse(inputList); // Reverse the list
        
        // Convert the list to an int array
        int[] result = new int[inputList.size()];
        for (int i = 0; i < inputList.size(); i++) {
            result[i] = inputList.get(i);
        }
        return result;
    }
}