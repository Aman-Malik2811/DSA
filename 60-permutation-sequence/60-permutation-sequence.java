class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb=new StringBuilder();
        long fact=1;
        for(int i=1;i<=n;i++){sb.append(i);fact*=i;}
        int range= (int)fact/n;
        StringBuilder ans=new StringBuilder();
        while(sb.length()>2){
            int id=k%range==0?k/range-1:k/range;
            ans.append(sb.charAt(id));
            sb.delete(id,id+1);
            k=k%range==0?range:k%range;
            range=range/(n-1);
            n--;
        }
        ans.append(k%2==1?sb:sb.reverse().toString());
        return ans.toString();
    }
}