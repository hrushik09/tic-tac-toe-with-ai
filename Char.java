package tictactoe;

enum Char {
    X('X'),
    O('O');

    char character;

    Char(char character) {
        this.character = character;
    }

    public Char switchChar() {
        return this == Char.X ? Char.O : Char.X;
    }
}