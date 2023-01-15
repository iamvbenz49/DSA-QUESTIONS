//using common sense
class Solution {
    public String restoreString(String s, int[] indices) {
        char[] arr = new char[s.length()];         
        for(int i=0;i<indices.length;i++){
            arr[indices[i]] = s.charAt(i);
        }
        StringBuilder sb=new StringBuilder();
        for(char c: arr){
            sb.append(c);
        }
        return sb.toString();
    }
}

//using cyclic sort
class Solution {
    public String restoreString(String s, int[] indices){
        char[] str = s.toCharArray();
        int i =0;
        while(i<indices.length){
            if(i!=indices[i]){
                swap(str,i,indices[i]);
                swap(indices,i,indices[i]);
            }
            else{
                i++;
            }
        }
        return String.valueOf(str);
    }
    void swap(char[] arr,int i,int j){
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
    void swap(int[] arr,int i,int j){
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
