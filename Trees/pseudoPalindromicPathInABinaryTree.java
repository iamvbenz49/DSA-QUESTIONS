// TC - O(N) SC - O(9)
class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] hash = new int[10];
        return paths(root, hash);
    }
    public int paths(TreeNode root,int[] hash){
        if(root==null) return 0;
        hash[root.val]++;
        if(root.left==null && root.right==null) {
            int res = checkPermutations(hash);
            hash[root.val]--;
            return res;
        }
        int left = paths(root.left,hash);
        int right = paths(root.right,hash);
        hash[root.val]--;
        return left + right;
    }
    public int checkPermutations(int[] hash){
        System.out.print(Arrays.toString(hash));
        boolean oddCheck = false;
        for(int i=0;i<10;i++){
            if(hash[i]%2!=0){
                if(oddCheck) return 0;
                oddCheck = true;
            }
        }
        return 1;
    }
}

// TC - O(N) SC - O(1) here we use bits as the hash table
class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        return paths(root,0);
    }
    public int paths(TreeNode root,int seen){
        if(root==null) return 0;
        seen ^= 1<<(root.val-1);
        int left = paths(root.left,seen);
        int right = paths(root.right,seen);
        if(root.left==null && root.right==null) {
            if((seen&(seen-1))==0) return 1;
            else return 0;
        }
        return left + right;
    }
}
