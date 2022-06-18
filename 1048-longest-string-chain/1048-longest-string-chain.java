class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        Map<String,Integer> map=new HashMap<>();
        for(String word:words){
            //System.out.println(word);
            map.put(word,1);
        }
        int ans=0;
        for(int i=0;i<words.length;i++){
            String curr=words[i];
            int temp=0;
            for(int j=0;j<curr.length();j++){
                int t=0;
                String str=curr.substring(0,j)+curr.substring(j+1);
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