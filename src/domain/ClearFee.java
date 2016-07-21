package domain;

import java.sql.Date;


public class ClearFee {
	private int repairNo;                  // ά�ޱ��
	private Date reserveTime;              // ά������
	private Date repairedTime;             // �޸�ʱ��
	private String productType;            // ��Ʒ����
	private String machineBrand;           // ����Ʒ��
	private String seriesNumber;           // ϵ�к�
	private String company;                // ��λ���
	private String linkmen;                // ��ϵ��
	private double moneySum;               // �ϼƽ��
	private double repairCost;              // ά�޷���
	private double materialCost;            // ���Ϸ���
	private String failureType;            // ��������
	private String warranty;               // ���޳�ŵ
	private String attention;              // ע������
	private String partName;               // �������
	private String version;                // �ͺ�
	private int amount;                    // ����
	private double price;                   // ����
	public int getRepairNo() {
		return repairNo;
	}
	public void setRepairNo(int repairNo) {
		this.repairNo = repairNo;
	}
	public Date getReserveTime() {
		return reserveTime;
	}
	public void setReserveTime(Date reserveTime) {
		this.reserveTime = reserveTime;
	}
	public Date getRepairedTime() {
		return repairedTime;
	}
	public void setRepairedTime(Date repairedTime) {
		this.repairedTime = repairedTime;
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
	public double getMoneySum() {
		return moneySum;
	}
	public void setMoneySum(double moneySum) {
		this.moneySum = moneySum;
	}
	public double getRepairCost() {
		return repairCost;
	}
	public void setRepairCost(double repairCost) {
		this.repairCost = repairCost;
	}
	public double getMaterialCost() {
		return materialCost;
	}
	public void setMaterialCost(double materialCost) {
		this.materialCost = materialCost;
	}
	public String getFailureType() {
		return failureType;
	}
	public void setFailureType(String failureType) {
		this.failureType = failureType;
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
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
