class Solution {
    public String removeDuplicates(String s, int k) {
        char[] result=s.toCharArray();
        int[] count=new int[s.length()];
        int i=0;
        for(char ch:s.toCharArray()){
            result[i]=ch;
            count[i]=i>0&&result[i-1]==ch?count[i-1]+1:1;
            if(count[i]==k)i-=k;
            i++;
        }
        return new String(result,0,i);
    }
}