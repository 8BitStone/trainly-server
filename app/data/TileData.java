package data;

import models.Tile;

public class TileData {
    public Integer card;
    public Integer x;
    public Integer y;
    public Integer rotation;

    public TileData() {
        card = 0;
        x = 1;
        y = 2;
        rotation = 3;
    }

    public TileData from(Tile tile){
        card = tile.getCardId();
        x = tile.getX();
        y = tile.getY();
        rotation = tile.getRotation();
        return this;
    }
}
