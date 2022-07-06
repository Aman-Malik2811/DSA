class Solution {
    public void nextPermutation(int[] nums) {
       int j=nums.length-1;
       while(j>=1&&nums[j-1]>=nums[j])j--;
       if(j!=0){
           int id=j-1;
           int en=nums.length-1;
           while(en>=id&&nums[id]>=nums[en])en--;
           swap(nums,id,en);
       }
       reverse(nums,j,nums.length-1);
    }
    private void reverse(int[] nums,int st,int en){
        while(st<en){
            swap(nums,st,en);
            st++;
            en--;
        }
    }
    private void swap(int[] nums,int st,int en){
        int temp=nums[st];
        nums[st]=nums[en];
        nums[en]=temp;
    }
}
