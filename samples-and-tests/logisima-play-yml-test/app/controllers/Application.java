package controllers;

import models.User;
import play.mvc.Controller;

public class Application extends Controller {

    public static void index() {
        User user = User.findById("bob@gmail.com");
        render();

    }
}
