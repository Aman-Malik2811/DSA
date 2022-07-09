class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] pass, int cap) {
        Arrays.sort(buses);
        Arrays.sort(pass);
        Queue<Integer> qt=new ArrayDeque<>();
        Set<Integer> set=new HashSet<>();
        for(int val:pass){qt.add(val);set.add(val);}
        int max=0;
        int st=0,en=pass.length-1;
        for(int bus:buses){
            int temp=cap;
            while(qt.size()>0&&temp>0&&qt.peek()<=bus){
                int x=qt.remove();
                if(!set.contains(x-1))max=x-1;
                temp--;
            }
            if(temp!=0){
                while(set.contains(bus))bus--;
                max=Math.max(max,bus);
            }
        }
        return max;
      
    }
}