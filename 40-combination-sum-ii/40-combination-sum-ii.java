class Solution {

     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        helper(ans,new ArrayList<>(),candidates,target,0);
        return ans;
    }
    private void helper(List<List<Integer>> ans,List<Integer> temp,int[] nums,int tar,int i){
        if(tar==0){
          
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(tar<0||i>nums.length-1)return;
        int curr=nums[i];
       if(curr<=tar){
           temp.add(nums[i]);
        helper(ans,temp,nums,tar-nums[i],i+1);
        temp.remove(temp.size()-1); 
       }
        while(i+1<nums.length&&nums[i+1]==nums[i])i++;
        helper(ans,temp,nums,tar,i+1);
           
    }
}