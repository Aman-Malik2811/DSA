class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left=nums.length,right=0;
        
        //Perform Selection Sort;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                //Instead of swapping note boundaries
                if(nums[i]>nums[j]){
                   left=Math.min(left,i);
                   right=Math.max(right,j);
                }
            }
        }
        return right-left<0?0:right-left+1;
    }
}