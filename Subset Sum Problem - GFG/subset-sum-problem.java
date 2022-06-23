// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{

    static Boolean[][] dp;
    static Boolean isSubsetSum(int N, int arr[], int sum){
        dp=new Boolean[N+1][sum+1];
        return helper(0,sum,arr);
    }
    static boolean helper(int i,int sum,int[] arr){
        if(sum<0)return false;
        if(i>=arr.length){
           if(sum==0)return true; 
           return false;
        }
        if(dp[i][sum]!=null)return dp[i][sum];
        int curr=arr[i];
        if(curr<=sum){
            return dp[i][sum]=helper(i+1,sum,arr)||helper(i+1,sum-curr,arr);
        }
        return dp[i][sum]=helper(i+1,sum,arr);
    }
}