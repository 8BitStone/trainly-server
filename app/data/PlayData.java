package data;

import models.Card;
import models.Tile;
import play.data.validation.ValidationError;
import play.data.validation.Constraints;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlayData implements Constraints.Validatable<List<ValidationError>> {
    public Integer card;
    public Integer x;
    public Integer y;
    public Integer rotation;

    @Override
    public List<ValidationError> validate() {
        final List<ValidationError> errors = new ArrayList<>();
        validateCard().ifPresent(errors::add);
        validatePosition().ifPresent(errors::add);
        validateRotation().ifPresent(errors::add);
        return errors;
    }

    private Optional<ValidationError> validateCard(){
        if(card == null){
            return Optional.of(new ValidationError("card", "card is empty"));
        }
        if(Card.allCards.stream().anyMatch(c -> c.id == card)){
            return Optional.of(new ValidationError("card", "card does not exist"));
        }
        return Optional.empty();
    }

    private Optional<ValidationError> validatePosition(){
        if(x == null){
            return Optional.of(new ValidationError("x", "x is empty"));
        }
        if(y == null){
            return Optional.of(new ValidationError("y", "y is empty"));
        }
        return Optional.empty();
    }

    private Optional<ValidationError> validateRotation(){
        if(rotation == null){
            return Optional.of(new ValidationError("rotation", "rotation is empty"));
        }
        return Optional.empty();
    }

    public void saveToModel(Tile model){
        model.cardId = card;
        model.x = x;
        model.y = y;
        model.rotation = rotation;
        model.save();
    }
}
