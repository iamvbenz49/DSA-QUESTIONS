class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        for(int i=0,j=0;i<s.length();i++){
            j = i;
            while(j<s.length() && arr[j]!=' '){
                j++;
            }
            reverse(arr,i,j-1);
            i = j;
        }
        return "".valueOf(arr);
    }
    public void reverse(char[] arr,int i,int j){
        while(i<=j){
            char temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}
