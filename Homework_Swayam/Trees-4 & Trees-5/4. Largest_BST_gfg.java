class NodeInfo{
    int maxElement;
    int minElement;
    boolean isBst;
    int size;
    
    public NodeInfo(int max,int min,boolean isBst,int size)
    {
        this.maxElement=max;
        this.minElement=min;
        this.isBst=isBst;
        this.size=size;
    }
    public NodeInfo()
    {
        
    }
}
class Solution{
    
    static int largestBst(Node root)
    {
        // Write your code here
        return largest(root).size;
        
    }
    
    static NodeInfo largest(Node root)
    {
        if(root==null)
        return new NodeInfo(Integer.MIN_VALUE,Integer.MAX_VALUE,true,0);
        
        NodeInfo leftSubtree=largest(root.left);
        NodeInfo rightSubtree=largest(root.right);
        
        NodeInfo rootInfo=new NodeInfo();
        
        rootInfo.isBst=leftSubtree.isBst && rightSubtree.isBst && root.data>leftSubtree.maxElement && root.data<rightSubtree.minElement;
        rootInfo.maxElement=Math.max(rightSubtree.maxElement,root.data);
        rootInfo.minElement=Math.min(leftSubtree.minElement,root.data);
        
        if(rootInfo.isBst)
        rootInfo.size=leftSubtree.size+rightSubtree.size+1;
        else
        rootInfo.size=Math.max(leftSubtree.size,rightSubtree.size);
        
        return rootInfo;
        
        
    }
}