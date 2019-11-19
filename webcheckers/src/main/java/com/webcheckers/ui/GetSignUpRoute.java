package com.webcheckers.ui;

import java.util.HashMap;
import java.util.Map;

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
public class GetSignUpRoute implements TemplateViewRoute {

	static final String ERROR_MESSAGE = "signupError";
	static final String MESSAGE_ATTR = "message";
	static final String INVALID_EMAIL_MESSAGE = "Please enter a valid e-mail.";
	static final String USER_TAKEN_MESSAGE = "This username is already in use.";
	static final String UNMATCHED_PASSWORD_MESSAGE = "Passwords must match.";
	static final String INVALID_PASSWORD_MESSAGE = " The password has to be a minimum of eight (8) characters in length, contain at least one (1) character from three (3) of the following categories: Uppercase letter (A-Z) Lowercase letter (a-z) Digit (0-9).";

  static final String VIEW_NAME = "signin.ftl";

	private static PasswordValidator passwordValidator;

	static {
      passwordValidator = new PasswordValidator();
  }

  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    vm.put("title", "Sign In");

		final String email = request.queryParams("email");
		final String user = request.queryParams("user");
		final String password = request.queryParams("password");
		final String confirm = request.queryParams("confirm");

		vm.put("email", email);
		vm.put("user", user);

		boolean allowLocal = true;
		// userTaken is dummy variable, remove once proper interface is implemented
		boolean userTaken = false;
		if (!EmailValidator.getInstance(allowLocal).isValid(email)) {
			return error(vm, INVALID_EMAIL_MESSAGE);
		} else if (userTaken) {
			return error(vm, USER_TAKEN_MESSAGE);
		} else if (!password.equals(confirm)) {
			return error(vm, UNMATCHED_PASSWORD_MESSAGE);
		} else if (!passwordValidator.validate(password)) {
			return error(vm, INVALID_PASSWORD_MESSAGE);
		} else {
			//to be implemented once we have a GameCenter
		}

    return new ModelAndView(vm , VIEW_NAME);
  }

	private ModelAndView error(final Map<String, Object> vm, final String message) {
	vm.put(ERROR_MESSAGE, true);
	vm.put(MESSAGE_ATTR, message);
	return new ModelAndView(vm, VIEW_NAME);
}

}
