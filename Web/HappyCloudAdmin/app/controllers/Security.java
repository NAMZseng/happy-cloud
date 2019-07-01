package controllers;

public class Security extends Secure.Security {

	public static boolean authenticate(String schoolId, String passwd) {

		// 管理员账号默认设置为root/root
		boolean ret = schoolId != null && passwd != null
				&& (schoolId.equals("root") && passwd.equals("root"));
		
		session.put("currentUser", schoolId);
		return ret;
	}
	
	public static void onAuthenticated() {
		User.index();
	}
	
	public static void onDisconnected() {
		Application.index();
	}
	
	public static boolean check(String profile) {
		if (Security.isConnected()) {
			String user = Security.connected();
			if ("Root".equals(profile) && user.equals("root")) {
				return true;
			}
		}
		return false;
	}
}
