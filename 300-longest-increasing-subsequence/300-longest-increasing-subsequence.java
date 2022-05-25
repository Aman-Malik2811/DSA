class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans=0;
        List<Integer> al=new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
           if(al.size()==0||al.get(al.size()-1)<nums[i]){
               al.add(nums[i]);
               ans++;
           }
           else{
               int id=Collections.binarySearch(al,nums[i]);
               if(id<0)al.set(Math.abs(id)-1,nums[i]);
           }
        }
        return ans;
    }
}