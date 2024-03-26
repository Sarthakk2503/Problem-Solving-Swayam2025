class Solution
{
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans=new ArrayList();
        TreeMap<Integer,TreeMap<Integer,List<Integer>>> map=new TreeMap();
        helper(root,0,0,map);
        //System.out.println(map);
        for(TreeMap<Integer,List<Integer>> m:map.values())
        {
            for(List<Integer> l:m.values())
            {
                ans.add(l.get(0));
                break;
            }
        }
        return ans;
    }
    public static void helper(Node root,int x,int y,TreeMap<Integer,TreeMap<Integer,List<Integer>>> map)
    {
        if(root==null)
        return;
        //System.out.println("root : "+root.data+" pos : "+y);
        map.putIfAbsent(y,new TreeMap());
        TreeMap<Integer,List<Integer>> temp=map.get(y);
        temp.putIfAbsent(x,new ArrayList());
        List<Integer> l=temp.get(x);
        l.add(root.data);
        temp.put(x,l);
        
        helper(root.left,x+1,y-1,map);
        helper(root.right,x+1,y+1,map);
    }
}