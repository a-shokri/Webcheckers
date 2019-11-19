package com.webcheckers.ui;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

/**
 * The Web Controller for the Home page.
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 */
public class GetSignInRoute implements TemplateViewRoute {

	static final String INVALID_SIGNIN_ATTR = "invalidSignIn";
	static final String INVALID_SIGNIN_MESSAGE = "Username or password is invalid.";

  static final String VIEW_NAME = "signin.ftl";

	// private final GameCenter gameCenter;
	//
	// /**
	//  * The constructor for the {@code GET /game} route handler.
	//  *
	//  * @param gameCenter
	//  *    The {@link GameCenter} for the application.
	//  */
	// GetSignInRoute(final GameCenter gameCenter) {
	// 	// validation
	// 	Objects.requireNonNull(gameCenter, "gameCenter must not be null");
	// 	//
	// 	this.gameCenter = gameCenter;
	// }



  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    vm.put("title", "Sign In");

		final String user = request.queryParams("user");

		// if (user.equals("") || !gameCenter.validateUser(user)) {
		// 	vm.put(INVALID_SIGNIN_ATTR, INVALID_SIGNIN_MESSAGE);
		// }

    return new ModelAndView(vm , VIEW_NAME);
  }

}
