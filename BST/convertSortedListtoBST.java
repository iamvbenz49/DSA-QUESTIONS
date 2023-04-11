/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        int count = 0;
        node = head;
        while(head!=null){
            count++;
            head = head.next;
        }
        return sortedListToBST(0,count-1);
    }
    public TreeNode sortedListToBST(int l,int r){
        if(l>r)
            return null;
        
        int m = l + (r-l)/2;
        TreeNode leftNode = sortedListToBST(l,m-1);
        TreeNode root = new TreeNode(node.val);
        node = node.next;
        root.left = leftNode;
        root.right = sortedListToBST(m+1,r);

        return root;
    }
}
