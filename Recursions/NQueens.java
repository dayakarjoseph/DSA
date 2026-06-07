import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    public static boolean isSafe(int row,int col,char board[][],int n){
        for(int j=0;j<col;j++){
            if(board[row][j] == 'Q') return false;
        }
        for (int i=row,j=col;j>=0&&i>=0;j--,i--) {
            if(board[i][j] == 'Q') return false;
        }
        for(int i=row,j=col;j>=0&&i<n;i++,j--){
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }

    public static void solve(List<List<String>> ans,char board[][],int n,int col){
        if(col == n){
            List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        for(int row = 0;row<n;row++){
            if(isSafe(row,col,board,n)){
                board[row][col] = 'Q';
                solve(ans, board, n, col+1);
                board[row][col] = '.';
            }
        }
    }
    public static List<List<String>> solveNQueens(int n,char board[][]){
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            Arrays.fill(board[i], '.');
        }
        solve(ans,board,n,0);
        return ans;
    }
    

    // OPTIMIZED
    public static List<List<String>> solveNQueens2(int n) {
        List<List<String>> ans = new ArrayList<>();
        char board[][] = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        int leftRow[] = new int[n];
        int lowerDiagnol[] = new int[2*n-1];
        int upperDiagnol[] = new int[2*n-1];
        solve(ans,board,leftRow,lowerDiagnol,upperDiagnol,0,n);
        return ans;
    }
    public static void solve(List<List<String>> ans,char board[][],int leftRow[],int lowerDiagnol[],int upperDiagnol[],int col,int n){
        if(col == n){
            List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        for(int row = 0;row<n;row++){
            if(leftRow[row] == 0 && lowerDiagnol[row+col] == 0 && upperDiagnol[(n-1)+(col-row)]==0){
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagnol[row+col] = 1;
                upperDiagnol[(n-1)+(col-row)]=1;
                solve(ans,board,leftRow,lowerDiagnol,upperDiagnol,col+1,n);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagnol[row+col] = 0;
                upperDiagnol[(n-1)+(col-row)]=0;
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];
        List<List<String>> ans = solveNQueens(n, board);
        for(List<String> row : ans){
            for(String place : row){
                for(int j=0;j<place.length();j++){
                    System.out.print(place.charAt(j) + "   ");
                }
                System.out.println();
            }
            System.out.println();
        }

    }
}
