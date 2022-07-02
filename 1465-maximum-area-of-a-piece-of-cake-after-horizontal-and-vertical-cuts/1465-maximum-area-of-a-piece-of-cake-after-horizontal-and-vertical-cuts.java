class Solution {
    int mod=1000000007;
    public int maxArea(int h, int w, int[] hc, int[] vc) {
        Arrays.sort(hc);
        Arrays.sort(vc);
        int n=vc.length,m=hc.length;
        long maxWidth=w-vc[n-1];
        //System.out.println(maxWidth+" ");
        for(int i=n-2;i>=0;i--){
            maxWidth=Math.max(maxWidth,vc[i+1]-vc[i]);
        }
        long maxHeight=h-hc[m-1];
        //System.out.println(maxHeight);
        for(int i=m-2;i>=0;i--){
            maxHeight=Math.max(maxHeight,hc[i+1]-hc[i]);
        }
        //System.out.println(maxWidth+" "+maxHeight);
        long width=Math.max(maxWidth,vc[0]);
        long height=Math.max(maxHeight,hc[0]);
        long ans=width*height;
        return (int)(ans%mod);
    }
}