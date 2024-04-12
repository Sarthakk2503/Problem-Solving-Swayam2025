class TrieNode{
    int count=0;
    TrieNode[] children;
    TrieNode()
    {
        this.count=0;
        children=new TrieNode[2];
    }
}

class Solution {
    public int countPairs(int[] nums, int low, int high) {
        TrieNode root=new TrieNode();
        int ans=0;
        insertIntoTrie(root,nums[0]);

        for(int i=1;i<nums.length;i++)
        {
            ans+=queryXOR(root,nums[i],high+1)-queryXOR(root,nums[i],low);
            insertIntoTrie(root,nums[i]);
        }
        return ans;
    }
    public void insertIntoTrie(TrieNode root,int n)
    {
        root.count+=1;
        TrieNode node=root;
        for(int i=14;i>=0;i--)
        {
            int bit=(n>>i)&1;
            if(node.children[bit]==null)
            {
                node.children[bit]=new TrieNode();
            }
            node=node.children[bit];
            node.count++;
        }
    }
    public int queryXOR(TrieNode root,int n,int limit)
    {
        TrieNode node=root;
        int ans=0;
        for(int i=14;i>=0 && node!=null;i--)
        {
            int bit1=(n>>i)&1;
            int bit2=(limit>>i)&1;

            if(bit1==0 && bit2==1)
            {
                if(node.children[0]!=null)
                ans+=node.children[0].count;

                node=node.children[1];
            }
            else if(bit1==1 && bit2==1)
            {
                if(node.children[1]!=null)
                ans+=node.children[1].count;

                node=node.children[0];
            }
            else
            {
                node=node.children[bit1];
            }  
        }
        return ans;
    }
}