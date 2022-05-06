class Solution {
    class Pair{
        int diff;
        int pro;
        Pair(int di,int pr){
            this.diff=di;
            this.pro=pr;
        }
    }
    public int maxProfitAssignment(int[] difficult, int[] profit, int[] worker) {
        Pair[] jobs=new Pair[profit.length];
        for(int i=0;i<profit.length;i++){
            jobs[i]=new Pair(difficult[i],profit[i]);
        }
        Arrays.sort(jobs,(j1,j2)->j1.diff-j2.diff);
        int[] maxProfit=new int[jobs.length];
        maxProfit[0]=jobs[0].pro;
        for(int i=1;i<jobs.length;i++){
            maxProfit[i]=Math.max(jobs[i].pro,maxProfit[i-1]);
        }
       
        int ans=0;
        for(int emp:worker){
            int i=0,j=jobs.length-1;
            int temp=-1;
            while(i<=j){
                int mid=i+(j-i)/2;
                if(jobs[mid].diff>emp){
                    j=mid-1;
                }
                else{
                    while(mid<jobs.length&&jobs[mid].diff<=emp){
                        temp=mid;
                        mid++;
                    }
                    break;
                }
            }
            ans+=temp>=0?maxProfit[temp]:0;
        }
        return ans;
    }
}