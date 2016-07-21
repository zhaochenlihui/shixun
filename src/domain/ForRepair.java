package domain;

import java.sql.Date;

public class ForRepair {
	private int repairNo;
	private int customerNo;
	private String productType;
	private String machineBrand;
	private Date deliverTime;
	private double previewCost;
	private String deliverState;
	public int getRepairNo() {
		return repairNo;
	}
	public void setRepairNo(int repairNo) {
		this.repairNo = repairNo;
	}
	public int getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
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
	public Date getDeliverTime() {
		return deliverTime;
	}
	public void setDeliverTime(Date deliverTime) {
		this.deliverTime = deliverTime;
	}
	public double getPreviewCost() {
		return previewCost;
	}
	public void setPreviewCost(double previewCost) {
		this.previewCost = previewCost;
	}
	public String getDeliverState() {
		return deliverState;
	}
	public void setDeliverState(String deliverState) {
		this.deliverState = deliverState;
	}
	
	
}
