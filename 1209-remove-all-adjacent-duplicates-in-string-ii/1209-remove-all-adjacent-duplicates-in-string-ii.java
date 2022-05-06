class Solution {
    class Pair{
        char ch;
        int freq;
        Pair(char ch,int freq){
            this.ch=ch;
            this.freq=freq;
        }
    }
    public String removeDuplicates(String s, int k) {
        //Create a stack
        //Curr char and its consequent frequency
        //if top elements consequent frequency==k
        //if same as top then put same,top.fre+1;
        //else put curr,1;
        Stack<Pair> st=new Stack<>();
        st.push(new Pair(s.charAt(0),1));
        for(int i=1;i<s.length();i++){
            Pair top=st.peek();
            if(top.freq==k){
                while(st.size()>0&&st.peek().ch==top.ch){
                    st.pop();
                }
            }
            if(st.size()>0&&s.charAt(i)==st.peek().ch){
                st.push(new Pair(s.charAt(i),st.peek().freq+1));
            }
            else{
                st.push(new Pair(s.charAt(i),1));
            }
        }
        char ch=st.peek().ch;
        if(st.size()>0&&st.peek().freq==k)while(st.size()>0&&st.peek().ch==ch){st.pop();}
        StringBuilder sb=new StringBuilder();
        while(st.size()>0){
            sb.append(st.pop().ch);
        }
        return sb.reverse().toString();
    }
}