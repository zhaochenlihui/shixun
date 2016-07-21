package service;

import java.sql.Connection;
import java.util.List;

import Dao.SparePartDao;
import domain.SparePart;
import utils.DBUtils;
import utils.ServiceException;

public class SparePartManagerService {
private static SparePartManagerService instance=new SparePartManagerService();
	
	public static SparePartManagerService getInstance(){
		return instance;
	}
	
	public SparePartManagerService(){
	}
	//@Override
	public void addSparePart(SparePart sparePart) {
		// TODO Auto-generated method stub
		Connection conn =null;
		try{
			conn= DBUtils.getConnection();
			System.out.println("1");
			SparePartDao sparePartDao = new SparePartDao(conn);
			System.out.println("0");
			DBUtils.beginTransaction(conn);
			System.out.println("0");
			sparePartDao.addSparePart(sparePart);
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
	public void deleteSparePart(String[] sparePartIdList) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			SparePartDao sparePartDao = new SparePartDao(conn);
			DBUtils.beginTransaction(conn);
			sparePartDao.deleteSparePart(sparePartIdList);
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

	public void modifySparePart(SparePart sparePart) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			SparePartDao sparePartDao = new SparePartDao(conn);
			DBUtils.beginTransaction(conn);
			sparePartDao.modifySparePart(sparePart);
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

	public List<SparePart> findAllSparePart() {
		// TODO Auto-generated method stub
		List<SparePart> sparePartList = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			
			SparePartDao sparePartDao = new SparePartDao(conn);
			DBUtils.beginTransaction(conn);
			sparePartList = sparePartDao.findAllSparePartList();
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			throw new ServiceException("�û��б����", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return sparePartList;
	}

	public SparePart findSparePartByNo(String sparePartNo) {
		// TODO Auto-generated method stub
		SparePart res= null;
		Connection conn = null;
		try {
		conn = DBUtils.getConnection();
		System.out.println(conn);	
			SparePartDao sparePartDao = new SparePartDao(conn);
			DBUtils.beginTransaction(conn);
			res = sparePartDao.findSparePartByName(sparePartNo);
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
