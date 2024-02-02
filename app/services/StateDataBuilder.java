package services;

import data.StateData;
import models.Tile;

import java.util.Collection;

public class StateDataBuilder {

    public StateData build(){
        final Collection<Tile> tiles = Tile.FIND.all();

        return new StateData()
                .fillMap(tiles)
                .fillCards();
    }
}
