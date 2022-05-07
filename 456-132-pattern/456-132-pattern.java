class Solution {
    public boolean find132pattern(int[] nums) {
        //Find for every i except i=0 and i=nums.length-1;
          //1->Max of every smallest value to right
          //2->Min of every smallest value to left
          //If for any i nums[i]>right and nums[i]>left and right>left return true;
          // else return false;
        Stack <Integer> stack = new Stack ();
        int second = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums [i] < second)
                return true;
            while (!stack.isEmpty() && nums [i] > stack.peek ())
                second = stack.pop ();
            stack.push (nums [i]);
        }
        return false;
    }
}