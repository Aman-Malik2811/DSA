class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        Arrays.sort(nums);
        helper(ans,new ArrayList<>(),nums,visited);
        return ans;
    }
    private void helper(List<List<Integer>> ans,List<Integer> temp,int[] nums,boolean[] visited){
        if(temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]||(i-1>=0&&nums[i-1]==nums[i]&&!visited[i-1]))continue;
            visited[i]=true;
            temp.add(nums[i]);
            helper(ans,temp,nums,visited);
            temp.remove(temp.size()-1);
            visited[i]=false;
        }
    }
}