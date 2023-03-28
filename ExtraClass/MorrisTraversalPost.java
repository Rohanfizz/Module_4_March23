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
    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode curr = root;
        List<Integer> ans = new ArrayList<>();
        while(curr != null){
            if(curr.right == null){
                //reverse preorder
                ans.add(curr.val);
                curr= curr.left;
            }else{
                TreeNode leftmost = curr.right;
                while(leftmost.left != null && leftmost.left != curr) leftmost = leftmost.left;
                if(leftmost.left == curr){
                    leftmost.left = null;
                    curr  = curr.left;
                }else{
                    ans.add(curr.val);
                    leftmost.left = curr;
                    curr = curr.right;
                }
                
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}




















