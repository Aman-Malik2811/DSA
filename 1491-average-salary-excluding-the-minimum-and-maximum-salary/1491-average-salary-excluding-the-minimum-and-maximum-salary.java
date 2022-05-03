class Solution {
    public double average(int[] salary) {
        double sum=0,min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int val:salary){
            sum+=val;
            min=Math.min(val,min);
            max=Math.max(val,max);
        }
        sum-=(min+max);
        return sum/(salary.length-2);
    }
}