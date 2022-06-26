class Solution {
    Boolean[] dp;
    public boolean canReach(int[] arr, int start) {
        dp=new Boolean[arr.length];
        return helper(arr,start);
    }
    private boolean helper(int[] arr,int id){
        if(id<0||id>arr.length-1||arr[id]==-1)return false;
        if(arr[id]==0)return true;
        if(dp[id]!=null)return dp[id];
        int temp=arr[id];
        arr[id]=-1;
        return dp[id]=helper(arr,id+temp)||helper(arr,id-temp);
    }
}