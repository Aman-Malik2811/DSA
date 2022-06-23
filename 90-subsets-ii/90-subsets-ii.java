class Solution {
     public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
         Arrays.sort(nums);
        helper(ans,new ArrayList<>(),nums,0);
        return ans;
    }
    private void helper(List<List<Integer>> ans,List<Integer> temp,int[] nums,int st){
        if(st==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[st]);
        helper(ans,temp,nums,st+1);
        temp.remove(temp.size()-1);
        while(st+1<nums.length&&nums[st+1]==nums[st])st++;
        helper(ans,temp,nums,st+1);
    }
}