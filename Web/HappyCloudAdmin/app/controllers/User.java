
package controllers;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class User extends Controller{
	
	@Before
	static void setConnectedUser() {
		
		if (Security.isConnected()) {
				renderArgs.put("user", "Admin");
			}
	}
	
	public static void index() {
		render();
	}

}
