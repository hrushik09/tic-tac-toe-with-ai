package tictactoe;

public class Game {
    char[][] grid;
    int moves;

    public Game() {
        this.grid = new char[][] {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        moves = 0;
    }

    boolean analyzeGrid(Char ch) {
        if (won(ch)) {
            System.out.println(ch.character + " wins");
            return true;
        } else if (moves == 9) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }

    int evaluate(Char ch) {
        if(won(ch)) {
            return 10;
        } else if (won(ch.switchChar())) {
            return -10;
        } else {
            return 0;
        }
    }

    boolean isMovesLeft() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (grid[i][j] == 32)
                    return true;
        return false;
    }

    private boolean won(Char ch) {
        if (grid[0][0] + grid[1][1] + grid[2][2] == 3 * ch.character) {
            return true;
        } else if (grid[0][2] + grid[1][1] + grid[2][0] == 3 * ch.character) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] + grid[i][1] + grid[i][2] == 3 * ch.character) {
                return true;
            } else if (grid[0][i] + grid[1][i] + grid[2][i] == 3 * ch.character) {
                return true;
            }
        }
        return false;
    }

    void printGrid() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.println("| "+ grid[i][0] + " " + grid[i][1] + " " + grid[i][2] + " |");
        }
        System.out.println("---------");
    }
}