class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i]))map.put(nums[i],i);
        }
        int ans=0;
        for(int i=0;i<nums.length&&!map.isEmpty();i++){
            int key=nums[i];
            if(map.containsKey(key-1))continue;
            int temp=1;
            while(map.containsKey(key+1)){
                temp++;
                key=key+1;
                map.remove(key);
            }
            ans=Math.max(ans,temp);
        }
        return ans;
    }
}