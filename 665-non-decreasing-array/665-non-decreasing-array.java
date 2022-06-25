class Solution {
    public boolean checkPossibility(int[] nums) {
        if(nums.length<=1)return true;
        boolean flag=true;
        int id=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<=nums[i])continue;
            else{
                id=i;
                break;
            }
        }
        //System.out.println(id);
        if(id==0)return true;
        int temp=nums[id];
        int temp2=nums[id-1];
        nums[id]=temp2;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                flag=false;
            }
        }
        if(flag)return true;
        nums[id]=temp;
        nums[id-1]=temp;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1])return false;
        }
        return true;
    }
}