class Solution {
    public long maximumImportance(int n, int[][] roads) {
        List<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] road:roads){
            int st=road[0];
            int end=road[1];
            graph[st].add(end);
            graph[end].add(st);
        }
        Arrays.sort(graph,(a,b)->b.size()-a.size());
        long ans=0;
        long val=n;
        for(int i=0;i<n;i++){
            ans+=graph[i].size()*val;
            val--;
        }
        return ans;
    }
}