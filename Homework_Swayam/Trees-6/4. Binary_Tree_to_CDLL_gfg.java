class Solution
{
    Node head=null;
    Node prev=null;
    
    Node bTreeToClist(Node root)
    {
        inOrder(root);
        return head;
    }
    public void inOrder(Node root)
    {
        if(root==null)
        return;
        
        inOrder(root.left);
        if(prev==null)
        head=root;
        else{
            root.left=prev;
            prev.right=root;
        }
        prev=root;
        inOrder(root.right);
        
        prev.right=head;
        head.left=prev;
    }
}