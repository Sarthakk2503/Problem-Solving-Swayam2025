//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = new int[2];
            String s[] = br.readLine().trim().split(" ");
            if(s.length == 2){
                a[0] = Integer.parseInt(s[0]);
                a[1] = Integer.parseInt(s[1]);
            } else{
                a[0] = Integer.parseInt(s[0]);
                s = br.readLine().trim().split(" ");
                a[1] = Integer.parseInt(s[0]);
            }
            int[][] edges = IntMatrix.input(br, a[1], 2);
            
            
            int src; 
            src = Integer.parseInt(br.readLine());
            
            
            int dst; 
            dst = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.minimumEdgeReversal(edges, a[0], a[1], src, dst);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends
class pair
{
    int node;
    int cost;
    pair(int node,int cost)
    {
        this.node=node;
        this.cost=cost;
    }
}
class Solution {
    public static int minimumEdgeReversal(int[][] edges, int n, int m, int src, int dst) {
        // code here
        List<Integer>[] adj=new ArrayList[n+1];
        List<Integer>[] revadj=new ArrayList[n+1];
        for(int i=0;i<n+1;i++)
        {
            adj[i]=new ArrayList<Integer>();
            revadj[i]=new ArrayList<Integer>();
        }
        for(int[] ar:edges)
        {
            adj[ar[0]].add(ar[1]);
            revadj[ar[1]].add(ar[0]);
        }

        Deque<pair> dq=new ArrayDeque();
        dq.addFirst(new pair(src,0));
        boolean[] visited=new boolean[n+1];
        
        while(!dq.isEmpty())
        {
            pair temp=dq.poll();
            int node=temp.node;
            int cost=temp.cost;
            
            if(node==dst)
            return cost;
            
            visited[node]=true;
            for(int i:adj[node])
            {
                if(!visited[i])
                {
                    dq.addFirst(new pair(i,cost));
                }
                
            }
            for(int i:revadj[node])
            {
                if(!visited[i])
                {
                    dq.addLast(new pair(i,cost+1));
                }
                
            }
        }
        return -1;
    }
}
        
