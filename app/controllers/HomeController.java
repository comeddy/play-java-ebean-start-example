package controllers;

import models.Users;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result returnMap() {
        HashMap<String, Object> result = new HashMap<String, Object>() {
            {
                put("attend", 15);
                put("when", "In a day off!!");
            }
        };
        return ok(Json.toJson(result));
    }

    // get list sample
    public Result returnList() {
        List<String> result = new ArrayList<>();
        result.add("lgd");
        result.add("company");
        result.add("hadoop");
        return ok(result.toString());
    }

    // Find all playdb.user
    public Result returnListUsers() {
        List<Users> result = Users.findAll();
        return ok(Json.toJson(result));
    }

    // find a Users by id
    public Result returnIdUsers() {
        String byid = "1";
        Users result = Users.findbyId(byid);
        return ok(Json.toJson(result));
    }

    // delete a Users by id
    public Result returnDeleteUsers() {
        String byid = "3";
        Users.deletebyId(byid);
        return ok(index.render("delete by id :"+ byid));
    }

    public Result returnComplexQeury() {
        List<Users> result = Users.findQeury();
        return ok(Json.toJson(result));
    }
}
