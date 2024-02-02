package models;

import io.ebean.Model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Card extends Model {
    public static Collection<Card> allCards = Arrays.asList(
            new Card(
                    0,
                    Arrays.asList(Joints.TOP, Joints.BOTTOM)
            ),
            new Card(
                    1,
                    Arrays.asList(Joints.BOTTOM, Joints.LEFT)
            )
    );

    public int id;

    public List<Joints> joints;

    public Card(){}

    public Card(int id, List<Joints> joints) {
        this.id = id;
        this.joints = joints;
    }

    public enum Joints{
        TOP,
        RIGHT,
        BOTTOM,
        LEFT
    }
}
