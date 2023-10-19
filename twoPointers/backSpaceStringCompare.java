class Solution {
    public boolean backspaceCompare(String s, String t) {
        int ps = s.length()-1;
        int pt = t.length()-1;
        while(ps>=0 || pt>=0){
            ps = clearSpace(s,ps);
            pt = clearSpace(t,pt);
            if(ps<0 && pt<0)
                return true;
            if(ps<0 || pt<0)
                return false;
            if(s.charAt(ps)!=t.charAt(pt))
                return false;
            ps--;
            pt--;
        }
        return true;
    }
    public int clearSpace(String s,int index){
        int count = 0;
        while(index>=0){
            if(s.charAt(index)=='#'){
                count++;
                index--;
            }
            else if(count>0){
                count--;
                index--;
            }else{
                break;
            }
        }
        return index;
    }
