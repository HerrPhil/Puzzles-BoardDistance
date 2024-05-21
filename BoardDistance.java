import java.util.*;
import java.util.stream.*;

public class BoardDistance {

    public static void main(String [] args) {
        System.out.printf("Hello Board Distance solution #1%n");
        if (args != null && args.length == 1 && args[0].toLowerCase().equals("-usage")) {
            System.out.printf("java BoardDistance%n");
            return;
        }
//        int [] A = new int [] {1, 1, 0, 0, 1};
//        int [] A = new int [] {0, 1, 0, 1, 0};
        int [] A = new int [] {0, 1, 1, 1, 1, 1, 0, 1, 0};
//        int [] A = new int [] {0, 1};
//        int [] A = new int [] {0, 0, 0};
        BoardDistance boardDistance = new BoardDistance();
        int result = boardDistance.solution(A);
        System.out.printf("The maximum board distance is %d%n", result);
    }

    public int solution(int[] board) {
        int distance = 0;
        System.out.println("test");
        System.out.printf("input %s%n", Arrays.toString(board));

        // Implement your solution here

        if (board == null) return 0;
        if (board.length == 0) return 0;
        if (board.length == 1) return 0;
        if (board.length == 2) {
            if (board[0] == 0 && board[1] == 0) return 0;
            if (board[0] == 1 && board[1] == 1) return 0;
            if (board[0] == 0 && board[1] == 1) return 1;
            if (board[0] == 1 && board[1] == 0) return 1;
        }

        // Otherwise start traversing to find maximum total distance
        
        int N = board.length;
        int maxZeroPosition = N;
        int currentPosition = N - 1;
        boolean lookingForZero = true;
        boolean lookingForOne = false;
        while (currentPosition >= 0) {
            System.out.printf("%n%n");
            System.out.printf("current position %d%n", currentPosition);
            System.out.printf("max zero position %d%n", maxZeroPosition);
            System.out.printf("looking for zero %b%n", lookingForZero);
            System.out.printf("looking for one %b%n", lookingForOne);
            System.out.printf("current state %s%n", Arrays.toString(board));

            if (lookingForZero
            && board[currentPosition] == 0
            && currentPosition < maxZeroPosition) {
                System.out.printf("assign current position to maximum zero position%n");
                maxZeroPosition = currentPosition;
                System.out.printf("decrement current position%n");
                currentPosition--;
                lookingForZero = false;
                lookingForOne = true;
                System.out.printf("now looking for one");
                continue;
            }
            if (lookingForOne
            && board[currentPosition] == 1
            && currentPosition < maxZeroPosition) {
                // swap
                System.out.printf("Swap values of indices current %d and max %d%n", currentPosition, maxZeroPosition);
                board[currentPosition] = 0;
                board[maxZeroPosition] = 1;
                // track distance moved
                distance = distance + (maxZeroPosition - currentPosition);
                System.out.printf("distance is now %d%n", distance);
                if (currentPosition == 0) {
                    System.out.printf("stop condition set current position to -1%n");
                    currentPosition--;
                } else {
                    System.out.printf("assign maximum zero position minus 1 to current position%n");
                    currentPosition = maxZeroPosition - 1;
                }
                lookingForZero = true;
                lookingForOne = false;
                System.out.printf("now looking for zero");
                continue;            
            }
            // if looking for one and not found yet
            // then keep moving current position
            System.out.printf("otherwise moving current position%n");
            currentPosition--;
        }

        System.out.printf("output %s%n", Arrays.toString(board));
        return distance;
    }

}
