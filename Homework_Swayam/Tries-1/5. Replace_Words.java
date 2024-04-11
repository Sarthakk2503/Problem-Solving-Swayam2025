class TrieNode{
    char data;
    boolean isEnd;
    TrieNode[] children;
    TrieNode(char ch)
    {
        this.data=ch;
        isEnd=false;
        children =new TrieNode[26];
    }
}
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root=new TrieNode('*');
        for(int i=0;i<dictionary.size();i++)
        {
            String s=dictionary.get(i);
            insertIntoTrie(root,s);
        }
        StringBuilder sb=new StringBuilder();
        String arr[]=sentence.split(" ");
        for(int i=0;i<arr.length;i++)
        {
            String s=arr[i];
            String temp=getPrefix(root,s);
            sb.append(temp+" ");
        }
        return sb.toString().trim();
    }
    public void insertIntoTrie(TrieNode root,String s)
    {
        TrieNode node=root;
        for(int i=0;i<s.length();i++)
        {
            char currChar=s.charAt(i);
            if(node.children[currChar-'a']==null)
            {
                node.children[currChar-'a']=new TrieNode(currChar);
            }
            node=node.children[currChar-'a'];
        }
        node.isEnd=true;
    }
    public String getPrefix(TrieNode root,String s)
    {
        TrieNode node =root;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(node.children[ch-'a']!=null)
            {
                node=node.children[ch-'a'];
                sb.append(ch);
                if(node.isEnd)
                {
                    break;
                }
            }
            else
            break;
        }
        if(!node.isEnd)
        return s;
        else
        return sb.toString();
    }
}