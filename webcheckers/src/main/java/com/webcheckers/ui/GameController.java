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
public class GameController implements TemplateViewRoute {

  private final IGameCenter gameCenter;

	/**
	 * The constructor for the {@code GET /game} route handler.
	 *
	 * @param gameCenter
	 *    The {@link GameCenter} for the application.
	 */
	public GameController(final IGameCenter gameCenter) {
		// validation
		Objects.requireNonNull(gameCenter, "gameCenter must not be null");
		//
		this.gameCenter = gameCenter;
	}

  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    vm.put("title", "Welcome!");
		vm.put("playerName", "test1");
		vm.put("playerColor", "RED");
		vm.put("opponentName", "test2");
		vm.put("opponentColor", "WHITE");
		vm.put("isMyTurn", true);
		try {
			vm.put("board", gameCenter.getBoardView(0, 0));
		} catch (Exception e) {
			;
		}


    return new ModelAndView(vm , "game.ftl");
  }

}
