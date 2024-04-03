class Solution
{
    public List<Integer> merge(Node root1,Node root2)
    {
        List<Integer> list1=new ArrayList<Integer>();
        List<Integer> list2=new ArrayList<Integer>();
        List<Integer> ans=new ArrayList<Integer>();
        
        inOrder(root1,list1);
        inOrder(root2,list2);
        
        mergeAndSortList(ans,list1,list2);
        return ans;
        
    }
    public void inOrder(Node root,List<Integer> list)
    {
        if(root==null)
        return;
        
        inOrder(root.left,list);
        list.add(root.data);
        inOrder(root.right,list);
        
    }
    public void mergeAndSortList(List<Integer> ans,List<Integer> list1,List<Integer> list2)
    {
        int i=0,j=0;
        while(i<list1.size() && j<list2.size())
        {
            if(list1.get(i)<list2.get(j))
            {
                ans.add(list1.get(i++));
            }
            else
            {
                ans.add(list2.get(j++));
            }
        }
        
        while(i<list1.size())
        ans.add(list1.get(i++));
        
        while(j<list2.size())
        ans.add(list2.get(j++));
    }
}