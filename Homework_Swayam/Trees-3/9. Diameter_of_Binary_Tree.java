class Solution {
    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }
    public int helper(TreeNode root)
    {
        if(root==null)
        return 0;

        int leftheight=helper(root.left);
        int rightheight=helper(root.right);

        diameter=Math.max(diameter,leftheight+rightheight);
        return 1+Math.max(leftheight,rightheight);
        //return diameter;
    }
}