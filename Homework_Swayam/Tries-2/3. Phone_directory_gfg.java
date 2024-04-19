class TrieNode{
    boolean isEnd;
    TrieNode[] children;
    List<String> commonNames;
    TrieNode()
    {
        this.children=new TrieNode[26];
        this.commonNames=new ArrayList<>();
    }
}
class Solution{
    TrieNode root=new TrieNode();
    ArrayList<ArrayList<String>> ans=new ArrayList();
    ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        Arrays.sort(contact);
        
        for(int i=0;i<n;i++)
        {
            insertIntoTrie(root,contact[i]);
        }
        for(int i=1;i<=s.length();i++)
        {
            String ss=s.substring(0,i);
            query(root,ss);
        }
        return ans;
    }
    public void insertIntoTrie(TrieNode root,String s)
    {
        TrieNode node=root;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            if(node.children[c-'a']==null)
            node.children[c-'a']=new TrieNode();
            
            node=node.children[c-'a'];
            if(!node.commonNames.contains(s))
            node.commonNames.add(s);
        }
    }