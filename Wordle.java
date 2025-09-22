import java.util.Scanner;

public class Wordle {
    public static void main(String args[]){
        final int WORD_SIZE = 5;
        final int WORD_COUNT = 6;
        Scanner scanner = new Scanner(System.in);

        String answer = "APPLE";
        WordleBoard board = new WordleBoard(WORD_SIZE, WORD_COUNT);

        int turn = 0;
        boolean gameOver = false;
        board.printBoard();

        while(!gameOver) {
            String guess = Game.getInput(WORD_SIZE, scanner);
            char[] colors = Game.checkAnswer(answer, guess);

            board.setRow(turn, guess, colors);
            board.printBoard();

            gameOver = Game.isGameOver(answer, guess, turn + 1, WORD_COUNT);

            if(answer.equalsIgnoreCase(guess)) {
                System.out.println("YOU WIN!!");
            } else if (turn + 1 == WORD_COUNT) {
                System.out.println("GAME OVER!\nANSWER WAS: " + answer);
            }

            turn++;
        }

        scanner.close();
    }
}
