package com.practice.problem.solving;
import java.util.*;

// Random Practice King's March problem
public class KingsMarch {

    private static final Map<Character, Integer> ENC = new HashMap<>();
    private static final Map<Integer, Character> DEC = new HashMap<>();

    static {
        ENC.put('s', -10);
        ENC.put('e', 0);
        ENC.put('x', Integer.MIN_VALUE);
        DEC.put(-10, 's');
        DEC.put(0, 'e');
        DEC.put(Integer.MIN_VALUE, 'x');
    }

    static int encodeCellValue(final char value) {
        return ENC.getOrDefault(value, value - '0');
    }
    static char decodeCellValue(final int value) {
        return DEC.getOrDefault(value, (char)(value + '0'));
    }

    static boolean isStart(final int value) {
        return value == ENC.getOrDefault('s', Integer.MAX_VALUE);
    }

    static boolean isEnd(final int value) {
        return value == ENC.getOrDefault('e', Integer.MAX_VALUE);
    }

    static boolean isObstacle(final int value) {
        return value == ENC.getOrDefault('x', Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(KingsMarch.class.getClassLoader().getResourceAsStream("kings-march-input"));

        int[][][] chessBoards;

        int t = reader.nextInt();
        chessBoards = new int[t][][];
        for (int i = 0; i < t; i++) {
            int boardSize = reader.nextInt();
            chessBoards[i] = new int[boardSize][boardSize];
            for (int j = 0; j < boardSize; ++j) {
                for (int k = 0; k < boardSize; ++k) {
                    char cell = reader.next().charAt(0);
                    int cellValue = encodeCellValue(cell);
                    chessBoards[i][j][k] = cellValue;
                }
            }
        }

        for (int i = 0; i < chessBoards.length; ++i) {
            System.out.println("Solving board: " + (i + 1));
            findPathsDP(chessBoards[i]);
            System.out.println("\n---------");
        }

    }

    static void findPathsDP(final int[][] board) {

        final int side = board.length;
        final int[][] cost = new int[side][side];

        for (int i = 0; i < cost.length; i++) {
            for (int j = 0; j < cost.length; j++) {
                cost[i][j] = Integer.MIN_VALUE;
            }
        }

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = board.length - 1; j >= 0; j--) {
                final int cell = board[i][j];
                if (isStart(cell)) {
                    cost[i][j] = 0;
                } else if (isObstacle(cell)) {
                    continue;
                }

                if (i > 0 && !isObstacle(board[i - 1][j])) {
                    cost[i - 1][j] = cost[i][j] + board[i - 1][j];
                }
                if (j > 0 && !isObstacle(board[i][j - 1])) {
                    cost[i][j - 1] = cost[i][j] + board[i][j - 1];
                }
                if (i > 0 && j > 0 && !isObstacle(board[i - 1][j - 1])) {
                    cost[i - 1][j - 1] = cost[i][j] + board[ i - 1][j - 1];
                }
            }
        }

        for (int i = 0; i < cost.length; i++) {
            for (int j = 0; j < cost.length; j++) {
                System.out.print(cost[i][j] + " ");
            }
            System.out.println();
        }

        final int traversalCost = cost[0][0];

        if (traversalCost < 0) {
            System.out.println("No path exists!");
        } else {
            System.out.println("Cost = " + traversalCost);
        }
    }

    static void findPaths(final int[][] board) {

        final Stack<Index> indexStack = new Stack<>();
        int side = board.length;

        final Index startIndex = new Index(side - 1, side - 1);
        indexStack.push(startIndex);

        final Set<Index> visited = new HashSet<>();
        int numPaths = 0;

        while (!indexStack.isEmpty()) {
            final Index current = indexStack.pop();
            if (!current.within(side)) {
                continue;
            }

            if (visited.contains(current)) {
                continue;
            }

            final int value = current.value(board);
            visited.add(current);
            if (isObstacle(value)) {
                System.out.println("Obstacle at " + current + ", skipping!");
                continue;
            } else if (isEnd(value)) {
                ++numPaths;
                System.out.println("Arrived at the end!");
            }

            System.out.println(current + " = " + value);

            current.adjacentIndices().forEach(indexStack::push);
        }

        System.out.println(numPaths + " max paths");
    }

    static class Index {
        private int x;
        private int y;

        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public List<Index> adjacentIndices() {
            if (x == 0 && y == 0) {
                return List.of();
            } if (x == 0 && y > 0) {
                return List.of(new Index(x, y - 1));
            } else if (x > 0 && y == 0) {
                return List.of(new Index(x - 1, y));
            } else {
                return List.of(
                        new Index(x - 1, y - 1), new Index(x - 1, y), new Index(x, y - 1));
            }
        }

        public int value(final int[][] board) {
            return board[x][y];
        }

        @Override
        public boolean equals(Object other) {
            if (other == null) {
                return false;
            } else if (!(other instanceof Index)) {
                return false;
            } else {
                final Index that = (Index) other;
                return this.x == that.x && this.y == that.y;
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", x, y);
        }

        public boolean within(final int side) {
            return x < side && y < side;
        }
    }
}
