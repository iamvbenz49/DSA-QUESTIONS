class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(String s:word1){
            sb1.append(s);
        }
        for(String s:word2){
            sb2.append(s);
        }
        System.out.println(sb1+" "+sb2);
        return sb1.toString().equals(sb2.toString());
    }
}

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return String.join("",word1).equals(String.join("",word2));
    }
}
