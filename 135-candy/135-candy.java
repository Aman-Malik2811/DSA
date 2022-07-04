class Solution {
    public int candy(int[] r) {
       int[] temp=new int[r.length];
       Arrays.fill(temp,1);
       PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
       int i=0;
       int ans=0;
       for(int val:r){pq.add(new int[]{val,i});i++;};
       while(pq.size()>0){
           int[] rem=pq.remove();
           int id=rem[1],a=0,b=0;
           if(id+1<r.length&&r[id+1]<r[id]){
               a=temp[id+1];
           }
           if(id-1>=0&&r[id-1]<r[id]){
               b=temp[id-1];
           }
           temp[id]=Math.max(a,b)+1;
           ans+=temp[id];
       }
       return ans;
    }
}