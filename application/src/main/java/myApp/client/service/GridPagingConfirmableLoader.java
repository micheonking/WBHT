package myApp.client.service;

import com.sencha.gxt.data.shared.loader.DataProxy;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoader;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;

import myApp.client.vi.hom.company.model.Hom02_BoardModel;

public class GridPagingConfirmableLoader extends PagingLoader<PagingLoadConfig, PagingLoadResult<Hom02_BoardModel>> {
	public GridPagingConfirmableLoader(DataProxy<PagingLoadConfig, PagingLoadResult<Hom02_BoardModel>> proxy) {
		super(proxy);
	}
	
	public void loadData(PagingLoadConfig config) {
		super.loadData(config);
	}
}
