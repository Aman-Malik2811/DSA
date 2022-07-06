class Solution {
    public void nextPermutation(int[] nums) {
       int j=nums.length-1;
       while(j>=1&&nums[j-1]>=nums[j])j--;
       if(j==0){
           reverse(nums,j,nums.length-1);
       }
       else{
           int id=j-1;
           int en=nums.length-1;
           while(en>=id&&nums[id]>=nums[en])en--;
           swap(nums,id,en);
           reverse(nums,j,nums.length-1);
       }
    
    }
    private void reverse(int[] nums,int st,int en){
        while(st<en){
            swap(nums,st,en);
            st++;
            en--;
        }
    }
    private void swap(int[] nums,int st,int en){
        int temp=nums[st];
        nums[st]=nums[en];
        nums[en]=temp;
    }
}





































 // int idx=nums.length-1;
 //        for(int i=nums.length-2;i>=0;i--){
 //            if(nums[i]>=nums[i+1])continue;
 //            else{
 //                idx=i;
 //                break;
 //            }
 //        }
 //        if(idx==nums.length-1){
 //            int i=0,j=nums.length-1;
 //            while(i<j){
 //                swap(nums,i,j);
 //                i++;
 //                j--;
 //            }
 //        }
 //        int en=nums.length-1;
 //        while(en>idx){
 //            if(nums[en]>nums[idx]){
 //                swap(nums,en,idx);
 //                break;
 //            }
 //            en--;
 //        }
 //        int st=idx+1,end=nums.length-1;
 //        while(st<end){
 //            swap(nums,st,end);
 //            st++;
 //            end--;
 //        }