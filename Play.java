package tictactoe;

public class Play {
    String p1;
    String p2;

    public Play() {
        Game game = new Game();
        User player1 = new User(Char.X);
        User player2 = new User(Char.O);
        play(player1, player2, game);
    }

    void play(User player1, User player2, Game game) {
        game.printGrid();
        while (true) {
            game.moves++;
            if (player1.play(game)) {
                break;
            }
            game.moves++;
            if (player2.play(game)) {
                break;
            }
        }
    }

    public Play(String p1, String p2) {
        this.p1 = p1;
        this.p2 = p2;
        Game game = new Game();
        Computer player1 = new Computer(Char.X, p1);
        Computer player2 = new Computer(Char.O, p2);
        play(player1, player2, game);
    }

    void play(Computer player1, Computer player2, Game game) {
        game.printGrid();
        while (true) {
            game.moves++;
            if (player1.play(game)) {
                break;
            }
            game.moves++;
            if (player2.play(game)) {
                break;
            }
        }
    }

    @SuppressWarnings(value = "unused")
    public Play(int temp, String p2) {
        this.p2 = p2;
        Game game = new Game();
        User player1 = new User(Char.X);
        Computer player2 = new Computer(Char.O, p2);
        play(player1, player2, game);
    }

    void play(User player1, Computer player2, Game game) {
        game.printGrid();
        while (true) {
            game.moves++;
            if (player1.play(game)) {
                break;
            }
            game.moves++;
            if (player2.play(game)) {
                break;
            }
        }
    }

    @SuppressWarnings(value = "unused")
    public Play(String p1, int temp) {
        this.p1 = p1;
        Game game = new Game();
        Computer player1 = new Computer(Char.X, p1);
        User player2 = new User(Char.O);
        play(player1, player2, game);
    }

    void play(Computer player1, User player2, Game game) {
        game.printGrid();
        while (true) {
            game.moves++;
            if (player1.play(game)) {
                break;
            }
            game.moves++;
            if (player2.play(game)) {
                break;
            }
        }
    }
}