package school.sptech.game;

public class GameRuler {
    private final BoardManager boardManager;
    private Piece[][] board;

    public GameRuler(BoardManager boardManager) {
        this.boardManager = boardManager;
        board = boardManager.getBoard();
    }


}
