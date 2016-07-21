package service;

import java.sql.Connection;
import java.util.List;

import Dao.FeeDao;
import domain.Fee;
import utils.DBUtils;
import utils.ServiceException;

public class FeeManagerService {
private static FeeManagerService instance=new FeeManagerService();
	
	public static FeeManagerService getInstance(){
		return instance;
	}
	
	public FeeManagerService(){
	}
	//@Override
	public void addFee(Fee fee) {
		// TODO Auto-generated method stub
		Connection conn =null;
		try{
			conn= DBUtils.getConnection();
			System.out.println("1");
			FeeDao feeDao = new FeeDao(conn);
			System.out.println("0");
			DBUtils.beginTransaction(conn);
			System.out.println("0");
			feeDao.addFee(fee);
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
	public void deleteFee(String[] feeIdList) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			FeeDao feeDao = new FeeDao(conn);
			DBUtils.beginTransaction(conn);
			feeDao.deleteFee(feeIdList);
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

	public void modifyFee(Fee fee) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			FeeDao feeDao = new FeeDao(conn);
			DBUtils.beginTransaction(conn);
			feeDao.addFee(fee);
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

	public List<Fee> findAllFee() {
		// TODO Auto-generated method stub
		List<Fee> feeList = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			
			FeeDao feeDao = new FeeDao(conn);
			DBUtils.beginTransaction(conn);
			feeList = feeDao.findAllfeeList();
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			throw new ServiceException("�û��б����", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return feeList;
	}

	public Fee findFeeByNo(int feeNo) {
		// TODO Auto-generated method stub
		Fee res= null;
		Connection conn = null;
		try {
		conn = DBUtils.getConnection();
		System.out.println(conn);	
			FeeDao feeDao = new FeeDao(conn);
			DBUtils.beginTransaction(conn);
			res = feeDao.findFeeByNo(feeNo);
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
