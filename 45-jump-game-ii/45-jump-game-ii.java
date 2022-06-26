class Solution {
    public int jump(int[] nums) {
        // int[] dp=new int[nums.length];
        // int n=nums.length;
        // dp[n-1]=0;
        // for(int i=n-2;i>=0;i--){
        //     int jumps=nums[i];
        //     if(jumps==0){dp[i]=10001;continue;}
        //     int j=1;
        //     int min=Integer.MAX_VALUE;
        //     while(i+j<n&&jumps-->0){
        //         min=Math.min(min,dp[i+j]);
        //         j++;
        //     }
        //     dp[i]=1+min;
        // }
        // return dp[0];
        int jumps=0,currEnd=0,maxEnd=0;
        for(int i=0;i<nums.length-1;i++){
            maxEnd=Math.max(maxEnd,i+nums[i]);
            if(i==currEnd){
                jumps++;
                currEnd=maxEnd;
            }
        }
        return jumps;
    }
}