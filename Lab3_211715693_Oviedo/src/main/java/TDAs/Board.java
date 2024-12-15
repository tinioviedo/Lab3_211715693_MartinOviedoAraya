package TDAs;

public class Board {
    private int[][] board;

    /**
     * Constructor Board
     */
    public Board(){
        board = new int[6][7];
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                board[i][j] = 0;
            }
        }
    }

    //metodos
    //getter
    public int[][] getBoard() {
        return board;
    }

}
