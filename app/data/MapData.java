package data;

import models.Tile;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapData {
    public List<TileData> tiles;
    public Integer minX;
    public Integer minY;
    public Integer maxX;
    public Integer maxY;

    public MapData fillMap(Collection<Tile> tileModels){
        tiles = tileModels.stream()
                .map(t -> new TileData().from(t))
                .collect(Collectors.toList());

        minX = tileModels.stream().map(Tile::getX).min(Integer::compareTo).orElse(-2);
        maxX = tileModels.stream().map(Tile::getX).max(Integer::compareTo).orElse(2);
        minY = tileModels.stream().map(Tile::getY).min(Integer::compareTo).orElse(-2);
        maxY = tileModels.stream().map(Tile::getY).max(Integer::compareTo).orElse(2);
        return this;
    }
}
