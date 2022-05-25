class Solution {
    public int maxEnvelopes(int[][] env) {
        Arrays.sort(env,(a,b)->a[0]!=b[0]?a[0]-b[0]:b[1]-a[1]);
        int ans=Integer.MIN_VALUE;
        List<int[]> doll=new ArrayList<>();
        for(int[] en:env){
            int i=0,j=doll.size();
            if(doll.size()==0||valid(doll,en)){
                doll.add(en);
                continue;
            }
            while(i!=j){
                int mid=(i+j)/2;
                int[] curr=doll.get(mid);
                if(curr[1]>=en[1]){
                    j=mid;
                }
                else{
                    i=mid+1;
                }
            }
            doll.set(i,en);
        }
        return doll.size();
    }
    private boolean valid(List<int[]> doll,int[] en){
        int[] last=doll.get(doll.size()-1);
        return last[0]<en[0]&&last[1]<en[1];
    }
}