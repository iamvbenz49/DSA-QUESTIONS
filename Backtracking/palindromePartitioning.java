class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> mainList = new ArrayList<>();
        List<String> subList = new ArrayList<>();
        findAllPalindromicStrings(mainList,subList,s,"",0);
        return mainList;
    }
    public void findAllPalindromicStrings(List<List<String>> mainList,List<String> subList,String s,String current,int index){
        if(index>=s.length()){
            if(palindromeChecker(current)){
                subList.add(new String(current));
                mainList.add(new ArrayList<>(subList));
                subList.remove(subList.size()-1);
            }
            return;
        }
        current = current + s.charAt(index);
        if(palindromeChecker(current)){
            subList.add(new String(current));
            findAllPalindromicStrings(mainList,subList,s,"",index+1);
            subList.remove(subList.size()-1);
        }
        findAllPalindromicStrings(mainList,subList,s,new String(current),index+1);
    }
    public boolean palindromeChecker(String s){
        if(s.equals(""))return false;
        int left = 0, right = s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
