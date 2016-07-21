package Dao;

import java.util.List;

import domain.Machine;

public interface MachineDaoInterface {
	public void addMachine(Machine mac);
	public void deleteMachine(String[] repairNoList);
	public Machine findforRepairByNo(int repairNo);
	public void updateforRepair(Machine mac);
	public List<Machine> findMachine(Machine u);
}
