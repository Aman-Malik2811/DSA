class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int sum1=0,sum2=0;
        for(int val:nums1)sum1+=val;
        for(int val:nums2)sum2+=val;
        int[][] dp=new int[n][2];
        int[][] dp2=new int[n][2];
        dp[0][0]=nums2[0]-nums1[0];
        dp[0][1]=0;
        dp2[0][0]=nums1[0]-nums2[0];
        dp2[0][1]=0;
        for(int i=1;i<n;i++){
            int diff1=nums2[i]-nums1[i];
            int diff2=-diff1;
            dp[i][0]=Math.max(dp[i-1][0]+diff1,diff1);
            dp[i][1]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp2[i][0]=Math.max(dp2[i-1][0]+diff2,diff2);
            dp2[i][1]=Math.max(dp2[i-1][0],dp2[i-1][1]);
        }
        int cu1=Math.max(dp[n-1][0],dp[n-1][1]);
        int cu2=Math.max(dp2[n-1][0],dp2[n-1][1]);
        return Math.max(cu1+sum1,cu2+sum2);
    }
}