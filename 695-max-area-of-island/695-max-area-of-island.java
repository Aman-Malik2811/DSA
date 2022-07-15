class Solution {
   public int maxAreaOfIsland(int[][] grid) {
    int max=0;    
      for(int i=0; i<grid.length;i++ )
        for(int j=0; j<grid[0].length;j++ )
            max= Math.max( max, calculate(grid,i,j) );   
    
    return max;
    }
    
    public static int calculate(int grid[][],int i, int j)
    {
        if( i<0 || j<0 || i>= grid.length || j>= grid[0].length ||  grid[i][j]== 0 )
            return 0;
        
        grid[i][j]=0;
         return  1 + calculate(grid,i+1,j) + calculate(grid,i-1,j) + calculate(grid,i,j+1) +calculate(grid,i,j-1);
        
    }
}