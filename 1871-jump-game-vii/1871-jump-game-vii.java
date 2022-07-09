class Solution {
    public boolean canReach(String s, int min, int max) {
        char[] nums=s.toCharArray();
        boolean[] dp=new boolean[nums.length];
        int valid=0;
        int n=nums.length;
        dp[n-1]=nums[n-1]=='0';
        for(int i=n-2;i>=0;i--){
            //if(nums[i]=='1')continue;
            if(i+min<n&&dp[i+min]){
                valid++;
            }
            if(i+max<n-1&&dp[i+max+1])valid--;
            dp[i]=valid>0&&nums[i]=='0';
        }
        return dp[0];
    }
}