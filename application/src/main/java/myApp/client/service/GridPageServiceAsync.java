package myApp.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

import myApp.client.vi.hom.company.model.Hom02_BoardModel;

public interface GridPageServiceAsync {
	void getData(PagingLoadConfig config, AsyncCallback<PagingLoadResult<Hom02_BoardModel>> callback); 
}
