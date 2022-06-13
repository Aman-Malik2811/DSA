class Solution {
    public int minimumTotal(List<List<Integer>> tri) {
        int n=tri.size()*(tri.size()+1)/2;
        int[] arr=new int[n+1];
        int id=1;
        for(List<Integer> lev:tri){
            for(int val:lev){
                arr[id++]=val;
            }
        }
        int st=n;
        int lev=tri.size();
        while(st>0){
            int count=lev;

            for(int i=0;i<count;i++){
                arr[st]=lev==tri.size()?arr[st]:arr[st]+Math.min(arr[st+lev],arr[st+lev+1]);
                st--;
            }
            lev--;
        }
       
        return arr[1];
    }
}