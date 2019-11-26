package com.webcheckers.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.webcheckers.appl.IGameCenter;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

/**
 * The Web Controller for the Home page.
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 */
public class PostSignOutRoute implements TemplateViewRoute {

	static final String CURRENT_USER_ATTR = "currentUser";

	static final String HOME_NAME = "home.ftl";

	private final IGameCenter gameCenter;

	/**
	 * The constructor for the {@code GET /game} route handler.
	 *
	 * @param gameCenter
	 *    The {@link GameCenter} for the application.
	 */
	public PostSignOutRoute(final IGameCenter gameCenter) {
		// validation
		Objects.requireNonNull(gameCenter, "gameCenter must not be null");
		//
		this.gameCenter = gameCenter;
	}



  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();

		request.session().removeAttribute("user");

		vm.put("title", "Home");
		vm.put(CURRENT_USER_ATTR, false);
	  return new ModelAndView(vm , HOME_NAME);
  }

}
