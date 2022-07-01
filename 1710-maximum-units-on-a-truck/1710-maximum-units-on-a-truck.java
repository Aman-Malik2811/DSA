class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
       Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
       int ans=0;
       int i=0;
       
       while(truckSize>0&&i<boxTypes.length){
           int box=boxTypes[i][0];
           int units=boxTypes[i][1];
           if(box<=truckSize){
               ans+=box*units;
               truckSize-=box;
           }
           else{
               ans+=truckSize*units;
               break;
           }
           i++;
       }
        return ans;
    }
}