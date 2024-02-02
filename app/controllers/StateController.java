package controllers;

import data.StateData;
import models.Tile;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Collection;

public class StateController extends Controller {

    public Result get(){

        final Collection<Tile> tiles = Tile.FIND.all();

        final StateData state = new StateData()
                .fillMap(tiles)
                .fillCards();
        return ok(Json.toJson(state));
    }
}
