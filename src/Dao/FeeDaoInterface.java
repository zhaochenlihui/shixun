package Dao;

import java.util.List;

import domain.Fee;

public interface FeeDaoInterface {
	public void addFee(Fee fee);
	public void deleteFee(String[] repairNoList);
	public List<Fee> findAllfeeList();
	public Fee findforRepairByNo(int repairNo);
	public void updateforRepair(Fee fee);
	public List<Fee> findFee(Fee u);
}
