package domain;

import java.sql.Date;

public class SparePartOut {
	
	private String PartName;
	private String Vesion;
	private int RepairNO;
	private int Amount;
	private int Price;
	private Date OutTime;
	public String getPartName() {
		return PartName;
	}
	public void setPartName(String partName) {
		PartName = partName;
	}
	public String getVesion() {
		return Vesion;
	}
	public void setVesion(String vesion) {
		Vesion = vesion;
	}
	public int getRepairNO() {
		return RepairNO;
	}
	public void setRepairNO(int repairNO) {
		RepairNO = repairNO;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public Date getOutTime() {
		return OutTime;
	}
	public void setOutTime(Date outTime) {
		OutTime = outTime;
	}
	
	
	
	
}

