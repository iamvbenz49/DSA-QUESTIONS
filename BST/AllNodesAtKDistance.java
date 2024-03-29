class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Set<TreeNode> vis = new HashSet<>();
        Map<TreeNode,TreeNode> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        find(root,target,map);
        nodeAtK(target,vis,map,k,list);
        return list;
    }
    public void find(TreeNode root,TreeNode target,Map<TreeNode,TreeNode> map){
        if(root.left!=null){
            map.put(root.left,root);
            find(root.left,target,map);
        }
        if(root.right!=null){
            map.put(root.right,root);
            find(root.right,target,map);
        }
    }
    public void nodeAtK(TreeNode root,Set<TreeNode> vis,Map<TreeNode,TreeNode> map,int k,List<Integer> list){
        if(root==null){
            return;
        }
        if(vis.contains(root)){
            return;
        }
        vis.add(root);
        if(k==0){
            list.add(root.val);
            return;
        }
        nodeAtK(root.left,vis,map,k-1,list);
        nodeAtK(root.right,vis,map,k-1,list);
        if(map.containsKey(root)){
            nodeAtK(map.get(root),vis,map,k-1,list);
        }
    }
}

// Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

// You can return the answer in any order.

 

// Example 1:

// Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
// Output: [7,4,1]
// Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.

// Example 2:

// Input: root = [1], target = 1, k = 3
// Output: []

 

// Constraints:

//     The number of nodes in the tree is in the range [1, 500].
//     0 <= Node.val <= 500
//     All the values Node.val are unique.
//     target is the value of one of the nodes in the tree.
//     0 <= k <= 1000

