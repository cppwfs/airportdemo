package controllers;

import java.util.ArrayList;

import models.Airport;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {
	final static Form<Airport> contactForm = form(Airport.class);

	public static Result index() {
		
		ArrayList<String> locations = new ArrayList<String>();
		locations.add("Tampa, FL, United States");
		locations.add("Orlando, FL, UnitedStates");
		// index.renderArgs.put("locations",locations);
		// Application.session("testParm", "wohoo");
		
		
		// return ok();
		return ok(index.render("Your new application is ready."));
	}

}