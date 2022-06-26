class Solution {
    public int minJumps(int[] arr) {
        int n=arr.length;
        Map<Integer,List<Integer>> graph=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(graph.containsKey(arr[i])){
                List<Integer> temp=graph.get(arr[i]);
                temp.add(i);
                graph.put(arr[i],temp);
            }
            else{
                List<Integer> list=new ArrayList<>();
                list.add(i);
                graph.put(arr[i],list);
            }
        }
        List<Integer> curr=new ArrayList<>();
        curr.add(0);
        int step=0;
        Set<Integer> visited=new HashSet<>();
        while(!curr.isEmpty()){
            int count=curr.size();
            List<Integer> next=new ArrayList<>();
            for(int i=0;i<count;i++){
                int node=curr.get(i);
                if(node==n-1)return step;
                for(int nbr:graph.get(arr[node])){
                    if(!visited.contains(nbr)){
                        visited.add(nbr);
                        next.add(nbr);
                    }
                }
                graph.get(arr[node]).clear();
                if(node-1>=0&&!visited.contains(node-1)){
                    visited.add(node-1);
                    next.add(node-1);
                }
                if(node+1<n&&!visited.contains(node+1)){
                    visited.add(node+1);
                    next.add(node+1);
                }
            }
            step++;
            curr=next;
        }
        return -1;
    }
}