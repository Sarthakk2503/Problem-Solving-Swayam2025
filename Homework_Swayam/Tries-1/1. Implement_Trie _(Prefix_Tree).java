class TrieNode{
    char data;
    boolean isEnd;
    TrieNode children[];
    TrieNode(char ch)
    {
        this.data=ch;
        this.isEnd=false;
        children=new TrieNode[26];
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root=new TrieNode('*');
    }
    
    public void insert(String word) {
        insertIntoTrie(root,word);
    }
    
    public boolean search(String word) {
        return searchInTrie(root,word);
    }
    
    public boolean startsWith(String prefix) {
        return startWithInTrie(root,prefix);
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
    public boolean searchInTrie(TrieNode root,String s)
    {
        TrieNode node=root;
        for(int i=0;i<s.length();i++)
        {
            char currChar=s.charAt(i);
            if(node.children[currChar-'a']==null)
            return false;
            node=node.children[currChar-'a'];
        }
        if(node.isEnd==false)
        return false;
        else
        return true;
    }
    public boolean startWithInTrie(TrieNode root,String s)
    {
        TrieNode node=root;
        for(int i=0;i<s.length();i++)
        {
            char currChar=s.charAt(i);
            if(node.children[currChar-'a']==null)
            {
                return false;
            }
            node=node.children[currChar-'a'];
        }
        return true;
    }
}