package myApp.client.vi.hom.company.model;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;


public interface Hom04_HistoryModelProperties extends PropertyAccess<Hom04_HistoryModel> {

	ModelKeyProvider<Hom04_HistoryModel> keyId();

	ValueProvider<Hom04_HistoryModel,	Long>	historyId();
	ValueProvider<Hom04_HistoryModel,	Long>	companyId();
	ValueProvider<Hom04_HistoryModel,	String>	historyYm();
	ValueProvider<Hom04_HistoryModel,	String>	careerNote();

}
