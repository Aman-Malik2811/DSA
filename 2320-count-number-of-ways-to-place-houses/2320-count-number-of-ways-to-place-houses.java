class Solution {
    long mod=1000000007;
   
    public int countHousePlacements(int n) {
        long fib1=1;
        long fib2=1;
        long ans=fib1+fib2;
        for(int i=2;i<=n;i++){
            fib1=fib2;
            fib2=ans;
            ans=(fib1+fib2)%mod;
        }
        return (int)((ans*ans)%mod);
    }
}