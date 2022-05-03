class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans=0;
        for(int i=0;i<k;i++){
            ans+=nums[i];
        }
        double max=ans;
        for(int j=k;j<nums.length;j++){
            ans+=nums[j];
            ans-=nums[j-k];
            max=Math.max(max,ans);
        }
        return max/k;
    }
}