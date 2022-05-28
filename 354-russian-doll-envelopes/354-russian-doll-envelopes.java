class Solution {
    public int maxEnvelopes(int[][] env) {
        if(env==null||env.length==0)return 0;
        Arrays.sort(env,(a,b)->a[0]!=b[0]?(a[0]-b[0]):(b[1]-a[1]));
        List<int[]> doll=new ArrayList<>();
        for(int i=0;i<env.length;i++){
            if(doll.size()==0||valid(doll,env[i])){
                doll.add(env[i]);
                continue;
            }
            int st=0,en=doll.size();
            while(st!=en){
                int mid=(st+en)/2;
                int[] last=doll.get(mid);
                if(last[1]>=env[i][1]){
                    en=mid;
                }
                else{
                    st=mid+1;
                }
            }
            doll.set(st,env[i]);
        }
        return doll.size();
    }
     private boolean valid(List<int[]> doll,int[] en){
        int[] last=doll.get(doll.size()-1);
        return last[0]<en[0]&&last[1]<en[1];
    }
}