package tictactoe;

import java.util.Scanner;

public class User extends Player {
    char firstCoordinate;
    char secondCoordinate;

    public User(Char charToUse) {
        super(charToUse);
    }

    public boolean play(Game game) {
        boolean wrongInput = false;
        while (!wrongInput) {
            wrongInput = getCoordinates(game);
        }
        return makeMove(game);
    }

    private boolean getCoordinates(Game game) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the coordinates: ");
        char[] move = scanner.nextLine().toCharArray();

        if (move[0] < 48 || move[0] > 57 || move[2] < 48 || move[2] > 57) {
            System.out.println("You should enter numbers!");
            return false;
        } else if (move[0] < 49 || move[0] > 51 || move[2] < 49 || move[2] > 51) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        } else if (game.grid[move[0] - 1 - 48][move[2] - 1 - 48] != 32) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        } else {
            firstCoordinate = move[0];
            secondCoordinate = move[2];
            return true;
        }
    }

    private boolean makeMove(Game game) {
        game.grid[firstCoordinate - 1 - 48][secondCoordinate - 1 - 48] = charToUse.character;
        game.printGrid();
        return game.analyzeGrid(charToUse);
    }
}