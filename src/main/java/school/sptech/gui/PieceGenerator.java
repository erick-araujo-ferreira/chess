package school.sptech.gui;

import school.sptech.gui.strategies.pieces.*;

import java.awt.*;
import java.util.Map;

public class PieceGenerator {
    private final Map<PieceType, PieceRenderingStrategy> pieceMap = Map.of(
            PieceType.PAWN, new PawnRenderingStrategy(),
            PieceType.ROOK, new RookRenderingStrategy(),
            PieceType.HORSE, new HorseRenderingStrategy(),
            PieceType.BISHOP, new BishopRenderingStrategy(),
            PieceType.QUEEN, new QueenRenderingStrategy(),
            PieceType.KING, new KingRenderingStrategy()
    );

    public void renderPiece(Graphics g, PieceType pieceType, Integer [] coordsXY, Boolean isWhite) {
        if (isWhite) g.setColor(Color.BLUE);
        else g.setColor(Color.RED);
        if (pieceType == PieceType.PAWN) System.out.println("PEAO: " + isWhite + " Vai ser pintado de " + g.getColor());
        PieceRenderingStrategy renderingStrategy = pieceMap.get(pieceType);
        renderingStrategy.render(g, coordsXY[0], coordsXY[1]);
    }
}
