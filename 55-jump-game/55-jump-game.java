class Solution {
    public boolean canJump(int[] nums) {
        // boolean[] dp=new boolean[nums.length];
        // int n=nums.length;
        // dp[n-1]=true;
        // for(int i=n-2;i>=0;i--){
        //     int jumps=nums[i];
        //     int j=1;
        //     while(i+j<nums.length&&j<=jumps&&!dp[i]){
        //         dp[i]=dp[i]||dp[i+j];
        //         j++;
        //     }
        // }
        // return dp[0];
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,i+nums[i]);
            if(max>=nums.length-1)return true;
            if(max<=i)return false;
        }
        return false;
    }
}