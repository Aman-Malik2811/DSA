class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    ans=Math.max(ans,helper(grid,i,j));
                }
            }
        }
        return ans;
    }
    private int helper(int[][] grid,int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0||grid[i][j]==2)return 0;
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        int ans=grid[i][j]==1?1:0;
        for(int[] dir:dirs){
            int nx=i+dir[0];
            int ny=j+dir[1];
            int temp=grid[i][j];
            grid[i][j]=2;
            ans+=helper(grid,nx,ny);
        }
        return ans;
    }
}