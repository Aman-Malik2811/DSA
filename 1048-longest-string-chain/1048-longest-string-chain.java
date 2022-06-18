class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        Map<String,Integer> map=new HashMap<>();
        int ans=0;
        for(int i=0;i<words.length;i++){
            String curr=words[i];
            int temp=0;
            for(int j=0;j<curr.length();j++){
                int t=0;
                StringBuilder st = new StringBuilder(curr);
                String str = st.deleteCharAt(j).toString();
                if(map.containsKey(str)){
                    t+=map.get(str);
                }
                temp=Math.max(t,temp);
            }
            map.put(curr,temp+1);
            ans=Math.max(ans,temp+1);
        }
        //System.out.println(map);
        return ans;
    }
}