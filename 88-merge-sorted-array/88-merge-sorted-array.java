class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans=new int[m+n];
        int i=0,j=0,k=0;
        while(i<m&&j<n){
            if(nums1[i]>nums2[j]){
                ans[k++]=nums2[j++];
            }
            else{
                ans[k++]=nums1[i++];
            }
        }
        while(i<m){
            ans[k++]=nums1[i++];
        }
        while(j<n){
            ans[k++]=nums2[j++];
        }
       
        for(i=0;i<m+n;i++){
            nums1[i]=ans[i];
        }
    }
}