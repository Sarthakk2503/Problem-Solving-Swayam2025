class TrieNode{
    int i;
    int j;
    TrieNode[] children;
    TrieNode()
    {
        this.i=0;
        this.j=0;
        children=new TrieNode[2];
    }
}

class Solution {
    TrieNode root=new TrieNode();
    public int countTriplets(int[] arr) {
        int ans=0;
        int xor=0;
        
        for(int i=0;i<arr.length;i++)
        {
            insertIntoTrie(root,xor,i);
            xor^=arr[i];
            ans+=query(root,xor,i);
        }
        return ans;
    }
    public void insertIntoTrie(TrieNode root,int num,int ind)
    {
        TrieNode node=root;
        for(int i=31;i>=0;i--)
        {
            int bit=(num>>i)&1;
            if(node.children[bit]==null)
            node.children[bit]=new TrieNode();

            node=node.children[bit];
        }
        node.i+=ind;
        node.j++;
    }
    public int query(TrieNode root,int num,int ind)
    {
        TrieNode node=root;
        for(int i = 31; i >= 0; i--){
            int bit =(num>>i)&1;
        
            if (node.children[bit] == null){
                return 0;
            }
            node=node.children[bit];
        }
        return (((node.j)*ind)-(node.i));
    }
}