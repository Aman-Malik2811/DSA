class Solution {
    public int findKthLargest(int[] nums, int k) {
        int ans=-1;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            if(i<k){
                pq.add(nums[i]);
            }
            else{
                //System.out.println(pq.peek());
                if(nums[i]>pq.peek()){
                    pq.remove();
                    pq.add(nums[i]);
                }
            }
        }
        return pq.peek();
    }
}