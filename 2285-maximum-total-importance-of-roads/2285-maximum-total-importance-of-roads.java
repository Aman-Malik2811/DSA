class Solution {
    public long maximumImportance(int n, int[][] roads) {
       int[] deg=new int[n];
        for(int[] road:roads){
            int st=road[0];
            int end=road[1];
            deg[st]++;
            deg[end]++;
        }
        Arrays.sort(deg);
        long ans=0;
        long val=n;
        for(int i=n-1;i>=0;i--){
            ans+=deg[i]*val;
            val--;
        }
        return ans;
    }
}