class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)sb.append(".");
        for(int i=0;i<n;i++)temp.add(sb.toString());
        helper(ans,temp,n,0);
        return ans;
    }
    private boolean valid(List<String> board,int row,int col){
        //currCol
        for(int i=0;i<row;i++){
            if(board.get(i).charAt(col)=='Q')return false;
        }
        //leftDiagonal
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board.get(i).charAt(j)=='Q')return false;
        }
        //rightDiagonal
        for(int i=row-1,j=col+1;i>=0&&j<board.size();i--,j++){
            if(board.get(i).charAt(j)=='Q')return false;
        }
        return true;
    }
    private void helper(List<List<String>> ans,List<String> board,int n,int row){
        if(row==n){
            ans.add(new ArrayList<>(board));
            return;
        }
        for(int i=0;i<n;i++){
            if(valid(board,row,i)){
                char[] currRow=board.get(row).toCharArray();
                currRow[i]='Q';
                board.set(row,new String(currRow));
                helper(ans,board,n,row+1);
                currRow[i]='.';
                board.set(row,new String(currRow));
            }
        }
    }
   
}