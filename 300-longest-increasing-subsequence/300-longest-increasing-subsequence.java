class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans=0;
        int[] temp=new int[nums.length];
        temp[0]=1;
        for(int i=1;i<nums.length;i++){
            int curr=0;
            int j=i-1;
            while(j>=0){
                if(nums[j]<nums[i]){
                    curr=Math.max(curr,temp[j]);
                }
                j--;
            }
            temp[i]=curr+1;
            ans=Math.max(ans,temp[i]);
        }
        return Math.max(ans,temp[nums.length-1]);
    }
}