package myApp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

import myApp.client.vi.LoginPage;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class wbhtEntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() {
		myApp.client.vi.LoginPage login = new LoginPage(GWT.getModuleBaseURL());	// new ContactPointer();
		login.open();  
	} 
}

