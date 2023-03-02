class Solution {
    public int compress(char[] chars) {
        int i =0;//pointer variable
        int j =0;//length to return 
        //temporary length for each alphabet, to know how
        //many times each alphabet occurs 
        int l =1;
        while(i<chars.length){
            //check if current element is equal to next Element
            //if so add +1 to the temporary length
            if(i!=chars.length-1 && chars[i]==chars[i+1] ){
                l++;
            }
            //other wise add the character and number of times it occured to the array
            else{
                //add the character to the list
                chars[j++]=chars[i];
                //if the number is greater than one add those numbers to the character array
                if(l>1){
                    String s = Integer.toString(l);
                    for(int k=0;k<s.length();k++){
                        chars[j++]=s.charAt(k);
                    }
                }
                l=1;//changing the state of temporary length
            }
            i++;
        }
        return j;
    }
}
