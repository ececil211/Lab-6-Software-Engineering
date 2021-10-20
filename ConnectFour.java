import java.util.Scanner;
//Ethan Cecil's push to git hub repository
public class ConnectFour {
    public static void main (String[] args){
        //Initializes all objects and establishes length and height of board
        Scanner scnr = new java.util.Scanner(System.in);
        System.out.print("What would you like the height of the board to be? ");
        int boardHeight = scnr.nextInt();
        System.out.print("What would you like the length of the board to be? ");
        int boardLength = scnr.nextInt();
        char[][] board = new char[boardHeight][boardLength];
        boolean winCheck = false;
        int row;
        int col;
        int chipCount = 0;
        initializeBoard(board);
        printBoard(board);
        System.out.println("Player 1: x\nPlayer 2: o");
        do {
            //begins loop for players turns
            System.out.print("Player 1: Which column would you like to choose? ");
            col = scnr.nextInt();
            row = insertChip(board, col, 'x');
            //checks if inserted chip wins game, and then ends if it does
            winCheck = checkIfWinner(board, col, row, 'x');
            printBoard(board);
            chipCount++;
            if (winCheck){
                System.out.println("Player 1 won the game!");
                return;
            }
            if (chipCount == boardHeight*boardLength){
                System.out.println("Draw. Nobody wins.");
                return;
            }
            //repeats turn taking for player 2
            System.out.print("Player 2: Which column would you like to choose? ");
            col = scnr.nextInt();
            row = insertChip(board, col, 'o');
            //check win, and end if it does
            winCheck = checkIfWinner(board, col, row, 'o');
            printBoard(board);
            chipCount++;
            if (winCheck){
                System.out.println("Player 2 won the game!");
            }
            if (chipCount == boardHeight*boardLength){
                System.out.println("Draw. Nobody wins.");
                return;
            }
        }
        //loop ends when player wins
        while (!winCheck);
        }
        public static void printBoard(char[][] board) {
        //iterates over board array and prints it
            for (int i = board.length - 1; i >= 0; i--) {
                for (int j = 0; j < board[0].length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
        public static void initializeBoard(char[][] board){
        //iterates over board and fills each position with -
            for (int i = 0; i < board.length; i++){
                for (int j = 0; j < board[0].length; j++){
                    board[i][j] = '-';
                }
            }
        }
        public static int insertChip(char[][] board, int col, char chipType){
        //checks if there's a chip, and if there is it returns the row above
            for (int i = board[0].length - 1; i >= 0; i--){
                if (board[i][col] != '-'){
                    board[i + 1][col] = chipType;
                    return i + 1;
                }
                //if it gets to the bottom, return 0
                if (i == 0){
                    board[i][col] = chipType;
                    return i;
                }
            }
            return 0;
        }
        public static boolean checkIfWinner(char[][] board, int col, int row, char chipType){
        //iterates over row and checks if four of the chip type in a row
            int counter = 0;
            for (int i = 0; i < board.length; i++){
                if (board[i][col] == chipType){
                    counter++;
                }
                else{
                    counter = 0;
                }
                if (counter == 4){
                    return true;
                }
                }
            counter = 0;
            //iterates over column and checks if four of chip type in a row
            for (int j = 0; j < board[row].length; j++){
                if (board[row][j] == chipType) {
                    counter++;
                }
                else{
                    counter = 0;
                }
                if (counter == 4){
                    return true;
                }
            }
            return false;
        }
}
