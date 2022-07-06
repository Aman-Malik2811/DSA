class Solution {
    Map<Integer,Integer> st=new HashMap<>();
    public int fib(int n) {
        if(n==0||n==1)return n;
        if(st.containsKey(n))return st.get(n);
        int val=fib(n-1)+fib(n-2);
        st.put(n,val);
        return val;
    }
}