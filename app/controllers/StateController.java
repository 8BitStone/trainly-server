package controllers;

import data.StateData;
import models.Tile;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.StateDataBuilder;

public class StateController extends Controller {

    public Result get(){
        final StateData state = new StateDataBuilder().build();
        return ok(Json.toJson(state));
    }

    public Result clear(){
        Tile.FIND.all()
                .forEach(Tile::delete);
        return redirect(routes.StateController.get());
    }
}
