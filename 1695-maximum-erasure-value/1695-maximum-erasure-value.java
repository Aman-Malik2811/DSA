class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        //Find the subarray with max sum and unique elements;
        int[] prefix=new int[nums.length];
        prefix[0]=0;
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        Map<Integer,Integer> map=new HashMap<>();
        int max=nums[0];
        int curr=nums[0];
        int lef=0;
        map.put(nums[0],0);
        for(int i=1;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                lef=Math.max(lef,map.get(nums[i]));
                curr=prefix[i]-prefix[lef];
                map.put(nums[i],i);
            }
            else{
                map.put(nums[i],i);
                curr+=nums[i];
            }
            max=Math.max(max,curr);
        }
        return max;
    }
}