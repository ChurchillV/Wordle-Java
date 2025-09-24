import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public static String getRandomWord(String filePath) throws IOException{
        List<String> words = Files.readAllLines(Paths.get(filePath));

        if(words.isEmpty()) {
            throw new IOException("Word list is empty");
        }

        Random random = new Random();
        return words.get(random.nextInt(words.size())).toUpperCase();
    }

    public static String getInput(int wordSize, Scanner scanner) {
        while (true) {
            System.out.print("Enter your guess: ");
            String input = scanner.nextLine().toUpperCase();

            input = input.replaceAll("[^A-Z]", "");

            if(input.length() == wordSize) {
                return input;
            } else {
                System.out.println("Invalid input. Try again!");
            }
        }
    }
    
    public static char[] checkAnswer(String answer, String input) {
        answer = answer.toUpperCase();
        input = input.toUpperCase();

        int length = answer.length();
        char[] result = new char[length];
        boolean[] used = new boolean[length];

        // mark greens
        for (int i = 0; i < length; i++) {
            if (input.charAt(i) == answer.charAt(i)) {
                result[i] = 'G';
                used[i] = true;
            }
        }

        // mark yellows
        for (int i = 0; i < length; i++) {
            if (result[i] != 'G') {
                boolean found = false;
                for (int j = 0; j < length; j++) {
                    if (!used[j] && input.charAt(i) == answer.charAt(j)) {
                        result[i] = 'Y';
                        used[j] = true;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    result[i] = 'B';
                }
            }
        }

        return result;
    }

    public static boolean isGameOver(String answer, String input, int turns, int maxTurns) {
       return answer.equalsIgnoreCase(input) || turns >= maxTurns;
    }
}
