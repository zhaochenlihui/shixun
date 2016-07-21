package service;

import java.sql.Connection;
import Dao.MachineDao;
import domain.Machine;
import utils.DBUtils;
import utils.ServiceException;

public class MachineManagerService {
private static MachineManagerService instance=new MachineManagerService();
	
	public static MachineManagerService getInstance(){
		return instance;
	}
	
	public MachineManagerService(){
	}
	//@Override
	public void addMachine(Machine machine) {
		// TODO Auto-generated method stub
		Connection conn =null;
		try{
			conn= DBUtils.getConnection();
//			System.out.println("1");
			MachineDao machineDao = new MachineDao(conn);
//			System.out.println("0");
			DBUtils.beginTransaction(conn);
//			System.out.println("0");
			machineDao.addMachine(machine);
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			e.printStackTrace();
//			throw new ServiceException("����û�����");
		} finally {
			DBUtils.closeConnection(conn);
		}
	}

	//@Override
	public void deleteMachine(String[] machineIdList) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			MachineDao machineDao = new MachineDao(conn);
			DBUtils.beginTransaction(conn);
			machineDao.deleteMachine(machineIdList);
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			throw new ServiceException("ɾ���û�����", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		
	}

	public void modifyMachine(Machine machine) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			MachineDao machineDao = new MachineDao(conn);
			DBUtils.beginTransaction(conn);
			machineDao.updateMachine(machine);
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			e.printStackTrace();
//			throw new ServiceException("�޸��û�����", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	}

	/*public List<Machine> findAllMachine() {
		// TODO Auto-generated method stub
		List<Machine> machineList = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			
			MachineDao machineDao = new MachineDao(conn);
			DBUtils.beginTransaction(conn);
			machineList = machineDao.findAllMachineList();
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			throw new ServiceException("�û��б����", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return machineList;
	}*/

	public Machine findMachineByNo(int machineNo) {
		// TODO Auto-generated method stub
		Machine res= null;
		Connection conn = null;
		try {
		conn = DBUtils.getConnection();
		System.out.println(conn);	
			MachineDao machineDao = new MachineDao(conn);
			DBUtils.beginTransaction(conn);
			res = machineDao.findMachineByNo(machineNo);
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			//throw new ServiceException("�û��б����", e);
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return res;	}
}
