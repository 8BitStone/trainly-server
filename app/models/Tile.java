package models;

import io.ebean.Model;
import models.finder.TileFinder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tile")
public class Tile extends Model {

    @Id
    public int id;

    public int cardId;
    public int x;
    public int y;
    public int rotation;

    public static final TileFinder FIND = new TileFinder();

    public Tile() {}



    private Card getCard(){
        return Card.allCards.stream().filter(c -> c.id == cardId).findFirst().get();
    }
}
