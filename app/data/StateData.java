package data;

import models.Card;
import models.Tile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StateData {

    public MapData map;
    public List<Integer> cards;

    public StateData() {
        map = new MapData();
        cards = new ArrayList<>();
    }

    public StateData fillMap(Collection<Tile> tiles){
        map = new MapData().fillMap(tiles);
        return this;
    }

    public StateData fillCards(){
        Card.allCards.stream()
                .map(c -> c.id)
                .forEach(cards::add);
        return this;
    }
}
