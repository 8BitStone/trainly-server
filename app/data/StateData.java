package data;

import models.Card;
import models.Tile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StateData {

    public List<TileData> map;
    public List<Integer> cards;

    public StateData() {
        map = new ArrayList<>();
        cards = new ArrayList<>();
    }

    public StateData fillMap(Collection<Tile> tiles){
        map = tiles.stream()
                .map(t -> new TileData().from(t))
                .collect(Collectors.toList());
        return this;
    }

    public StateData fillCards(){
        Card.allCards.stream()
                .map(c -> c.id)
                .forEach(cards::add);
        return this;
    }
}
