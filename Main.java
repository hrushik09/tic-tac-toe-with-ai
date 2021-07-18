package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        String[] inputArr;

        while (true) {
            System.out.print("Input command: ");
            input = scanner.nextLine();
            inputArr = input.split(" ");
            if (input.equals("exit")) {
                return;
            }
            if (inputArr.length != 3) {
                System.out.println("Bad parameters!");
            } else if (!inputArr[0].equals("start")) {
                System.out.println("Bad parameters!");
            } else {
                if (!(inputArr[1].equals("easy") || inputArr[1].equals("user")
                        || inputArr[1].equals("medium") || inputArr[1].equals("hard"))) {
                    System.out.println("Bad parameters!");
                } else if (!(inputArr[2].equals("easy") || inputArr[2].equals("user")
                        || inputArr[2].equals("medium") || inputArr[2].equals("hard"))) {
                    System.out.println("Bad parameters!");
                } else {
                    if (inputArr[1].equals("user") && inputArr[2].equals("user")) {
                        new Play();
                    } else if (inputArr[1].equals("user")) {
                        new Play(1, inputArr[2]);
                    } else if (inputArr[2].equals("user")) {
                        new Play(inputArr[1], 2);
                    } else {
                        new Play(inputArr[1], inputArr[2]);
                    }
                    break;
                }
            }
        }
    }
}