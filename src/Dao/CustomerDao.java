package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Customer;
import utils.DBUtils;
import utils.DaoException;

public class CustomerDao {
	private Connection connection;
	
	public CustomerDao(Connection conn){
		this.connection=conn;
	}
	
	/**
	 * �����û�
	 * @param customer �ͻ�
	 */
	public void addCustomer(Customer customer){
		String sql = "insert into customer (customerNo, " +        //�ͻ����
			    							"IDCard, " +		   //���֤��
			    							"deliverTime, " +	   //�ͻ��ͻ�ʱ��
			    							"customerType, " +     //�ͻ�����
			    							"company, " +          //��λ���
			    							"homePhone, " +        //���
			    							"mobilePhone, " +      //�ƶ��绰
			    							"address, " +          //�ͻ���ַ
			    							"linkmen, " +          //��ϵ��
			    							"email, " +            //����
			    							"postcode) " +         //�ʱ�
			    	 "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, customer.getCustomerNo());
			pstmt.setString(2, customer.getIDCard());
			pstmt.setDate(3, new java.sql.Date(customer.getDeliverTime().getTime()));
			pstmt.setString(4, customer.getCustomerType());
			pstmt.setString(5, customer.getCompany());
			pstmt.setString(6, customer.getHomePhone());
			pstmt.setString(7, customer.getMobilePhone());
			pstmt.setString(8, customer.getAddress());
			pstmt.setString(9, customer.getLinkmen());
			pstmt.setString(10, customer.getEmail());
			pstmt.setString(11, customer.getPostcode());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Error on adding user", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}
	}
	
