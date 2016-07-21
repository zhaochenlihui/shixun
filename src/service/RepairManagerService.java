package service;

import java.sql.Connection;
import java.util.List;

import Dao.RepairDao;
import domain.Repair;
import utils.DBUtils;
import utils.ServiceException;

public class RepairManagerService {
private static RepairManagerService instance=new RepairManagerService();
	
	public static RepairManagerService getInstance(){
		return instance;
	}
	
	public RepairManagerService(){
	}
	//@Override
	public void addRepair(Repair repair) {
		// TODO Auto-generated method stub
		Connection conn =null;
		try{
			conn= DBUtils.getConnection();
			RepairDao repairDao = new RepairDao(conn);
			DBUtils.beginTransaction(conn);
			repairDao.addRepair(repair);
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			throw new ServiceException("����û�����");
		} finally {
			DBUtils.closeConnection(conn);
		}
	}

	//@Override
//	public void deleteRepair(String[] repairIdList) {
//		// TODO Auto-generated method stub
//		Connection conn = null;
//		try {
//			conn = DBUtils.getConnection();
//			RepairDao repairDao = new RepairDao(conn);
//			DBUtils.beginTransaction(conn);
//			repairDao.deleteRepair(repairIdList);
//			DBUtils.commit(conn);
//		} catch (ServiceException e) {
//			throw e;
//		} catch (Exception e) {
//			DBUtils.rollback(conn);
//			throw new ServiceException("ɾ���û�����", e);
//		} finally {
//			DBUtils.closeConnection(conn);
//		}
//		
//	}
	public void deleteRepairbyNo(int t) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			RepairDao repairDao = new RepairDao(conn);
			DBUtils.beginTransaction(conn);
			repairDao.deleteRepairbyNo(t);
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
	public void modifyRepair(Repair repair) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			RepairDao repairDao = new RepairDao(conn);
			DBUtils.beginTransaction(conn);
			repairDao.modifyRepair(repair);
			DBUtils.commit(conn);
			System.out.println("wojiaofanpingan");
		} catch (ServiceException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			e.printStackTrace();
//			throw new ServiceException("�޸��û�����", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	}

	public List<Repair> findAllRepair() {
		// TODO Auto-generated method stub
		List<Repair> repairList = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			
			RepairDao repairDao = new RepairDao(conn);
			DBUtils.beginTransaction(conn);
			repairList = repairDao.findAllRepairList();
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			throw new ServiceException("�û��б����", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return repairList;
	}

	public Repair findRepairByNo(int repairNo) {
		// TODO Auto-generated method stub
		Repair res= null;
		Connection conn = null;
		try {
		conn = DBUtils.getConnection();
		System.out.println(conn);	
			RepairDao repairDao = new RepairDao(conn);
			DBUtils.beginTransaction(conn);
			res = repairDao.findRepairByNo(repairNo);
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
