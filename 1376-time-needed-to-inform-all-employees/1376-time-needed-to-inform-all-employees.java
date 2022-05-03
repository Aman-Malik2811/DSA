class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] tree=new ArrayList[n];
        for(int i=0;i<n;i++){
            tree[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            int myManager=manager[i];
            if(myManager!=-1)tree[myManager].add(i);
        }
        return helper(headID,tree,informTime);
    }
    private int helper(int headId,List<Integer>[] tree,int[] infTime){
        if(tree[headId].size()==0)return 0;
        int time=0;
        for(int nbr:tree[headId]){
            time=Math.max(time,helper(nbr,tree,infTime));
        }
        return time+infTime[headId];
    }
}