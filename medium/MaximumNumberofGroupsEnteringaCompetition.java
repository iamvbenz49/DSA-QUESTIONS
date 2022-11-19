//using logical approach
class Solution {
    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int i = 0;
        int j = 1;
        int add = 0;
        while(i<grades.length){
            i = i + j;
            if(i<=grades.length){
                add++;
            }
            j = j + 1;
        }
        return add;
    }
}


//using formula method
//1+2+3+...x <=n
//using quadratic equation formula we can arrive at -1 -root(4+8n)/2
class Solution {
    public int maximumGroups(int[] grades) {
        return (int)((Math.sqrt(grades.length*8 +1)-1)/2);
    }
}
