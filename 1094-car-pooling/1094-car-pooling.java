class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] fill=new int[1001];
        for(int[] trip:trips){
            int st=trip[1];
            int en=trip[2];
            int num=trip[0];
            fill[st]+=num;
            fill[en]-=num;
        }
        int curr=0;
        for(int i=0;i<fill.length;i++){
            curr+=fill[i];
            if(curr>capacity)return false;
        }
        return true;
    }
}