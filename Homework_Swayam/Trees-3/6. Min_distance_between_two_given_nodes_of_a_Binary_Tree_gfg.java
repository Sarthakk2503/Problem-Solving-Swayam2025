class GfG {
    int findDist(Node root, int a, int b) {

        ArrayList<Integer> path1=new ArrayList();
        ArrayList<Integer> path2=new ArrayList();
        
        helper(root,a,path1);
        helper(root,b,path2);
        
        
        int n=Math.min(path1.size(),path2.size());
        Collections.reverse(path1);
        Collections.reverse(path2);
        
        
        int i=0;
        for(i=0;i<n;i++)
        {
            int x=path1.get(i);
            int y=path2.get(i);
            if(x!=y)
            {
                break;
            }
        }
        return Math.abs((path1.size()-i)+(path2.size()-i));
    }
    public boolean helper(Node root,int a,ArrayList<Integer> path)
    {
        if(root==null)
        return false;
        
        if(root.data==a || helper(root.left,a,path) || helper(root.right,a,path))
        {
            path.add(root.data);
            return true;
        }
        return false;
    }
}