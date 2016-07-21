package service;

import java.sql.Connection;
import java.util.List;

import Dao.SparePartOutDao;
import domain.SparePartOut;
import utils.DBUtils;
import utils.ServiceException;

public class SparePartOutManagerService {
private static SparePartOutManagerService instance=new SparePartOutManagerService();
	
	public static SparePartOutManagerService getInstance(){
		return instance;
	}
	
	public SparePartOutManagerService(){
	}
	//@Override
	public void addSparePartOut(SparePartOut sparePartOut) {
		// TODO Auto-generated method stub
		Connection conn =null;
		try{
			conn= DBUtils.getConnection();
			System.out.println("1");
			SparePartOutDao sparePartOutDao = new SparePartOutDao(conn);
			System.out.println("0");
			DBUtils.beginTransaction(conn);
			System.out.println("0");
			sparePartOutDao.addSparePartOut(sparePartOut);
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
	public void deleteSparePartOut(String[] sparePartOutIdList) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			SparePartOutDao sparePartOutDao = new SparePartOutDao(conn);
			DBUtils.beginTransaction(conn);
			sparePartOutDao.deleteSparePartOut(sparePartOutIdList);
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

	public void modifySparePartOut(SparePartOut sparePartOut) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			SparePartOutDao sparePartOutDao = new SparePartOutDao(conn);
			DBUtils.beginTransaction(conn);
			sparePartOutDao.modifySparePartOut(sparePartOut);
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

	public List<SparePartOut> findAllSparePartOut() {
		// TODO Auto-generated method stub
		List<SparePartOut> sparePartOutList = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			
			SparePartOutDao sparePartOutDao = new SparePartOutDao(conn);
			DBUtils.beginTransaction(conn);
			sparePartOutList = sparePartOutDao.findAllSparePartOutList();
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			e.printStackTrace();
//			throw new ServiceException("�û��б����", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return sparePartOutList;
	}

	public SparePartOut findSparePartOutByNo(String partName) {
		// TODO Auto-generated method stub
		SparePartOut res= null;
		Connection conn = null;
		try {
		conn = DBUtils.getConnection();
		System.out.println(conn);	
			SparePartOutDao sparePartOutDao = new SparePartOutDao(conn);
			DBUtils.beginTransaction(conn);
			res = sparePartOutDao.findSparePartOutByName(partName);
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
