class tuple
{
    TreeNode node;
    int x;
    int y;
    public tuple(TreeNode node,int x,int y)
    {
        this.node=node;
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap();
        Queue<tuple> q=new LinkedList<tuple>();
        q.offer(new tuple(root,0,0));
        helper(map,q);
        List<List<Integer>> ans=new ArrayList();
        for (TreeMap<Integer,PriorityQueue<Integer>>m: map.values()) {
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer>value:m.values()) {
                while (!value.isEmpty()) {
                    ans.get(ans.size() - 1).add(value.poll());
                }
            }
        }
        return ans;
    }
    public void helper(TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map,Queue<tuple> q)
    {
        while(!q.isEmpty())
        {
            tuple t=q.poll();
            TreeNode node =t.node;
            int x=t.x;
            int y=t.y;

            map.putIfAbsent(x,new TreeMap());
            TreeMap<Integer,PriorityQueue<Integer>> temp=map.get(x);
            temp.putIfAbsent(y,new PriorityQueue());
            map.get(x).get(y).add(node.val);

            if (node.left != null) {
                q.offer(new tuple(node.left, x -1, y +1));
            }
            if (node.right != null) {
                q.offer(new tuple(node.right, x + 1, y + 1));
            }

        }
    }
}