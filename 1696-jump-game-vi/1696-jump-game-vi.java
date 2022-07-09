class Solution {
    int[] dp;
    public int maxResult(int[] nums, int k) {
        dp=new int[nums.length];
        Arrays.fill(dp,Integer.MIN_VALUE);
        int n=nums.length;
        dp[n-1]=nums[n-1];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        pq.add(new int[]{dp[n-1],n-1});
        for(int i=n-2;i>=0;i--){
            int temp=Integer.MIN_VALUE;
            while(pq.peek()[1]>Math.min(n-1,i+k))pq.remove();
            temp=Math.max(temp,pq.peek()[0]);
            dp[i]=temp+nums[i];
            pq.add(new int[]{dp[i],i});
        }
        return dp[0];
    }
}