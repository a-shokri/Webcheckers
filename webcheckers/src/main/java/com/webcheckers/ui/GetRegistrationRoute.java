package com.webcheckers.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.webcheckers.appl.GameCenter;

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
public class GetRegistrationRoute implements TemplateViewRoute {

  static final String SIGNIN_NAME = "signin.ftl";

	private final IGameCenter gameCenter;

	/**
	 * The constructor for the {@code GET /game} route handler.
	 *
	 * @param gameCenter
	 *    The {@link GameCenter} for the application.
	 */
	public GetRegistrationRoute(final IGameCenter gameCenter) {
		// validation
		Objects.requireNonNull(gameCenter, "gameCenter must not be null");
		//
		this.gameCenter = gameCenter;
	}

  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();

		vm.put("title", "Sign In");
    return new ModelAndView(vm , SIGNIN_NAME);
		}

}
