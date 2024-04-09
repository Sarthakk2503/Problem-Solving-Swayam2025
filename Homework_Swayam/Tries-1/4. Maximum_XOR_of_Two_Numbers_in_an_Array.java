class TrieNode{
    int data;
    TrieNode[] children;
    TrieNode()
    {
        children=new TrieNode[2];
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        TrieNode root=new TrieNode();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            insertIntoTrieNode(root,nums[i]);
            int temp=queryXOR(root,nums[i]);
            max=Math.max(max,temp);
        }
        return max;
    }
    public void insertIntoTrieNode(TrieNode root,int num)
    {
        TrieNode node=root;
        for(int i=31;i>=0;i--)
        {
            int bit=(num>>i)&1;
            if(node.children[bit]==null)
            {
                node.children[bit]=new TrieNode();
            }
            node=node.children[bit];
        }
    }
    public int queryXOR(TrieNode root,int num)
    {
        TrieNode node=root;
        int xor=0;
        for(int i=31;i>=0;i--)
        {
            int bit=(num>>i)&1;
            if(node.children[1-bit]!=null)
            {
                xor+=(1<<i);
                node=node.children[1-bit];
                
            }
            else
            {
                node=node.children[bit];
            }
        }
        
        return xor;
    }
}