class Solution {
    int count=0;
    public int totalNQueens(int n) {
        List<String> temp=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)sb.append(".");
        for(int i=0;i<n;i++)temp.add(sb.toString());
        boolean[] col=new boolean[n];
        boolean[] upLeftDiag=new boolean[2*n-1];
        boolean[] upRightDiag=new boolean[2*n-1];
        helper(temp,n,0,col,upLeftDiag,upRightDiag);
        return count;
    }
   // // private boolean valid(List<String> board,int row,int col){
   //      //currCol
   //      for(int i=0;i<row;i++){
   //          if(board.get(i).charAt(col)=='Q')return false;
   //      }
   //      //leftDiagonal
   //      for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
   //          if(board.get(i).charAt(j)=='Q')return false;
   //      }
   //      //rightDiagonal
   //      for(int i=row-1,j=col+1;i>=0&&j<board.size();i--,j++){
   //          if(board.get(i).charAt(j)=='Q')return false;
   //      }
   //      return true;
   //  }
    private void helper(List<String> board,int n,int row,boolean[] col,boolean[] left,boolean[] right){
        if(row==n){
            count++;
            return;
        }
        for(int i=0;i<n;i++){
            if(!col[i]&&!left[i+row]&&!right[row+n-i-1]){
                char[] currRow=board.get(row).toCharArray();
                currRow[i]='Q';
                board.set(row,new String(currRow));
                col[i]=true;
                left[i+row]=true;
                right[row+n-i-1]=true;
                helper(board,n,row+1,col,left,right);
                col[i]=false;
                left[i+row]=false;
                right[row+n-i-1]=false;
                currRow[i]='.';
                board.set(row,new String(currRow));
            }
        }
    }
}