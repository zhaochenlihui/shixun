package domain;

import java.sql.Date;



public class CustomerSure {
	private Date reserveTime;           // ��������
	private int repairNo;               // ά�ޱ��
	private String productType;         // ��Ʒ����
	private String machineBrand;        // ����Ʒ��
	private String machineVersion;      // �����ͺ�
	private String seriesNumber;        // �����ͺ�
	private String company;             // ��˾���
	private String linkmen;             // ��ϵ��
	private String failureAppear;       // ������������
	private String lockPart;            // ȱ�����
	private String attachment;          // ����
	public Date getReserveTime() {
		return reserveTime;
	}
	public void setReserveTime(Date reserveTime) {
		this.reserveTime = reserveTime;
	}
	public int getRepairNo() {
		return repairNo;
	}
	public void setRepairNo(int repairNo) {
		this.repairNo = repairNo;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getMachineBrand() {
		return machineBrand;
	}
	public void setMachineBrand(String machineBrand) {
		this.machineBrand = machineBrand;
	}
	public String getMachineVersion() {
		return machineVersion;
	}
	public void setMachineVersion(String machineVersion) {
		this.machineVersion = machineVersion;
	}
	public String getSeriesNumber() {
		return seriesNumber;
	}
	public void setSeriesNumber(String seriesNumber) {
		this.seriesNumber = seriesNumber;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getLinkmen() {
		return linkmen;
	}
	public void setLinkmen(String linkmen) {
		this.linkmen = linkmen;
	}
	public String getFailureAppear() {
		return failureAppear;
	}
	public void setFailureAppear(String failureAppear) {
		this.failureAppear = failureAppear;
	}
	public String getLockPart() {
		return lockPart;
	}
	public void setLockPart(String lockPart) {
		this.lockPart = lockPart;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
	
}
