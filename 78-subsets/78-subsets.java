class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(ans,new ArrayList<>(),nums,0);
        return ans;
    }
    private void helper(List<List<Integer>> ans,List<Integer> temp,int[] nums,int st){
        ans.add(new ArrayList<>(temp));
        if(st==nums.length){
            return;
        }
        for(int i=st;i<nums.length;i++){
            temp.add(nums[i]);
            helper(ans,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
}