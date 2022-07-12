class Solution {
    public boolean makesquare(int[] arr) {
        int max=0;
        for(int val:arr)max+=val;
        Arrays.sort(arr);
        int i=0,j=arr.length-1;
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        if(max%4!=0)return false;
        return helper(arr,new int[]{0,0,0,0},0,max/4);
    }
    private boolean helper(int[] arr,int[] sides,int i,int max){
        if(i==arr.length){
            if(sides[0]==sides[1]&&sides[1]==sides[2]&&sides[2]==sides[3]){
                return true;
            }
            return false;
        }
        for(int c=0;c<4;c++){
            sides[c]+=arr[i];
            if(sides[c]<=max&&helper(arr,sides,i+1,max)){
                return true;
            }
            sides[c]-=arr[i];
        }
        return false;
    }
}