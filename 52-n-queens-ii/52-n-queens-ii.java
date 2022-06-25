class Solution {
    int count=0;
    public int totalNQueens(int n) {
        List<String> temp=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)sb.append(".");
        for(int i=0;i<n;i++)temp.add(sb.toString());
        helper(temp,n,0);
        return count;
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
    private void helper(List<String> board,int n,int row){
        if(row==n){
            count++;
            return;
        }
        for(int i=0;i<n;i++){
            if(valid(board,row,i)){
                char[] currRow=board.get(row).toCharArray();
                currRow[i]='Q';
                board.set(row,new String(currRow));
                helper(board,n,row+1);
                currRow[i]='.';
                board.set(row,new String(currRow));
            }
        }
    }
}