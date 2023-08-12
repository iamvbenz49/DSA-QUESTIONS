class Solution {
    public List<String> letterCombinations(String digits) {
        String[] dial = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> mainString = new ArrayList<>();
        if(digits.equals("")){
            return mainString;
        }
        letterCombination(digits,mainString,new StringBuilder(),0,dial);
        return mainString;
    }
    public void letterCombination(String digits,List<String> mainString,StringBuilder subString,int now,String[] map){
        if(subString.length()==digits.length()){
            mainString.add(subString.toString());
            return;
        }
        String curr = map[digits.charAt(now) - 48];
        for(int i=0;i<curr.length();i++){
            char c = curr.charAt(i);
            subString.append(c);
            letterCombination(digits,mainString,new StringBuilder(subString),now+1,map);
            subString.deleteCharAt(subString.length()-1);
        }
    }
}
