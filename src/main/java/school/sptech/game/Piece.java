package school.sptech.game;

import school.sptech.gui.PieceType;

public class Piece {
    private PieceType pieceType;
    private boolean isWhite;

    public Piece() {
    }

    public Piece(PieceType pieceType, boolean isWhite) {
        this.pieceType = pieceType;
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "pieceType=" + pieceType +
                ", isWhite=" + isWhite +
                '}';
    }
}
