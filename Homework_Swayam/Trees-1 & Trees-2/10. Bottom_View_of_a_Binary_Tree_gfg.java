class Solution
{
    static ArrayList<Integer> bottomView(Node root)
    {
        ArrayList<Integer> ans=new ArrayList();
        TreeMap<Integer,TreeMap<Integer,List<Integer>>> map=new TreeMap();
        helper(root,0,0,map);
        //System.out.println(map);
        for(TreeMap<Integer,List<Integer>> m:map.values())
        {
            int key=0;
            for(int i :m.keySet())
            {
                
                key=i;
            }
            ans.add(m.get(key).get(m.get(key).size()-1));
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