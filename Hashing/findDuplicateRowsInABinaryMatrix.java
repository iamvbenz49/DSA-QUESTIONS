class Solution
{
    public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n)
    {
        Set<String> set = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<m;i++){
            String curr = Arrays.toString(matrix[i]);
            if(set.contains(curr)) res.add(i);
            else set.add(curr);
        }
        return res;
    }
}
