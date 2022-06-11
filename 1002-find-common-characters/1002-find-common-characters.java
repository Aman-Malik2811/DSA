class Solution {
    public List<String> commonChars(String[] arr) {
         List<String> ans=new ArrayList<>();
        Set<Character> st=new HashSet<>();
        for(char curr:arr[0].toCharArray()){
            int org=0;
            boolean flag=true;
            if(st.contains(curr)){continue;}
            st.add(curr);
            for(char ch:arr[0].toCharArray()){
                if(curr==ch)org++;
            }
            for(int j=1;j<arr.length;j++){
                String str=arr[j];
                int count=0;
                for(char ch:str.toCharArray()){
                    if(curr==ch){
                        count++;
                    }
                }
                if(count==0&&org!=0){
                    flag=false;
                    break;
                }
                org=Math.min(org,count);
                
            }
            if(flag){
               while(org-->0) ans.add(curr+"");
            }
        }
       return ans;
    

    }
}