class Solution {
    public boolean makesquare(int[] arr) {
        Arrays.sort(arr);
        int max=0;
        for(int val:arr)max+=val;
        if(max%4!=0)return false;
        return helper(arr,new int[]{0,0,0,0},arr.length-1,max/4);
    }
    private boolean helper(int[] arr,int[] sides,int i,int max){
        if(i<0){
            if(sides[0]==sides[1]&&sides[1]==sides[2]&&sides[2]==sides[3]){
                return true;
            }
            return false;
        }
        for(int c=0;c<4;c++){
            sides[c]+=arr[i];
            if(sides[c]<=max&&helper(arr,sides,i-1,max)){
                return true;
            }
            sides[c]-=arr[i];
        }
        return false;
    }
}