class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        //Find the subarray with max sum and unique elements;
        int[] prefix=new int[nums.length];
        prefix[0]=0;
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        Set<Integer> set=new HashSet<>();
        int max=nums[0];
        int curr=0;
        int lef=0;
        for(int i=0;i<nums.length&&lef<nums.length;){
            if(set.contains(nums[i])){
                curr-=nums[lef];
                set.remove(nums[lef]);
                lef++;
            }
            else{
                curr+=nums[i];
                set.add(nums[i++]);
            }
            max=Math.max(max,curr);
        }
        return max;
    }
}
