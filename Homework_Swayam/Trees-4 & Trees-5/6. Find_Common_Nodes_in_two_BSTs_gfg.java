class Solution
{
	public static ArrayList<Integer> findCommon(Node root1,Node root2)
    {
        ArrayList<Integer> ans=new ArrayList();
        HashSet<Integer> set=new HashSet();
        
        traversal1(root1,set);
        traversal2(root2,set,ans);
        return ans;
    }
    public static void traversal1(Node root,HashSet<Integer> set)
    {
        if(root==null)
        return;
        
        traversal1(root.left,set);
        set.add(root.data);
        traversal1(root.right,set);
    }
    public static void traversal2(Node root,HashSet<Integer> set,ArrayList<Integer> list)
    {
        if(root==null)
        return;
        
        traversal2(root.left,set,list);
        if(set.contains(root.data))
        list.add(root.data);
        traversal2(root.right,set,list);
    }
}