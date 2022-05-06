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
        Arrays.sort(worker);
        int ans=0,i=0,temp=0;
        for(int emp:worker){
            while(i<jobs.length&&jobs[i].diff<=emp){
                temp=Math.max(temp,jobs[i].pro);
                i++;
            }
            ans+=temp;
        }
        return ans;
    }
}