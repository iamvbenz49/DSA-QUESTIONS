class Solution {
    public String makeGood(String s) {
        int size = s.length(), pointer = 0;
        char[] res = new char[size];
        for(int i=0;i<size;i++){
            if(pointer>0 && Math.abs(res[pointer-1]-s.charAt(i)) == 32)
                pointer--;
            else
                res[pointer++] = s.charAt(i);
        }
        return (new String(res)).substring(0,pointer);
    }
}
