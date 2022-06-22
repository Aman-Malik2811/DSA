class Solution {
    Set<List<Integer>> st=new HashSet<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(ans,new ArrayList<>(),candidates,target,0);
        return ans;
    }
    private void helper(List<List<Integer>> ans,List<Integer> temp,int[] nums,int tar,int i){
        if(tar<0||i>nums.length-1)return;
        if(tar==0){
            if(!st.contains(temp)){
                ans.add(new ArrayList<>(temp));
                st.add(new ArrayList<>(temp));
            }
            return;
        }
        int curr=nums[i];
        if(curr>tar){
            helper(ans,temp,nums,tar,i+1);
        }
        else{
            helper(ans,temp,nums,tar,i+1);
            temp.add(nums[i]);
            helper(ans,temp,nums,tar-nums[i],i);
            temp.remove(temp.size()-1);
        }
        
    }
}