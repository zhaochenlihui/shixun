package domain;

import java.sql.Date;

public class SparePart {

	private String PartName;
	private String Vesion;
	private int Price;
	private int Amount;
	private Date InTime;
	private int AlertAmount;
	private String StockState;
	
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
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public Date getInTime() {
		return InTime;
	}
	public void setInTime(Date inTime) {
		InTime = inTime;
	}
	public int getAlertAmount() {
		return AlertAmount;
	}
	public void setAlertAmount(int alertAmount) {
		AlertAmount = alertAmount;
	}
	public String getStockState() {
		return StockState;
	}
	public void setStockState(String stockState) {
		StockState = stockState;
	}
	
}
