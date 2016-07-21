package service;

import java.sql.Connection;
import Dao.CustomerSureDao;
import domain.CustomerSure;
import utils.DBUtils;
import utils.ServiceException;

public class CustomerSureManagerService {
private static CustomerSureManagerService instance=new CustomerSureManagerService();
	
	public static CustomerSureManagerService getInstance(){
		return instance;
	}
	
	public CustomerSureManagerService(){
	}
	public void addCustomerSure(CustomerSure customerSure) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			CustomerSureDao customerSureDao = new CustomerSureDao(conn);
			DBUtils.beginTransaction(conn);
			customerSureDao.addCustomerSure(customerSure);
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

	/**
	 * �û���ѯ
	 * @param userId    �û�ID
	 * @return userList �û���Ϣʵ��
	 */
	public CustomerSure findCustomerSureByNo(int customerSureNo) {
		CustomerSure customerSure = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			CustomerSureDao customerSureDao = new CustomerSureDao(conn);
			DBUtils.beginTransaction(conn);
			customerSure = customerSureDao.findCustomerSureByNo(customerSureNo);
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
		return customerSure;
	}

	/**
	 * ��ѯ�����û�
	 * @return userList �û���Ϣʵ�弯��
	 */
//	public List<CustomerSure> findAllCustomerSureList() {
//		List<CustomerSure> customerSureList = null;
//		Connection conn = null;
//		try {
//			conn = DBUtils.getConnection();
//			
//			CustomerSureDao customerSureDao = new CustomerSureDao(conn);
//			DBUtils.beginTransaction(conn);
//			customerSureList = customerSureDao.findAllCustomerSureList();
//			DBUtils.commit(conn);
//		} catch (ServiceException e) {
//			throw e;
//		} catch (Exception e) {
//			DBUtils.rollback(conn);
//			throw new ServiceException("�û��б����", e);
//		} finally {
//			DBUtils.closeConnection(conn);
//		}
//		return customerSureList;
//	}

	/**
	 * ɾ���û�
	 * @param userIdList �û�ID����
	 */
	public void deleteCustomerSure(String[] customerSureIdList) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			CustomerSureDao customerSureDao = new CustomerSureDao(conn);
			DBUtils.beginTransaction(conn);
			customerSureDao.deleteCustomerSure(customerSureIdList);
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
	 * @param customerSure �û���Ϣʵ��
	 */
	public void modifyCustomerSure(CustomerSure customerSure) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			CustomerSureDao customerSureDao = new CustomerSureDao(conn);
			DBUtils.beginTransaction(conn);
			customerSureDao.updateCustomerSure(customerSure);
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
