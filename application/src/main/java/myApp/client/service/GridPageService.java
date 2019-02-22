package myApp.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

import myApp.client.vi.hom.company.model.Hom02_BoardModel;

public interface GridPageService extends RemoteService {
	PagingLoadResult<Hom02_BoardModel> getData(PagingLoadConfig config); 
}
