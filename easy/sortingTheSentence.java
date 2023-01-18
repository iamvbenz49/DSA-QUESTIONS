class Solution {
    public String sortSentence(String s) {
        String[] arr = new String[s.split(" ").length];
        for(String c:s.split(" ")){
            int index = Integer.parseInt(Character.toString(c.charAt(c.length()-1)));
            arr[index-1] = c.substring(0,c.length()-1);
            if(index!=arr.length){
                arr[index-1]+= ' ';
            }
        }
        s="";
        for(String c:arr){
            s+=c;
        }
        return s;
    }
}
