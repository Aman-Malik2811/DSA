class Solution {
    public boolean find132pattern(int[] nums) {
        //Find for every i except i=0 and i=nums.length-1;
          //1->Max of every smallest value to right
          //2->Min of every smallest value to left
          //If for any i nums[i]>right and nums[i]>left and right>left return true;
          // else return false;
        int n=nums.length;
        int[] left=new int[n];
        left[0]=nums[0];
        for(int i=1;i<n-1;i++){
            left[i]=Math.min(left[i-1],nums[i-1]);
        }
        Stack<Integer> st=new Stack<>();
        st.push(nums[n-1]);
        for(int i=n-2;i>=1;i--){
            int temp=Integer.MIN_VALUE;
            while(st.size()>0&&nums[i]>st.peek()){
                temp=Math.max(temp,st.pop());
            }
            if(temp==Integer.MIN_VALUE){
                st.push(nums[i]);
                continue;
            }
            else{
                if(temp>left[i]&&nums[i]>left[i])return true;
            }
            st.push(nums[i]);
        }
        return false;
    }
}