public class WordleBoard {
    private Cell[][] board;
    private int WORD_SIZE = 5;
    private int WORD_COUNT = 6;
    
    public WordleBoard(int wordSize, int wordCount) {
        this.WORD_SIZE = wordSize;
        this.WORD_COUNT = wordCount;

        board = new Cell[wordCount][wordSize];
        setBoard();
    }

    public void setBoard() {
        board = new Cell[WORD_COUNT][WORD_SIZE];
        for(int row = 0; row < WORD_COUNT; ++row) {
            for(int col = 0; col < WORD_SIZE; ++col) {
                board[row][col] = new Cell();
            }
        }
    }

    public void setRow(int row, String word, char[] colors) {
       for(int position = 0; position < WORD_SIZE; ++position) {
            board[row][position].letter = word.charAt(position);
            board[row][position].color = colors[position];
       }
    }

    public void printBoard() {
        for (int i = 0; i < WORD_COUNT; i++) {
            for (int j = 0; j < WORD_SIZE; j++) {
                char c = board[i][j].letter;
                char color = board[i][j].color;
                switch (color) {
                    case 'G':
                        System.out.print("[" + Colors.GREEN + c + Colors.RESET + "]");
                        break;
                    case 'Y':
                        System.out.print("[" + Colors.YELLOW + c + Colors.RESET + "]");
                        break;
                    case 'B':
                        System.out.print("[" + Colors.GRAY + c + Colors.RESET + "]");
                        break;
                    default:
                        System.out.print("[" + c + "]");
                }
            }
            System.out.println();
        }
    }

    // public static void main(String args[]) {
    //     WordleBoard board = new WordleBoard(5,6);
    //     board.setBoard();
    //     board.printBoard();
    // }
}