	/**
	 * ɾ���û�
	 * @param customer �ͻ�
	 */
	public void deleteCustomer(String[] customerNoList){
		StringBuffer sbfSql = new StringBuffer();
		for (int i = 0; i < customerNoList.length; i++) {
			sbfSql.append("'").append(customerNoList[i]).append("'").append(",");
		}
		String sql = "delete from customer where customerNo in ("
				+ sbfSql.substring(0, sbfSql.length() - 1) + ")";
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			throw new DaoException("Error on deleting user", e);
		} finally {
			DBUtils.closeStatement(stmt);
		}
	}
	
	/**
	 * ��ѯ�����û�
	 * @return customerList �ͻ�����
	 */
	public List<Customer> findAllcustomerList(){
		String sql = "select * from customer order by customerNo ";
		Statement stmt = null;
		ResultSet rs = null;
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Customer customer = new Customer();
				int i = Integer.parseInt(rs.getString("customerNo"));
				customer.setCustomerNo(i);					                 // �ͻ����
				customer.setIDCard(rs.getString("IDCard"));		             // ���֤��
				customer.setDeliverTime(rs.getDate("deliverTime"));		     // �ͻ��ͻ�ʱ��
				customer.setCustomerType(rs.getString("customerType"));		 // �ͻ�����
				customer.setCompany(rs.getString("company"));			     // ��λ���
				customer.setHomePhone(rs.getString("homePhone"));			 // ���
				customer.setMobilePhone(rs.getString("mobilePhone"));	     // �ƶ��绰
				customer.setAddress(rs.getString("address"));			     // �ͻ���ַ
				customer.setLinkmen(rs.getString("linkmen"));			     // ��ϵ��
				customer.setEmail(rs.getString("email"));			         // ����
				customer.setPostcode(rs.getString("postcode"));			     // �ʱ�
				customerList.add(customer);
			}
		} catch (SQLException e) {
			throw new DaoException("Error on finding user", e);
		} finally {
			DBUtils.closeStatement(stmt);
		}
		return customerList;
	}
	
	/**
	 * ��ѯ�û�
	 * @param customerNo �ͻ����
	 * @return customer �ͻ���Ϣ
	 */
	public Customer findcustomerByNo(int customerNo){
		String sql = "select * from customer where customerNo=?";
		Customer customer = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, customerNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				customer = new Customer();
				int i = Integer.parseInt(rs.getString("customerNo"));
				customer.setCustomerNo(i);                                   // �ͻ����
				customer.setIDCard(rs.getString("IDCard"));		             // ���֤��
				customer.setDeliverTime(rs.getDate("deliverTime"));		     // �ͻ��ͻ�ʱ��
				customer.setCustomerType(rs.getString("customerType"));		 // �ͻ�����
				customer.setCompany(rs.getString("company"));			     // ��λ���
				customer.setHomePhone(rs.getString("homePhone"));			 // ���
				customer.setMobilePhone(rs.getString("mobilePhone"));	     // �ƶ��绰
				customer.setAddress(rs.getString("address"));			     // �ͻ���ַ
				customer.setLinkmen(rs.getString("linkmen"));			     // ��ϵ��
				customer.setEmail(rs.getString("email"));			         // ����
				customer.setPostcode(rs.getString("postcode"));			     // �ʱ�
			}
		} catch (SQLException e) {
			throw new DaoException("Error on getting user", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}
		return customer;
	}

	/**
	 * �޸Ŀͻ���Ϣ
	 * @param customer �ͻ���Ϣ
	 */
	public void updatecustomer(Customer customer){
		String sql = "update customer set  IDCard=?, " +		   //���֤��
				                          "deliverTime=?, " +	   //�ͻ��ͻ�ʱ��
				                          "customerType=?, " +     //�ͻ�����
				                          "company=?, " +          //��λ���
				                          "homePhone=?, " +        //���
				                          "mobilePhone=?, " +      //�ƶ��绰
				                          "address=?, " +          //�ͻ���ַ
				                          "linkmen=?, " +          //��ϵ��
				                          "email=?, " +            //����
				                          "postcode=? " + 
				                          "where customerNo=?";         //�ʱ�
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, customer.getIDCard());
			pstmt.setDate(2, new java.sql.Date(customer.getDeliverTime().getTime()));
			pstmt.setString(3, customer.getCustomerType());
			pstmt.setString(4, customer.getCompany());
			pstmt.setString(5, customer.getHomePhone());
			pstmt.setString(6, customer.getMobilePhone());
			pstmt.setString(7, customer.getAddress());
			pstmt.setString(8, customer.getLinkmen());
			pstmt.setString(9, customer.getEmail());
			pstmt.setString(10, customer.getPostcode());
			pstmt.setLong(11, customer.getCustomerNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Error on updating user", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}
	}
	
	public List<Customer> findUsers(Customer u)
	{
		Statement stmt = null;
		ResultSet rs = null;
		List<Customer> userList = new ArrayList<Customer>();
		String sql = "select * from customer where  customerNo="+u.getCustomerNo();
		if(u.getIDCard()!=null && !u.getIDCard().equals(""))
		{
			sql+=" and IDCard='"+u.getIDCard()+"'";
		}
		if(u.getDeliverTime()!=null && !u.getDeliverTime().equals(""))
		{
			sql+=" and deliverTime=to_date('"+u.getDeliverTime()+"','yyyy-mm-dd')";
		}
		if(u.getCustomerType()!=null )
		{
			sql+=" and customerType='"+u.getCustomerType()+"'";
		}
		if(u.getCustomerType()!=null )
		{
			sql+=" and company='"+u.getCompany()+"'";
		}
		if(u.getCustomerType()!=null )
		{
			sql+=" and homePhone='"+u.getHomePhone()+"'";
		}
		if(u.getCustomerType()!=null )
		{
			sql+=" and mobilePhone='"+u.getMobilePhone()+"'";
		}
		if(u.getAddress()!=null )
		{
			sql+=" and address='"+u.getAddress()+"'";
		}
		if(u.getPostcode()!=null )
		{
			sql+=" and postcode='"+u.getPostcode()+"'";
		}
		if(u.getLinkmen()!=null )
		{
			sql+=" and linkmen='"+u.getLinkmen()+"'";
		}
		if(u.getEmail()!=null )
		{
			sql+=" and email='"+u.getEmail()+"'";
		}
		System.out.println(sql);
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Customer customer = new Customer();
				int i = Integer.parseInt(rs.getString("customerNo"));
				customer.setCustomerNo(i);                                   // �ͻ����
				customer.setIDCard(rs.getString("IDCard"));		             // ���֤��
				customer.setDeliverTime(rs.getDate("deliverTime"));		     // �ͻ��ͻ�ʱ��
				customer.setCustomerType(rs.getString("customerType"));		 // �ͻ�����
				customer.setCompany(rs.getString("company"));			     // ��λ���
				customer.setHomePhone(rs.getString("homePhone"));			 // ���
				customer.setMobilePhone(rs.getString("mobilePhone"));	     // �ƶ��绰
				customer.setAddress(rs.getString("address"));			     // �ͻ���ַ
				customer.setLinkmen(rs.getString("linkmen"));			     // ��ϵ��
				customer.setEmail(rs.getString("email"));			         // ����
				customer.setPostcode(rs.getString("postcode"));			     // �ʱ�
				userList.add(customer);
			}
		} catch (SQLException e) {
			//throw new DaoException("Error on finding user", e);
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(stmt);
		}
		return userList;
	}
}
