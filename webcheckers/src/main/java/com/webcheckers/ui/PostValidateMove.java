package com.webcheckers.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

import com.webcheckers.Application;

import com.webcheckers.util.Message;

import com.webcheckers.appl.IGameCenter;

import com.webcheckers.model.HumanPlayer;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;


/**
 * The Web Controller for the Home page.
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 */
public class PostValidateMove implements Route {

	private final IGameCenter gameCenter;
	static final String HOME_NAME = "home.ftl";

	/**
	 * The constructor for the {@code GET /game} route handler.
	 *
	 * @param gameCenter
	 *    The {@link GameCenter} for the application.
	 */
	public PostValidateMove(final IGameCenter gameCenter) {
		// validation
		Objects.requireNonNull(gameCenter, "gameCenter must not be null");
		//
		this.gameCenter = gameCenter;
	}

  @Override
  public Object handle(Request request, Response response) {
		// response.type("ERROR");
		Message message = new Message("Test", Message.Type.INFO);
		response.body( "{\"text\":\"Test\", \"type\":\"ERROR\"}" );
		response.status(200);
	  return "{\"text\":\"Test\", \"type\":\"ERROR\"}";
  }

}
