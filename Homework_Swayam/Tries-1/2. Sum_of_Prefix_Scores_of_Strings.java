class TrieNode{
    char data;
    int count;
    TrieNode[] children;
    TrieNode(char ch)
    {
        this.data=ch;
        this.count=0;
        this.children=new TrieNode[26];
    }
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        /* after making the trie prefix tree and counting the frequency of a characters
        who act as prefix the solution became clear that this sum of count of each         character int the string*/

        TrieNode root=new TrieNode('*');
        insertIntoTrie(root,words);
        return getSumPrefixScore(root,words);
    }
    public void insertIntoTrie(TrieNode root,String[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            TrieNode node =root;
            String s=arr[i];
            for(int j=0;j<s.length();j++)
            {
                char ch=s.charAt(j);
                if(node.children[ch-'a']==null)
                {
                    node.children[ch-'a']=new TrieNode(ch);
                }
                node=node.children[ch-'a'];
                node.count+=1;
            }
        }
    }
    public int[] getSumPrefixScore(TrieNode root,String[] arr)
    { 
        int[] ans=new int[arr.length];
        int index=0;
        for(int i=0;i<arr.length;i++)
        {
            TrieNode node =root;
            String s=arr[i];
            int freq=0;
            for(int j=0;j<s.length();j++)
            {
                char ch=s.charAt(j);
                node=node.children[ch-'a'];
                freq+=node.count;
            }
            ans[index++]=freq;
        }
        return ans;
    }
}