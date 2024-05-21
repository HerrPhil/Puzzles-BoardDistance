import java.util.*;
import java.util.stream.*;

public class BoardDistance2 {

    public static void main(String [] args) {
        System.out.printf("Hello Board Distance solution #1%n");
        if (args != null && args.length == 1 && args[0].toLowerCase().equals("-usage")) {
            System.out.printf("java BoardDistance2%n");
            return;
        }
//        int [] A = new int [] {1, 1, 0, 0, 1}; // max = 4
//        int [] A = new int [] {0, 1, 0, 1, 0}; // max = 3
//        int [] A = new int [] {0, 1, 0, 1}; // max = 3
//        int [] A = new int [] {0, 1, 1, 1, 1, 1, 0, 1, 0}; // max = 11
//        int [] A = new int [] {0, 1}; // max = 1
//        int [] A = new int [] {0, 0, 0}; // max = 0
//        int [] A = new int [] {1, 0, 0, 0}; // max = 3
//        int [] A = new int [] {0, 1, 0, 0}; // max = 2
//        int [] A = new int [] {1, 1, 1, 1}; // max = 0
//        int [] A = new int [] {0, 1, 1, 1}; // max = 3
        int [] A = new int [] {0, 1, 1, 1, 0}; // max = 3

        BoardDistance2 boardDistance = new BoardDistance2();
        int result = boardDistance.solution(A);
        System.out.printf("The maximum board distance is %d%n", result);
    }

    public int solution(int[] board) {
        int[] original = board.clone();
        int distance1 = getDistance(board);
        System.out.printf("distance #1 is %d%n", distance1);
        System.out.printf("reverse order%n");
        for(int i = 0; i < original.length / 2; i++) {
            int temp = original[i];
            original[i] = original[original.length - i - 1];
            original[original.length - i - 1] = temp;
        }
        int distance2 = getDistance(original);
        System.out.printf("distance #2 is %d%n", distance2);
        return Math.max(distance1, distance2);
    }

    public int getDistance(int[] board) {
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
        if (board.length > 40000) return 0;

        // Otherwise start traversing to find maximum total distance
        
        int N = board.length;
        int maxZeroPosition = N;
        int currentPosition = N - 1;
        boolean startsWithZero = board[currentPosition] == 0;
        boolean startsWithOne = board[currentPosition] == 1;

        if (startsWithZero) {
            maxZeroPosition = currentPosition;
        }
        if (startsWithOne) {
            currentPosition = N - 2;
        }

        System.out.printf("starts with zero %b%n", startsWithZero);
        System.out.printf("starts with one %b%n", startsWithOne);

        while (currentPosition >= 0) {
            System.out.printf("%n%n");
            System.out.printf("current position %d%n", currentPosition);
            System.out.printf("max zero position %d%n", maxZeroPosition);
            System.out.printf("current state %s%n", Arrays.toString(board));

            if (board[currentPosition] == 0) {
                System.out.printf("has zeros%n");
                System.out.printf("assign current position to maximum zero position when it is N, not initialized%n");
                if (maxZeroPosition == N) { // not initialized
                    maxZeroPosition = currentPosition;
                }
            }
            if (board[currentPosition] == 1 && maxZeroPosition != N) {
                System.out.printf("has ones%n");
                System.out.printf("Swap values of indices current %d and max %d%n", currentPosition, maxZeroPosition);
                board[currentPosition] = 0;
                board[maxZeroPosition] = 1;
                // track distance moved
                distance = distance + (maxZeroPosition - currentPosition);
                System.out.printf("distance is now %d%n", distance);
                // maximum zero position is now one less than before
                // because the one value is there now
                System.out.printf("decrement maximum zero position%n");
                maxZeroPosition--;
            }
            System.out.printf("decrement current position%n");
            currentPosition--;
        }

        System.out.printf("output %s%n", Arrays.toString(board));
        return distance;
    }

}
