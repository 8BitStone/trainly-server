package models;

import io.ebean.Model;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "card")
public class Card extends Model {
    public static Collection<Card> allCards = Arrays.asList(new Card(1), new Card(2));

    @Id
    public int id;

    public Card(){}

    public Card(int id) {
        this.id = id;
    }
}
