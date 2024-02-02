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
    private int id;

    private int cardId;
    private int x;
    private int y;
    private int rotation;

    public static final TileFinder FIND = new TileFinder();

    public Tile() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    private Card getCard(){
        return Card.allCards.stream().filter(c -> c.id == cardId).findFirst().get();
    }
}
