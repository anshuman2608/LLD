public class Board {
    private int row;
    private int col;

    private String[][] board;

    public Board(int row,int col){
        this.row=row;
        this.col=col;
        this.board=new String[row][col];

    }

    public void initializeBoard(){

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                board[i][j]=" ";
            }
        }
    }

    public void printBoard(){


        for(int i=0;i<row;i++){

            System.out.println("-------");
            System.out.print("|");

            for(int j=0;j<col;j++){
                System.out.print(board[i][j]+"|");
            }
            System.out.println();

        }
        System.out.println("-------");
    }

    public boolean haveWon(String p){

        //cheek all rows for winning condition

        for(int i=0;i<row;i++){
            if(board[i][0]==p && board[i][1]==p && board[i][2]==p){
                return true;
            }
        }

        //cheek all col for winning condition

        for(int i=0;i<col;i++){
            if(board[0][i]==p && board[1][i]==p && board[2][i]==p){
                return true;
            }
        }

        //cheek for both diagonal conditioin
        if(board[0][0]==p  &&  board[1][1]==p  &&  board[2][2]==p){

            return true;
        }

        if(board[2][1]==p && board[1][1]==p && board[2][2]==p){

            return true;
        }

        return false;
    }

}
