//Brute force

class Solution {
    public String res = "";
    public int K = 0;
    public String getPermutation(int n, int k) {
        K = k;
        int[] vis = new int[n+1];
        permutations(new ArrayList<>(), n,vis);
        return res;
    }
     public void permutations(List<Integer> subList,int n,int[] vis){
        if(subList.size()==n){
            K--;
            if(K==0){
                for(int num:subList)
                    res = res + Integer.valueOf(num);
                return;
            }
            return;
        }
        for(int i=1;i<=n;i++){
            if(vis[i]!=1){
                vis[i] = 1;
                subList.add(i);
                permutations(new ArrayList<>(subList),n,vis);
                subList.remove(subList.size()-1);
                vis[i] = 0;
            }
        }
    }
}

//optimised tc - o(n*2) sc - o(n)
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int fact = 1;
        for(int i=1;i<n;i++){
            fact = fact*i;
            list.add(i);
        }
        list.add(n);
        String res = "";
        k = k - 1;
        while(true){
            String s = Integer.toString(list.get(k/fact));
            res = res + s;
            list.remove(k/fact);
            if(list.size()==0)
                break;
            k = k%fact;
            fact = fact/list.size();
        }
        return res;
    }
}
