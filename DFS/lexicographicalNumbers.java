class Solution {
    private List<Integer> res;
    public List<Integer> lexicalOrder(int n) {
        res = new ArrayList<>();
        for(int i = 1; i <= 9; i++) {
            if(i <= n)
                dfs(i, n);

        }
            
        return res;
    }
    public void dfs(int temp, int main) {
        res.add(temp);
        for(int i = 0; i <= 9; i++) {
            temp = temp*10 + i;
            if (temp <= main) {
                dfs(temp, main);
            }
            temp = temp / 10;
        }
    }
}
