class Solution {
    int[] dp;
    public int maxResult(int[] nums, int k) {
        dp=new int[nums.length];
        Arrays.fill(dp,Integer.MIN_VALUE);
        int n=nums.length;
        dp[n-1]=nums[n-1];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        pq.add(new int[]{dp[n-1],n-1});
        for(int i=n-2;i>=0;i--){
            int temp=Integer.MIN_VALUE;
            while(pq.peek()[1]>Math.min(n-1,i+k))pq.remove();
            temp=Math.max(temp,pq.peek()[0]);
            dp[i]=temp+nums[i];
            pq.add(new int[]{dp[i],i});
        }
        return dp[0];
    }
    // private int helper(int[] nums,int i,int k,int n){
    //     if(i==n){
    //         return 0;
    //     }
    //     if(i==n-1)return nums[i];
    //     if(dp[i]!=null)return dp[i];
    //     int max=Integer.MIN_VALUE;
    //     for(int j=i+1;j<=Math.min(n-1,i+k);j++){
    //         int temp=helper(nums,j,k,n);
    //         max=Math.max(max,temp);
    //     }
    //     return dp[i]=max+nums[i];
    // }
}