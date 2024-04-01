class Tree {
    int ans=Integer.MAX_VALUE;
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        int output=helper(root,key);
        if(output==Integer.MAX_VALUE)
        return -1;
        else
        return output;
    }
    public int helper(Node root,int key)
    {
        if(root==null)
        return Integer.MAX_VALUE;
        
        if(root.data==key)
        return key;
        
        else if(root.data<key)
        return helper(root.right,key);
        
        else
        {
            ans=root.data;
            return Math.min(ans,helper(root.left,key));
        }
    }
}