package school.sptech.game;

import school.sptech.gui.PieceType;

public class Piece {
    private PieceType pieceType;
    private boolean isWhite;
    private boolean wasMoved = false;

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

    public boolean wasMoved() {
        return wasMoved;
    }

    public void setWasMoved(boolean wasMoved) {
        this.wasMoved = wasMoved;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "pieceType=" + pieceType +
                ", isWhite=" + isWhite +
                ", wasMoved=" + wasMoved +
                '}';
    }
}
