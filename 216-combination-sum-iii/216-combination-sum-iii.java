class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(ans,new ArrayList<>(),n,k,1);
        return ans;
    }
    private void helper(List<List<Integer>> ans,List<Integer> temp,int tar,int left,int st){
        if(left==0){
            if(tar==0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        for(int i=st;i<=9;i++){
            if(i>tar)continue;
         //   helper(ans,temp,tar,left,i+1);
            temp.add(i);
            helper(ans,temp,tar-i,left-1,i+1);
            temp.remove(temp.size()-1);
        }
    }
}