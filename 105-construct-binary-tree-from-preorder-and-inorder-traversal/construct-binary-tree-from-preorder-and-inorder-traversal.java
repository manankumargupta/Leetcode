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
    int i; Map<Integer,Integer> m;
    public TreeNode buildTree(int[] pre, int[] in) {
        m=new HashMap<>(); for(int j=0;j<in.length;j++) m.put(in[j],j);
        i=0; return f(pre,0,in.length-1);
    }
    TreeNode f(int[] pre,int l,int r){
        if(l>r) return null;
        TreeNode n=new TreeNode(pre[i++]);
        int k=m.get(n.val);
        n.left=f(pre,l,k-1); n.right=f(pre,k+1,r);
        return n;
    }
}