package tictactoe;

import java.util.Random;

public class Computer extends Player {
    int firstCoordinate;
    int secondCoordinate;
    String difficultyLevel;

    public Computer(Char charToUse, String difficultyLevel) {
        super(charToUse);
        this.difficultyLevel = difficultyLevel;
    }

    public boolean play(Game game) {
        switch (difficultyLevel) {
            case "easy":
                return getCoordinates(game, 1);
            case "medium":
                return getCoordinates(game, 1.0);
            case "hard":
                return getCoordinates(game, 1.0f);
        }
        return false;
    }

    @SuppressWarnings(value = "unused")
    private boolean getCoordinates(Game game, int i) {
        System.out.println("Making move level \"easy\"");
        return getRandomCoordinates(game);
    }

    @SuppressWarnings(value = "unused")
    private boolean getCoordinates(Game game, double i) {
        System.out.println("Making move level \"medium\"");
        if (winPossible(game, charToUse)) {
            return makeMove(game);
        } else if (winPossible(game, charToUse.switchChar())) {
            return makeMove(game);
        } else {
            return getRandomCoordinates(game);
        }
    }

    @SuppressWarnings(value = "unused")
    private boolean getCoordinates(Game game, float i) {
        System.out.println("Making move level \"hard\"");
        findBestMove(game);
        return makeMove(game);
    }

    private void findBestMove(Game game) {
        int bestVal = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (game.grid[i][j] == 32) {
                    game.grid[i][j] = charToUse.character;
                    int moveVal = minimax(game, 0, false);
                    game.grid[i][j] = 32;
                    if (moveVal > bestVal) {
                        firstCoordinate = i;
                        secondCoordinate = j;
                        bestVal = moveVal;
                    }
                }
            }
        }
    }

    private int minimax(Game game, int depth, Boolean isMax) {
        int score = game.evaluate(charToUse);
        // If Maximizer has won the game return evaluated score minus depth
        if (score == 10) {
            return score - depth;
        }
        // If Minimizer has won the game return evaluated score plus depth
        if (score == -10) {
            return score + depth;
        }
        // If there are no more moves and no winner then it is a tie
        if (!game.isMovesLeft()) {
            return 0;
        }

        int best;
        if (isMax) {
            best = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (game.grid[i][j] == 32) {
                        game.grid[i][j] = charToUse.character;
                        best = Math.max(best, minimax(game, depth + 1, false));
                        game.grid[i][j] = 32;
                    }
                }
            }
        } else {
            best = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (game.grid[i][j] == 32) {
                        game.grid[i][j] = charToUse.switchChar().character;
                        best = Math.min(best, minimax(game, depth + 1, true));
                        game.grid[i][j] = 32;
                    }
                }
            }
        }
        return best;
    }

    private boolean getRandomCoordinates(Game game) {
        Random random = new Random();
        do {
            firstCoordinate = random.nextInt(3);
            secondCoordinate = random.nextInt(3);
        } while (game.grid[firstCoordinate][secondCoordinate] != 32);
        return makeMove(game);
    }

    private boolean winPossible(Game game, Char ch) {
        if (game.grid[0][0] + game.grid[1][1] + game.grid[2][2] == 2 * ch.character + 32) {
            if (isEmpty(game, 0, 0)) { return true; }
            else if (isEmpty(game, 1, 1)) { return true; }
            else if (isEmpty(game, 2, 2)) { return true; }
        } else if (game.grid[0][2] + game.grid[1][1] + game.grid[2][0] == 2 * ch.character + 32) {
            if (isEmpty(game, 0, 2)) { return true; }
            else if (isEmpty(game, 1, 1)) { return true; }
            else if (isEmpty(game, 2, 0)) { return true; }
        }
        for (int i = 0; i < 3; i++) {
            if (game.grid[i][0] + game.grid[i][1] + game.grid[i][2] == 2 * ch.character + 32) {
                if (isEmpty(game, i, 0)) { return true; }
                else if (isEmpty(game, i, 1)) { return true; }
                else if (isEmpty(game, i, 2)) { return true; }
            } else if (game.grid[0][i] + game.grid[1][i] + game.grid[2][i] == 2 * ch.character + 32) {
                if (isEmpty(game, 0, i)) { return true; }
                else if (isEmpty(game, 1, i)) { return true; }
                else if (isEmpty(game, 2, i)) { return true; }
            }
        }
        return false;
    }

    private boolean isEmpty(Game game, int p, int q) {
        if (game.grid[p][q] == 32) {
            firstCoordinate = p;
            secondCoordinate = q;
            return true;
        }
        return false;
    }

    private boolean makeMove(Game game) {
        game.grid[firstCoordinate][secondCoordinate] = charToUse.character;
        game.printGrid();
        return game.analyzeGrid(charToUse);
    }
}