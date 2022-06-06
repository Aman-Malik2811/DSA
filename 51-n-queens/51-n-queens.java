class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(".");
            }
            temp.add(sb.toString());
        }
        helper(ans,temp,new boolean[n][n],0);
        return ans;
    }
    private void helper(List<List<String>> ans,List<String> temp,boolean[][] board,int row){
        if(row==board.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<board.length;i++){
            if(valid(board,row,i)){
               char[] curr=temp.get(row).toCharArray();
               curr[i]='Q';
               temp.set(row,new String(curr));
                board[row][i]=true;
               helper(ans,temp,board,row+1);
                board[row][i]=false;
               curr[i]='.';
               temp.set(row,new String(curr));
            }
        } 
    }
    private boolean valid(boolean[][] board,int row,int col){
        int temp=row;
        for(int i=0;i<row;i++){
            if(board[i][col])return false;
        }
        row--;
        for(int i=col-1;i>=0&&row>=0;i--){
            if(board[row][i])return false;
            row--;
        }
        row=temp-1;
        for(int i=col+1;i<board.length&&row>=0;i++){
            if(board[row][i])return false;
            row--;
        }
        return true;
    }
}