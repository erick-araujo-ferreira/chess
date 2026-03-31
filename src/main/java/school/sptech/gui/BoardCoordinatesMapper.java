package school.sptech.gui;

import java.util.HashMap;
import java.util.Map;

import static school.sptech.gui.UIConfig.LETTER_ASCII_FIRST_POSITION;
import static school.sptech.gui.UIConfig.TILE_SIZE;

public class BoardCoordinatesMapper {
    private static BoardCoordinatesMapper boardCoordinatesMapper;
    private final Map<String, Integer[]> coordinates = new HashMap<>();

    private BoardCoordinatesMapper() {
        createBoardMap();
    }

    private void createBoardMap() {
        Integer tileSize = TILE_SIZE;
        String currentCoord = "";
        char coordLetter;
        int coordNumber;
        int aux = 0;

        for (int row = 8; row >= 1; row--) {
            for (int col = 0; col < 8; col++) {
                coordLetter = (char) (LETTER_ASCII_FIRST_POSITION + col);
                coordNumber = row;
                currentCoord = String.format("%c%d", coordLetter, coordNumber);
                Integer[] coordsXY = {tileSize * col, tileSize * aux};
                coordinates.put(currentCoord, coordsXY);
            }
            aux ++;
        }
    }

    // SINGLETON :D
    public static BoardCoordinatesMapper getInstance() {
        if (boardCoordinatesMapper == null) {
            synchronized (BoardCoordinatesMapper.class) {
                if (boardCoordinatesMapper == null) {
                    boardCoordinatesMapper = new BoardCoordinatesMapper();
                }
            }
        }

        return boardCoordinatesMapper;
    }

    public Map<String, Integer[]> getCoordinates() {
        return coordinates;
    }

    public Integer[] getCoord(String square) {
        return coordinates.get(square);
    }
}
