class TrieNode{
    int index;
    TrieNode[] children;
    TrieNode(int data)
    {
        this.index=data;
        this.children=new TrieNode[26];
    }
}

class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TrieNode root=new TrieNode(0);
        for(int i=0;i<wordsContainer.length;i++)
        {
            if(wordsContainer[root.index].length()>wordsContainer[i].length()) 
            root.index=i;
            insertIntoTrie(root,i,wordsContainer);
        }

        int[] ans=new int[wordsQuery.length];
        for(int i=0;i<wordsQuery.length;i++)
        {
            ans[i]=query(root,wordsQuery[i]);
        }
        return ans;
    }
    public void insertIntoTrie(TrieNode root,int ind,String[] arr)
    {
        TrieNode node=root;
        String s=arr[ind];
        for(int i=s.length()-1;i>=0;i--)
        {
            char c=s.charAt(i);
            if(node.children[c-'a']==null)
            {
                node.children[c-'a']=new TrieNode(ind);
            }
            node=node.children[c-'a']; 
            if(arr[node.index].length()>s.length())
            {
                node.index=ind;
            }
        }
    }
    public int query(TrieNode root,String s)
    {
        TrieNode node=root;
        int ans=node.index;
        for(int i=s.length()-1;i>=0;i--)
        {
            char c=s.charAt(i);
            if(node.children[c-'a']==null)
            return ans;

            node=node.children[c-'a'];
            ans=node.index;
        }
        return ans;
    }
}