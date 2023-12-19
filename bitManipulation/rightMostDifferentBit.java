class Solution
{
    //Function to find the first position with different bits.
    public static int posOfRightMostDiffBit(int m, int n)
    {
        int count = 1; 
        while(m!=0||n!=0){
            if((m&1)!=(n&1))
                return count;
            m>>=1;
            n>>=1;
            count++;
        }      
        return -1;   
    }
}
