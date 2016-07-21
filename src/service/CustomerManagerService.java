package service;

import java.sql.Connection;
import java.util.List;

import Dao.CustomerDao;
import utils.ServiceException;
import domain.Customer;
import utils.DBUtils;

public class CustomerManagerService {
private static CustomerManagerService instance=new CustomerManagerService();
	
	public static CustomerManagerService getInstance(){
		return instance;
	}
	//@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Connection conn =null;
		try{
			conn = DBUtils.getConnection();
			CustomerDao customerDao = new CustomerDao(conn);
			DBUtils.beginTransaction(conn);
			customerDao.addCustomer(customer);
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
	public void deleteCustomer(String[] customerIdList) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			CustomerDao customerDao = new CustomerDao(conn);
			DBUtils.beginTransaction(conn);
			customerDao.deleteCustomer(customerIdList);
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

	public void modifyCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			CustomerDao customerDao = new CustomerDao(conn);
			DBUtils.beginTransaction(conn);
			customerDao.updatecustomer(customer);
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

	public List<Customer> findAllCustomer() {
		// TODO Auto-generated method stub
		List<Customer> customerList = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			
			CustomerDao customerDao = new CustomerDao(conn);
			DBUtils.beginTransaction(conn);
			customerList = customerDao.findAllcustomerList();
			DBUtils.commit(conn);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			DBUtils.rollback(conn);
			throw new ServiceException("�û��б����", e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return customerList;
	}
	

	public Customer findCustomerByNo(int customerNo) {
		// TODO Auto-generated method stub
		Customer res= null;
		Connection conn = null;
		try {
		conn = DBUtils.getConnection();
		System.out.println(conn);	
			CustomerDao customerDao = new CustomerDao(conn);
			DBUtils.beginTransaction(conn);
			res = customerDao.findcustomerByNo(customerNo);
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

