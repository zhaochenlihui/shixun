package Dao;

import java.util.List;

import domain.Repair;

public interface RepairDaoInterface {
	public void addRepair(Repair repair);
	public void deleteRepair(String[] repairNoList);
	public  List<Repair> findAllRepairList();
	public Repair findRepairByNo(int repairNo);
	public void modifyRepair(Repair repair);
}
