package domain;

import java.sql.Date;

public class Repair {

	private int repairNo;
	private String repairWork;
	private String testRecord;
	private String repairRecord;
	private Date testTime;
	private String workAmount;
	private String usePart;
	private String repairState;
	public int getRepairNo() {
		return repairNo;
	}
	public void setRepairNo(int repairNo) {
		this.repairNo = repairNo;
	}
	public String getRepairWork() {
		return repairWork;
	}
	public void setRepairWork(String repairWork) {
		this.repairWork = repairWork;
	}
	public String getTestRecord() {
		return testRecord;
	}
	public void setTestRecord(String testRecord) {
		this.testRecord = testRecord;
	}
	public String getRepairRecord() {
		return repairRecord;
	}
	public void setRepairRecord(String repairRecord) {
		this.repairRecord = repairRecord;
	}
	public Date getTestTime() {
		return testTime;
	}
	public void setTestTime(Date testTime) {
		this.testTime = testTime;
	}
	public String getWorkAmount() {
		return workAmount;
	}
	public void setWorkAmount(String workAmount) {
		this.workAmount = workAmount;
	}
	public String getUsePart() {
		return usePart;
	}
	public void setUsePart(String usePart) {
		this.usePart = usePart;
	}
	public String getRepairState() {
		return repairState;
	}
	public void setRepairState(String repairState) {
		this.repairState = repairState;
	}
}
