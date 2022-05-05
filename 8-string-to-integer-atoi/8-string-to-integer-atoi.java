class Solution {
    public int myAtoi(String s) {
        Stack<Character> st=new Stack<>();
        long ans=0;
        s=s.trim();
        if(s.length()==0)return 0;
        if(s.length()==1)return Character.isDigit(s.charAt(0))?s.charAt(0)-'0':0; if(!Character.isDigit(s.charAt(0))&&!Character.isDigit(s.charAt(1)))return 0;
        for(int i=0;i<s.length();i++){
           
            char ch=s.charAt(i);
            if(ch=='+'||ch=='-')continue;
            while(i<s.length()&&s.charAt(i)-'0'==0){
                i++;
            }
            while(i<s.length()&&Character.isDigit(s.charAt(i))){
               
                int val=s.charAt(i)-'0';
                ans=ans*10+val;
                if(ans>Integer.MAX_VALUE)return s.charAt(0)=='-'?Integer.MIN_VALUE:Integer.MAX_VALUE;
                i++;
            }
            break;
        }
        return s.charAt(0)=='-'?-1*(int)ans:(int)ans;
    }
}
