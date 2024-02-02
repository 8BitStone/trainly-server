package data;

import models.Card;
import models.Tile;
import play.data.validation.ValidationError;
import play.data.validation.Constraints;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Constraints.Validate
public class PlayData implements Constraints.Validatable<List<ValidationError>> {
    @Constraints.Required
    public Integer card;
    @Constraints.Required
    public Integer x;
    @Constraints.Required
    public Integer y;
    @Constraints.Required
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
        if(Card.allCards.stream().noneMatch(c -> c.id == card)){
            return Optional.of(new ValidationError("card", "card does not exist"));
        }
        return Optional.empty();
    }

    private Optional<ValidationError> validatePosition(){
        return Optional.empty();
    }

    private Optional<ValidationError> validateRotation(){
        return Optional.empty();
    }

    public void updateToModel(Tile model){
        model.setCardId(card);
        model.setX(x);
        model.setY(y);
        model.setRotation(rotation);
    }
}
