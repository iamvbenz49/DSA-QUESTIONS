class Solution {
    public List<Integer> addToArrayForm(int[] num, int n) {
        List<Integer> lst = new ArrayList<>();
        int carry =0;
        for(int i = num.length-1;i>=0;i--){
            int curr = num[i]+(n%10)+carry;
            if(carry!=0)carry = 0;
            lst.add(curr%10);
            // System.out.println(lst+" "+curr+" "+carry);
            if(curr>9){
                curr/=10;
                carry = curr;
            }
            n/=10;
        }
        for(int i=0;n!=0;i++){
            int curr = (n%10)+carry;
            if(carry!=0)carry = 0;
            lst.add(curr%10);
            curr/=10;
            if(curr!=0)carry=curr;
            n/=10;
        }
        if(carry!=0)lst.add(carry);
        Collections.reverse(lst);
        return lst;
    }
}
