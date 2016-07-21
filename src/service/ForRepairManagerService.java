package service;

import java.sql.Connection;
import java.util.List;

import Dao.ForRepairDao;
import domain.ForRepair;
import utils.DBUtils;
import utils.ServiceException;

public class ForRepairManagerService {
private static ForRepairManagerService instance=new ForRepairManagerService();
	
	public static ForRepairManagerService getInstance(){
		return instance;
	}
	
	public ForRepairManagerService(){
	}
	//@Override
	public void addForRepair(ForRepair forRepair) {
		// TODO Auto-generated method stub
		Connection conn =null;
		try{
			conn= DBUtils.getConnection();
			ForRepairDao forRepairDao = new ForRepairDao(conn);
			DBUtils.beginTransaction(conn);
			forRepairDao.addForRepair(forRepair);
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
	public void deleteForRepair(String[] forRepairIdList) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			ForRepairDao forRepairDao = new ForRepairDao(conn);
			DBUtils.beginTransaction(conn);
			forRepairDao.deleteForRepair(forRepairIdList);
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

	public void modifyForRepair(ForRepair forRepair) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			ForRepairDao forRepairDao = new ForRepairDao(conn);
			DBUtils.beginTransaction(conn);
			forRepairDao.updateforRepair(forRepair);
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			throw new ServiceException("�޸��û�����", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	}

	public List<ForRepair> findAllForRepair() {
		// TODO Auto-generated method stub
		List<ForRepair> forRepairList = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			
			ForRepairDao forRepairDao = new ForRepairDao(conn);
			DBUtils.beginTransaction(conn);
			forRepairList = forRepairDao.findAllforRepairList();
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			throw new ServiceException("�û��б����", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return forRepairList;
	}

	public ForRepair findForRepairByNo(int forRepairNo) {
		// TODO Auto-generated method stub
		ForRepair res= null;
		Connection conn = null;
		try {
		conn = DBUtils.getConnection();
		System.out.println(conn);	
			ForRepairDao forRepairDao = new ForRepairDao(conn);
			DBUtils.beginTransaction(conn);
			res = forRepairDao.findforRepairByNo(forRepairNo);
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

