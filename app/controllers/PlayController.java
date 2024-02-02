package controllers;

import data.PlayData;
import data.StateData;
import models.Tile;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.StateDataBuilder;

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

        data.updateToModel(tile);
        tile.save();

        final StateData state = new StateDataBuilder().build();
        return ok(Json.toJson(state));
    }

}
