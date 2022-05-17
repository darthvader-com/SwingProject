package swt.apps.controller;

import swt.apps.views.SignInFrameView;

public class MainController {

	public void popSignIn() {
		new SignInFrameView().setLocationRelativeTo(null);
	}

}
