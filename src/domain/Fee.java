package domain;

import java.sql.Date;

public class Fee {
	private int repairNo;            // ά�ޱ��
	private float repairCost;        // ά�޷���
	private float materialCost;      // ���Ϸ���
	private String warranty;         // ���޳�ŵ
	private String attention;        // ע������
	private Date clearTime;          // ��������
	public int getRepairNo() {
		return repairNo;
	}
	public void setRepairNo(int repairNo) {
		this.repairNo = repairNo;
	}
	public float getRepairCost() {
		return repairCost;
	}
	public void setRepairCost(float repairCost) {
		this.repairCost = repairCost;
	}
	public float getMaterialCost() {
		return materialCost;
	}
	public void setMaterialCost(float materialCost) {
		this.materialCost = materialCost;
	}
	public String getWarranty() {
		return warranty;
	}
	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}
	public String getAttention() {
		return attention;
	}
	public void setAttention(String attention) {
		this.attention = attention;
	}
	public Date getClearTime() {
		return clearTime;
	}
	public void setClearTime(Date clearTime) {
		this.clearTime = clearTime;
	}
	
}
