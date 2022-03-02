# Tic Tac Toe

This is a tic-tac-toe game. The coordinates for the grid cells are as follows:<br/>
(1, 1) (1, 2) (1, 3) <br/>
(2, 1) (2, 2) (2, 3) <br/>
(3, 1) (3, 2) (3, 3)

At the start, enter a mode: "start player1 player2". <br/>
`player1` and `player2` can be
- `user` means human player (you).<br/>
- `easy`, `medium`, `hard` means AI player.

Accepted modes are:
- `start user user`
- `start hard user`
- `start easy medium`
- etc.

**Gameplay**:
- In `user` mode, you will enter the coordinates. `1 2` or `3 3`, etc.
- When the AI is playing at `easy` difficulty level, computer will select a random cell out of the empty cells.
- When the AI is playing at `medium` difficulty level, it makes moves using the following logic:
  * If it already has two in a row and can win with one further move, it does so.
  * If its opponent can win with one move, it plays the move necessary to block this.
  * Otherwise, it makes a random move.
- When the AI is playing at `hard` difficulty level, it can calculate all possible moves that might be played during the game, and choose the best one based on the assumption that its opponent will also play perfectly. It uses the brute force algorithm **minimax** that maximizes the value of the AI's position and minimizes the value of its opponent's.

Program stops when either player wins or the game results in a draw.
#
This program is based on the Tic-Tac-Toe with AI project on [JetBrains Academy](https://hyperskill.org).
