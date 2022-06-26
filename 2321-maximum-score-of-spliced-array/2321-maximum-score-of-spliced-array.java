class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int sum1=0,sum2=0;
        for(int val:nums1)sum1+=val;
        for(int val:nums2)sum2+=val;
        return Math.max(helper(nums1,nums2)+sum1,helper(nums2,nums1)+sum2);
    }
    private int helper(int[] nums1,int[] nums2){
        int curr=0,ans=0;
        for(int i=0;i<nums1.length;i++){
            curr=Math.max(nums2[i]-nums1[i],curr+nums2[i]-nums1[i]);
            ans=Math.max(ans,curr);
        }
        return ans;
    }
}