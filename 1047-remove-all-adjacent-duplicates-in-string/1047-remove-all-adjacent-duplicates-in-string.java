class Solution {
class Pair{
        char ch;
        int freq;
        Pair(char ch,int freq){
            this.ch=ch;
            this.freq=freq;
        }
    }
    public String removeDuplicates(String s) {
        //Create a stack
        //Curr char and its consequent frequency
        //if top elements consequent frequency==k
        //if same as top then put same,top.fre+1;
        //else put curr,1;
        int k=2;
        Stack<Pair> st=new Stack<>();
        st.push(new Pair(s.charAt(0),1));
        for(int i=1;i<s.length();i++){ 
            if(st.size()>0&&s.charAt(i)==st.peek().ch){
                st.peek().freq++;
            }
            else{
                st.push(new Pair(s.charAt(i),1));
            }
            Pair top=st.peek();
            if(top.freq==k){
                st.pop();
            }
        }
        
        StringBuilder sb=new StringBuilder();
        while(st.size()>0){
           Pair top=st.pop();
            while(top.freq-->0)sb.append(top.ch);
        }
        return sb.reverse().toString();
    }
}