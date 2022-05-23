class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int x=nums1.length;
        int y=nums2.length;
        int low=0;
        int high=x;
        while(low<=high){
            int px=(low+high)/2;
            int py=(x+y+1)/2-px;
            
            int xmax=px==0?Integer.MIN_VALUE:nums1[px-1];
            int xmin=px==x?Integer.MAX_VALUE:nums1[px];
            
            int ymax=py==0?Integer.MIN_VALUE:nums2[py-1];
            int ymin=py==y?Integer.MAX_VALUE:nums2[py];
            
            if(xmax<=ymin&&ymax<=xmin){
                if((x+y)%2==0){
                    return ((double)(Math.max(xmax,ymax)+Math.min(xmin,ymin))/2);
                }
                else{
                    return Math.max(xmax,ymax);
                }
            }
            else if(xmax>ymin){
                high=px-1;
            }
            else{
                low=px+1;
            }
        }
        throw new IllegalArgumentException();
    }
}