class Solution {
    public List<Integer> getRow(int rowIndex) {
      return generate(rowIndex+1).get(rowIndex);
    }
   public List<List<Integer>> generate(int rows) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        curr.add(1);
        ans.add(curr);
        for(int i=1;i<rows;i++){
            List<Integer> temp=new ArrayList<>();
            temp.add(1);
            for(int j=0;j<ans.get(i-1).size()-1;j++){
                temp.add(ans.get(i-1).get(j)+ans.get(i-1).get(j+1));
            }
            temp.add(1);
            ans.add(temp);
        }
        return ans;
    }
}