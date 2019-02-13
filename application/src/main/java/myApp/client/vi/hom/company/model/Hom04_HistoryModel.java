package myApp.client.vi.hom.company.model;

import java.util.Date;
import myApp.client.utils.GridDataModel;

public class Hom04_HistoryModel implements GridDataModel {

	private	Long	historyId;
	private	Long	companyId;
	private	String	historyYm;
	private	String	careerNote;

	@Override
	public void setKeyId(Long id) {
		this.setHistoryId(id);
	}

	@Override
	public Long getKeyId() {
		return this.getHistoryId();
	}

	public	Long getHistoryId() {
		return	historyId;
	}

	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getHistoryYm() {
		return historyYm;
	}

	public void setHistoryYm(String historyYm) {
		this.historyYm = historyYm;
	}

	public String getCareerNote() {
		return careerNote;
	}

	public void setCareerNote(String careerNote) {
		this.careerNote = careerNote;
	}

}
