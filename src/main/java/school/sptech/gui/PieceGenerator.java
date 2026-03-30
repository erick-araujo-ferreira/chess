package school.sptech.gui;

import school.sptech.gui.strategies.pieces.*;

import java.awt.*;
import java.util.Map;

public class PieceGenerator {
    public void renderPiece(Graphics g, PieceType pieceType, Integer x0, Integer y0) {
        Map<PieceType, PieceRenderingStrategy> pieceMap = Map.of(
                PieceType.PAWN, new PawnRenderingStrategy(),
                PieceType.ROOK, new RookRenderingStrategy(),
                PieceType.HORSE, new HorseRenderingStrategy(),
                PieceType.BISHOP, new BishopRenderingStrategy(),
                PieceType.QUEEN, new QueenRenderingStrategy(),
                PieceType.KING, new KingRenderingStrategy()
        );

        PieceRenderingStrategy renderingStrategy = pieceMap.get(pieceType);
        renderingStrategy.render(g, x0, y0);
    }
}
