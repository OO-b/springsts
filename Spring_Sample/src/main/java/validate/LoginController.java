package validate;

import javax.naming.AuthenticationException;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.net.httpserver.Authenticator;

@Controller
@RequestMapping("/auth/login")
public class LoginController {
	
	private static final String LOGIN_FORM = "auth/loginForm";
	private Authenticator authenticator;
	
	@RequestMapping(method = RequestMethod.GET)
	public String loginForm(LoginCommand loginCommand) {
		return LOGIN_FORM;
	}
	
	public String login(@Valid LoginCommand loginCommand, Errors errors) {
		if(errors.hasErrors()) {
			return LOGIN_FORM;
		}
		
		try {
			authenticator.authenticate(
					loginCommand.getEmail(),loginCommand.getPassword());
			return "redirect:/index.jsp";
			
		}catch(AuthenticationException ex) {
			errors.reject("invalidIdOrPassword");
			return LOGIN_FORM;
		}
	}
	
		@InitBinder
		protected void initBinder(WebDataBinder binder) {
			binder.setValidator(new LoginCommand());
		}
		public void setAuthenticator(Authenticator authenticator) {
			this.authenticator = authenticator;
		}
}
