class Solution {
    public String removeDuplicates(String s, int k) {
        char[] ans=s.toCharArray();
        int[] count=new int[s.length()];
        int i=0;
        for(int j=0;j<s.length();j++,i++){
            ans[i]=s.charAt(j);
            count[i]=i>0&&ans[i]==ans[i-1]?count[i-1]+1:1;
            if(count[i]==k){
                i-=k;
            }
        }
        return new String(ans,0,i);
    }
}