package models.finder;

import io.ebean.Finder;
import models.Tile;

import java.util.Optional;

public class TileFinder extends Finder<Integer, Tile> {
    public TileFinder() {
        super(Tile.class);
    }

    public Optional<Tile> byCoords(int x, int y){
        return query()
                .where()
                .eq("x", x)
                .eq("y", y)
                .findOneOrEmpty();
    }
}
