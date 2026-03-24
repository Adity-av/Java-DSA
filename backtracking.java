import java.util.*;
public class backtracking {
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void changeArr(int arr[],int i,int val){
        if(i==arr.length){
            printArr(arr);
            System.out.println();
            return;
        }
        arr[i]=val;
        changeArr(arr, i+1, val+1);
        arr[i]=arr[i]-2;
    }
    public static void printSubsets(String s,int i,StringBuilder str){
        if(i==s.length()){
            System.out.println(str);
            return;
        }
        printSubsets(s,i+1,str.append(s.charAt(i)));
        // str.deleteCharAt(str.length()-1);
        printSubsets(s,i+1,str);
    }
    public static void printPermutations(String s,String ans){
        if(s.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            String newStr=s.substring(0, i)+s.substring(i+1);
            printPermutations(newStr, ans+curr);
        }
    }
    // public static boolean isSafe(char board[][],int row,int col){//for nQueens
    //     //vertically up
    //     for(int i=row-1;i>=0;i--){
    //         if(board[i][col]=='Q'){
    //             return false;
    //         }
    //     }
    //     //diag left up
    //     for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
    //         if(board[i][j]=='Q'){
    //             return false;
    //         }
    //     }
    //     //diag right up
    //     for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
    //         if(board[i][j]=='Q'){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    // public static void nQueens(char board[][],int row){
    //     if(row==board.length){
    //         printBoard(board);
    //         count++;
    //         return;
    //     }
    //     for(int j=0;j<board.length;j++){
    //         if(isSafe(board,row,j)){
    //             board[row][j]='Q';
    //             nQueens(board, row+1);
    //             board[row][j]='.';//backtracking step
    //         }
    //     }
    // }

    // public static void printBoard(char board[][]){
    //     System.out.println("------------chess board--------------");
    //     for(int i=0;i<board.length;i++){
    //         for(int j=0;j<board.length;j++){
    //             System.out.print(board[i][j]+" ");
    //         }
    //         System.out.println();
    //     }
    // }

    // static int count=0;

    public static int gridWays(int i,int j,int n,int m){
        if(i==n-1 &&j==m-1){//condition for last cell
            return 1;
        }else if(i==n || j==m){
            return 0;
        }
        int w1=gridWays( i+1, j, n, m);
        int w2=gridWays( i, j+1, n, m);
        return w1+w2;
    }

    public static boolean sudokuSolver(int sudoku[][],int row,int col){
        //base case
        if(row==9){
            return true;
        }
        //recursion
        int nextRow=row,nextCol=col+1;
        if(col+1==9){
            nextRow=row+1;
            nextCol=0;
        }
        if(sudoku[row][col]!=0){
            return sudokuSolver(sudoku, nextRow, nextCol);
        }
        for(int digit=1;digit<=9;digit++){
            if(isSafe(sudoku,row,col,digit)){
                sudoku[row][col]=digit;
                if(sudokuSolver(sudoku, nextRow, nextCol)){//solution exists
                    return true;
                }
                sudoku[row][col]=0;
            }
        }
        return false;
    }

    public static boolean isSafe(int sudoku[][],int row,int col,int digit){
        //column
        for(int i=0;i<=8;i++){
            if(sudoku[i][col]==digit){
                return false;
            }
        }
        //row
        for(int j=0;j<=8;j++){
            if(sudoku[row][j]==digit){
                return false;
            }
        }
        //grid
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        //3x3 grid
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }
        
        return true;
        
    }
    public static void printSudoku(int sudoku[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudoku[i][j]+"  ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        // int arr[]=new int[5];
        // changeArr(arr,0,1);
        // printArr(arr);
        // String s="abc";
        // // printSubsets(s,0,new StringBuilder());
        // printPermutations(s,"");


        // int n=4;
        // char board[][]=new char[n][n];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         board[i][j]='.';
        //     }
        // }
        // nQueens(board,0);
        // System.out.println(count);

        // int n=3,m=3;
        // System.out.println(gridWays(0,0,n,m));

        int sudoku[][]={{0,0,8,0,0,0,0,0,0},
        {4,9,0,1,5,7,0,0,2},
        {0,0,3,0,0,4,1,9,0},
        {1,8,5,0,6,0,0,2,0},
        {0,0,0,0,2,0,0,6,0},
        {9,6,0,4,0,5,3,0,0},
        {0,3,0,0,7,2,0,0,4},
        {0,4,9,0,3,0,0,5,7},
        {8,2,7,0,0,9,0,1,3}
        };
        if(sudokuSolver(sudoku, 0, 0)){
            System.out.println("Solution exists");
            printSudoku(sudoku);
        }else{
            System.out.println("Solution does not exists");
        }
    }
}