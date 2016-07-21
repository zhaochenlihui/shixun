package service;

import java.sql.Connection;

import Dao.ClearFeeDao;
import domain.ClearFee;
import utils.DBUtils;
import utils.ServiceException;

public class ClearFeeManagerService {
	private static ClearFeeManagerService instance=new ClearFeeManagerService();

	public static ClearFeeManagerService getInstance(){
		return instance;
	}
	
	public ClearFeeManagerService(){
	}
	public void addClearFee(ClearFee clearFee) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
//			System.out.println("wo jiao fan ping an");
			ClearFeeDao clearFeeDao = new ClearFeeDao(conn);
//			System.out.println("wo jiao fan ping an");
			DBUtils.beginTransaction(conn);
//			System.out.println("wo jiao fan ping an");
			clearFeeDao.addClearFee(clearFee);
//			System.out.println("wo jiao fan ping an");
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			e.printStackTrace();
			throw new ServiceException("����û�����");
		} finally {
			DBUtils.closeConnection(conn);
		}
	}

	/**
	 * �û���ѯ
	 * @param userId    �û�ID
	 * @return userList �û���Ϣʵ��
	 */
	public ClearFee findClearFeeByNo(int clearFeeNo) {
		ClearFee clearFee = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			ClearFeeDao clearFeeDao = new ClearFeeDao(conn);
			DBUtils.beginTransaction(conn);
			clearFee = clearFeeDao.findClearFeeByNo(clearFeeNo);
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			throw new ServiceException("��ѯ�û�����", e);
			//e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return clearFee;
	}

	/**
	 * ��ѯ�����û�
	 * @return userList �û���Ϣʵ�弯��
	 */
//	public List<ClearFee> findAllClearFeeList() {
//		List<ClearFee> clearFeeList = null;
//		Connection conn = null;
//		try {
//			conn = DBUtils.getConnection();
//			
//			ClearFeeDao clearFeeDao = new ClearFeeDao(conn);
//			DBUtils.beginTransaction(conn);
//			clearFeeList = clearFeeDao.findClearFee(u)
//			DBUtils.commit(conn);
//		} catch (ServiceException e) {
//			throw e;
//		} catch (Exception e) {
//			DBUtils.rollback(conn);
//			throw new ServiceException("�û��б����", e);
//		} finally {
//			DBUtils.closeConnection(conn);
//		}
//		return clearFeeList;
//	}

	/**
	 * ɾ���û�
	 * @param userIdList �û�ID����
	 */
	public void deleteClearFee(String[] clearFeeIdList) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			ClearFeeDao clearFeeDao = new ClearFeeDao(conn);
			DBUtils.beginTransaction(conn);
			clearFeeDao.deleteClearFee(clearFeeIdList);
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

	/**
	 * �޸��û���Ϣ
	 * @param clearFee �û���Ϣʵ��
	 */
	public void modifyClearFee(ClearFee clearFee) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			ClearFeeDao clearFeeDao = new ClearFeeDao(conn);
			DBUtils.beginTransaction(conn);
			clearFeeDao.updateClearFee(clearFee);;
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
}
