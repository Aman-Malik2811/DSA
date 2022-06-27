// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}
// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] color=new int[n];
        if(solve(graph,m,n,color,0))return true;
        return false;
    }
    public boolean valid(boolean[][] graph,int curr,int[] color,int temp){
        for(int nbr=0;nbr<graph.length;nbr++){
            if(curr!=nbr&&graph[nbr][curr]&&color[nbr]==temp)return false;
        }
        return true;
    }
    public boolean solve(boolean[][] graph,int m,int n,int[] color,int curr){
        if(curr==n){
            return true;
        }
        for(int col=1;col<=m;col++){
            if(valid(graph,curr,color,col)){
                color[curr]=col;
                if(solve(graph,m,n,color,curr+1))return true;
                color[curr]=0;
            }
        }
        return false;
    }
}