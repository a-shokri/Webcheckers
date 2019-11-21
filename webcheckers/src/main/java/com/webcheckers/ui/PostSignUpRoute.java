package com.webcheckers.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.webcheckers.appl.GameCenter;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import org.apache.commons.validator.routines.EmailValidator;

/**
 * The Web Controller for the Home page.
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 */
public class PostSignUpRoute implements TemplateViewRoute {

	static final String MESSAGE_TYPE_ATTR = "messageType";
	static final String ERROR_MESSAGE_TYPE = "error";
	static final String INFO_MESSAGE_TYPE = "info";

	static final String MESSAGE_ATTR = "message";
	static final String SUCCESS_MESSAGE = "Yay, you've been registered! Please sign in on the left.";
	static final String INVALID_EMAIL_MESSAGE = "Please enter a valid e-mail.";
	static final String UNMATCHED_PASSWORD_MESSAGE = "Passwords must match.";
	static final String INVALID_PASSWORD_MESSAGE = " The password has to be a minimum of eight (8) characters in length, contain at least one (1) character from three (3) of the following categories: Uppercase letter (A-Z) Lowercase letter (a-z) Digit (0-9).";

  static final String VIEW_NAME = "signin.ftl";

	private static PasswordValidator passwordValidator;

	private final GameCenter gameCenter;

	/**
	 * The constructor for the {@code GET /game} route handler.
	 *
	 * @param gameCenter
	 *    The {@link GameCenter} for the application.
	 */
	public PostSignUpRoute(final GameCenter gameCenter) {
		// validation
		Objects.requireNonNull(gameCenter, "gameCenter must not be null");
		//
		this.gameCenter = gameCenter;
	}

	static {
      passwordValidator = new PasswordValidator();
  }

  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    vm.put("title", "Sign In");

		String email = request.queryParams("email");
		String user = request.queryParams("user");
		String password = request.queryParams("password");
		String confirm = request.queryParams("confirm");

		Map<String, String> registrationInfo = new HashMap<>();
		registrationInfo.put("email", email);
		registrationInfo.put("user", user);
		registrationInfo.put("password", password);
		registrationInfo.put("confirm", confirm);

		//variable for allowing local e-mail addresses (e.g. rit.edu)
		boolean ALLOW_LOCAL = true;
		if (!EmailValidator.getInstance(ALLOW_LOCAL).isValid(email)) {
			return error(vm, INVALID_EMAIL_MESSAGE, registrationInfo);
		} else if (!password.equals(confirm)) {
			return error(vm, UNMATCHED_PASSWORD_MESSAGE, registrationInfo);
		} else if (!passwordValidator.validate(password)) {
			return error(vm, INVALID_PASSWORD_MESSAGE, registrationInfo);
		} else {
			try {
				gameCenter.registerUser(registrationInfo);
				vm.put("title", "Sign In");
				vm.put(MESSAGE_TYPE_ATTR, INFO_MESSAGE_TYPE);
				vm.put(MESSAGE_ATTR, SUCCESS_MESSAGE);
				return new ModelAndView(vm , VIEW_NAME);
			} catch (Exception e) {
				return error(vm, e.getMessage(), registrationInfo);
			}
		}
	}

	private ModelAndView error(final Map<String, Object> vm, final String message, final Map<String,String> registrationInfo) {
		vm.put("title", "Sign Up");
		vm.put("email", registrationInfo.get("email"));
		vm.put("user", registrationInfo.get("user"));
		vm.put("password", registrationInfo.get("password"));
		vm.put("confirm", registrationInfo.get("confirm"));
		vm.put(MESSAGE_TYPE_ATTR, ERROR_MESSAGE_TYPE);
		vm.put(MESSAGE_ATTR, message);
		return new ModelAndView(vm, VIEW_NAME);
	}

}
