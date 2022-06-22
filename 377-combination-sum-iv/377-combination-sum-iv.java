class Solution {
    int count=0;
    int[] dp;
    public int combinationSum4(int[] nums, int target) {
    //Arrays.sort(nums);
         dp=new int[target+1];
        Arrays.fill(dp,-1);
    int ans=backtrack(nums, target);
    return ans;
}

private int backtrack(int [] nums, int remain){
    if(remain>=0&&dp[remain]!=-1)return dp[remain];
    if(remain < 0) return 0;
    else if(remain == 0) return 1;
    else{ 
        int res=0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]<=remain)res+=backtrack(nums, remain - nums[i]); // not i + 1 because we can reuse same element
        }
        return dp[remain]=res;
    }
   }
}