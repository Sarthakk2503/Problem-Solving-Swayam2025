class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null)
        return 0;

        int leftSubtree=rangeSumBST(root.left,low,high);
        int rightSubtree=rangeSumBST(root.right,low,high);

        if(root.val>=low && root.val<=high)
        return leftSubtree+rightSubtree+root.val;
        else
        return leftSubtree+rightSubtree;
    }
}