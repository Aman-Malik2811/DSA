class Solution {
    Map<Integer,List<Character>> map;
    public List<String> letterCombinations(String digits) {
        map=new HashMap<>();
        char ch='a';
        for(int i=2;i<7;i++){
            List<Character> temp=map.getOrDefault(i,new ArrayList<>());
            temp.add((char)(ch+0));
            temp.add((char)(ch+1));
            temp.add((char)(ch+2));
            map.put(i,temp);
            ch=(char)(ch+3);
        }
        map.put(7,new ArrayList<>(Arrays.asList('p','q','r','s')));
        map.put(8,new ArrayList<>(Arrays.asList('t','u','v')));
        map.put(9,new ArrayList<>(Arrays.asList('w','x','y','z')));
        List<String> ans=new ArrayList<>();
        helper(ans,digits,0,new StringBuilder());
        return ans;
    }
    private void helper(List<String> ans,String curr,int id,StringBuilder sb){
        if(id==curr.length()){
            if(sb.length()>0)ans.add(sb.toString());
            return;
        }
        List<Character> temp=map.get(curr.charAt(id)-'0');
        for(char ch:temp){
            sb.append(ch);
            helper(ans,curr,id+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}