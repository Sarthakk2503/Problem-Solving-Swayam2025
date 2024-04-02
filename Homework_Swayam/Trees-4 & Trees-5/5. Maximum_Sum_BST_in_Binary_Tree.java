class NodeInfo{
    int max;
    int min;
    boolean isBst;
    int sum=0;
    public NodeInfo(int max,int min,boolean isBst,int sun)
    {
        this.max=max;
        this.min=min;
        this.isBst=isBst;
        this.sum=sum;
    }
    public NodeInfo(){}
}
class Solution {
    int ans=0;
    public int maxSumBST(TreeNode root) {
        largestSum(root);
        return ans;
    }
    NodeInfo largestSum(TreeNode root)
    {
        if(root==null)
        return new NodeInfo(Integer.MIN_VALUE,Integer.MAX_VALUE,true,0);

        NodeInfo leftSubtree=largestSum(root.left);
        NodeInfo rightSubtree=largestSum(root.right);

        NodeInfo rootInfo=new NodeInfo();
        rootInfo.isBst=leftSubtree.isBst && rightSubtree.isBst && root.val>leftSubtree.max &&root.val<rightSubtree.min;
        rootInfo.min=Math.min(root.val,leftSubtree.min);
        rootInfo.max=Math.max(root.val,rightSubtree.max);

        if(rootInfo.isBst)
        {
            rootInfo.sum=leftSubtree.sum+rightSubtree.sum+root.val;
        }
        else
        rootInfo.sum=Math.max(leftSubtree.sum,rightSubtree.sum);

        ans=Math.max(ans,rootInfo.sum);
        return rootInfo;
    }
}