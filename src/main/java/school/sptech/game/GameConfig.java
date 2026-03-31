package school.sptech.game;

import school.sptech.gui.PieceType;

import java.util.Arrays;

public final class GameConfig {
    public GameConfig() {}

    public static final PieceType[] ROYAL_ROW = {PieceType.ROOK, PieceType.HORSE, PieceType.BISHOP, PieceType.QUEEN, PieceType.KING, PieceType.BISHOP, PieceType.HORSE, PieceType.ROOK};
    public static PieceType[] PAWN_ROW = new PieceType[8];

    static {
        Arrays.fill(PAWN_ROW, PieceType.PAWN);
    }
}
