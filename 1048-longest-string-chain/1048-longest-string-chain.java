class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        Map<String,Integer> map=new HashMap<>();
        int ans=0;
        for(int i=0;i<words.length;i++){
            String curr=words[i];
            map.put(curr,1);
            for(int j=0;j<curr.length();j++){
                
                StringBuilder st = new StringBuilder(curr);
                String str = st.deleteCharAt(j).toString();
                if(map.containsKey(str)&&map.get(str)+1>map.get(curr)){
                    map.put(curr,map.get(str)+1);
                }
            
            }
           ans=Math.max(ans,map.get(curr));
        }
        //System.out.println(map);
        return ans;
    }
}