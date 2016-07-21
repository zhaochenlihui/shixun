package Dao;

import java.util.List;

import domain.ForRepair;

public interface ForRepairDaoInterface {
	public void addForRepair(ForRepair forRepair);
	public void deleteForRepair(String[] repairNoList);
	public List<ForRepair> findAllforRepairList();
	public ForRepair findforRepairByNo(int repairNo);
	public void updateforRepair(ForRepair forRepair);
	public List<ForRepair> findForRepair(ForRepair u);
}
