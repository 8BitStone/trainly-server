package controllers;

import data.PlayData;
import models.Tile;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;

public class PlayController extends Controller {

    @Inject
    private FormFactory formFactory;

    public Result post(Http.Request request){
        final Form<PlayData> form = formFactory
                .form(PlayData.class)
                .bindFromRequest(request);
        if(form.hasErrors()){
            return badRequest();
        }

        final PlayData data = form.get();

        final Tile tile = Tile.FIND.byCoords(data.x, data.y)
                .orElseGet(Tile::new);

        tile.cardId = data.card;
        tile.x = data.x;
        tile.y = data.y;
        tile.rotation = data.rotation;
        tile.save();

        return ok();
    }

}
