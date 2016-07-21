package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.CustomerSure;
import utils.DBUtils;
import utils.DaoException;

public class CustomerSureDao {
private Connection connection;
	
	public CustomerSureDao(Connection conn){
		this.connection=conn;
	}
	
	/**
	 * 增加客户确认单
	 * @param customerSure 客户确认
	 */
	public void addCustomerSure(CustomerSure customerSure){
		String sql = "insert into customerSure (reserveTime, " +        // 接修日期
			    							"repairNo, " +	            // 维修编号
			    							"productType, " +	        // 产品类型
			    							"machineBrand, " +          // 机器品牌
			    							"machineVersion, " +        // 机器型号
			    							"seriesNumber, " +          // 系列号
			    							"company, " +               // 公司名称
			    							"linkmen, " +               // 联系人
			    							"failureAppear, " +         // 机器故障现象
			    							"lockPart, " +              // 缺少零件
			    							"attachment) " +            // 随机附件
			    	 "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setDate(1, customerSure.getReserveTime());
			pstmt.setInt(2, customerSure.getRepairNo());
			pstmt.setString(3, customerSure.getProductType());
			pstmt.setString(4, customerSure.getMachineBrand());
			pstmt.setString(5, customerSure.getMachineVersion());
			pstmt.setString(6, customerSure.getSeriesNumber());
			pstmt.setString(7, customerSure.getCompany());
			pstmt.setString(8, customerSure.getLinkmen());
			pstmt.setString(9, customerSure.getFailureAppear());
			pstmt.setString(10, customerSure.getLockPart());
			pstmt.setString(11, customerSure.getAttachment());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			throw new DaoException("Error on adding user", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}
	}
	
	/**
	 * 删除客户确认单
	 * @param customerSure 客户确认
	 */
	public void deleteCustomerSure(String[] repairNoList){
		StringBuffer sbfSql = new StringBuffer();
		for (int i = 0; i < repairNoList.length; i++) {
			sbfSql.append("'").append(repairNoList[i]).append("'").append(",");
		}
		String sql = "delete from customerSure where repairNo in ("
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
	 * 查询所有报修订单
	 * @return customerSureList 报修集合
	 */
	/*public List<CustomerSure> findAllcustomerSureList(){
		String sql = "select * from customerSure order by customerSureNo ";
		Statement stmt = null;
		ResultSet rs = null;
		List<CustomerSure> customerSureList = new ArrayList<CustomerSure>();
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				CustomerSure customerSure = new CustomerSure();
				int i = Integer.parseInt(rs.getString("repairNo"));
				customerSure.setRepairNo(i);					                     // 维修编号
				customerSure.setCustomerNo(rs.getInt("customerNo"));		         // 客户编号
				customerSure.setProductType(rs.getString("productType"));		     // 产品类型
				customerSure.setMachineBrand(rs.getString("machineBrand"));		 // 机器品牌
				customerSure.setDeliverTime(rs.getDate("deliverTime"));			 // 送机时间
				customerSure.setPreviewCost(rs.getFloat("previewCost"));			 // 预估价格
				customerSure.setDeliverState(rs.getString("deliverState"));	     // 报修状态
				customerSureList.add(customerSure);
			}
		} catch (SQLException e) {
			throw new DaoException("Error on finding user", e);
		} finally {
			DBUtils.closeStatement(stmt);
		}
		return customerSureList;
	}*/
	
	/**
	 * 查询客户确认单
	 * @param repairNo 维修编号
	 * @return customerSure 客户确认信息
	 */
	public CustomerSure findCustomerSureByNo(int repairNo){
		String sql = "select * from customerSure where repairNo=?";
		CustomerSure customerSure = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, repairNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				customerSure = new CustomerSure();
				customerSure.setRepairNo(rs.getInt("repairNo"));			     // 维修编号
				customerSure.setReserveTime(rs.getDate("reserveTime"));		     // 接修日期
				customerSure.setProductType(rs.getString("productType"));        // 产品类型
				customerSure.setMachineBrand(rs.getString("machineBrand"));      // 机器品牌
				customerSure.setMachineVersion(rs.getString("machineVersion"));  // 机器型号
				customerSure.setSeriesNumber(rs.getString("seriesNumber"));      // 机器型号
				customerSure.setCompany(rs.getString("company"));                // 公司名称
				customerSure.setLinkmen(rs.getString("linkmen"));                // 联系人
				customerSure.setFailureAppear(rs.getString("failureAppear"));	 // 机器故障现象
				customerSure.setLockPart(rs.getString("lockPart"));	             // 缺少零件
				customerSure.setAttachment(rs.getString("attachment"));	         // 随机附件
			}
		} catch (SQLException e) {
			throw new DaoException("Error on getting user", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}
		return customerSure;
	}

	/**
	 * 修改报修信息
	 * @param customerSure 客户信息
	 */
	public void updateCustomerSure(CustomerSure customerSure){
		String sql = "update customerSure set reserveTime=?, " +		   //身份证号
											  "productType=?, " +	        // 产品类型
											  "machineBrand=?, " +          // 机器品牌
											  "machineVersion=?, " +        // 机器型号
											  "seriesNumber=?, " +          // 系列号
											  "company=?, " +               // 公司名称
											  "linkmen=?, " +               // 联系人
											  "failureAppear=?, " +         // 机器故障现象
											  "lockPart=?, " +              // 缺少零件
											  "attachment=? " +            // 随机附件 
				                          "where repairNo=?";         //邮编
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setDate(1, new java.sql.Date(customerSure.getReserveTime().getTime()));
			pstmt.setString(2, customerSure.getProductType());
			pstmt.setString(3, customerSure.getMachineBrand());
			pstmt.setString(4, customerSure.getMachineVersion());
			pstmt.setString(5, customerSure.getSeriesNumber());
			pstmt.setString(6, customerSure.getCompany());
			pstmt.setString(7, customerSure.getLinkmen());
			pstmt.setString(8, customerSure.getFailureAppear());
			pstmt.setString(9, customerSure.getLockPart());
			pstmt.setString(10, customerSure.getAttachment());
			pstmt.setInt(11, customerSure.getRepairNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Error on updating user", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}
	}
	
	public List<CustomerSure> findCustomerSure(CustomerSure u)
	{
		Statement stmt = null;
		ResultSet rs = null;
		List<CustomerSure> customerSureList = new ArrayList<CustomerSure>();
		String sql = "select * from customerSure where repairNo="+u.getRepairNo();
		if(u.getRepairNo()!=0)
		{
			sql+=" and customerNo='"+u.getRepairNo()+"'";
		}
		if(u.getReserveTime()!=null && !u.getReserveTime().equals(""))
		{
			sql+=" and reserveTime=to_date('"+u.getReserveTime()+"','yyyy-mm-dd')";
		}
		if(u.getProductType()!=null )
		{
			sql+=" and productType='"+u.getProductType()+"'";
		}
		if(u.getMachineBrand()!=null )
		{
			sql+=" and machineBrand='"+u.getMachineBrand()+"'";
		}
		if(u.getMachineVersion()!=null && !u.getMachineVersion().equals("") )
		{
			sql+=" and machineVersion='"+u.getMachineVersion()+"'";
		}
		if(u.getSeriesNumber()!=null && u.getSeriesNumber().equals(""))
		{
			sql+=" and seriesNumber='"+u.getSeriesNumber()+"'";
		}
		if(u.getCompany()!=null && u.getCompany().equals(""))
		{
			sql+=" and company='"+u.getCompany()+"'";
		}
		if(u.getLinkmen()!=null && u.getLinkmen().equals(""))
		{
			sql+=" and linkmen='"+u.getLinkmen()+"'";
		}
		if(u.getFailureAppear()!=null && u.getFailureAppear().equals(""))
		{
			sql+=" and failureAppear='"+u.getFailureAppear()+"'";
		}
		if(u.getLockPart()!=null && u.getLockPart().equals(""))
		{
			sql+=" and lockPart='"+u.getLockPart()+"'";
		}
		if(u.getAttachment()!=null && u.getAttachment().equals(""))
		{
			sql+=" and attachment='"+u.getAttachment()+"'";
		}
		System.out.println(sql);
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				CustomerSure customerSure = new CustomerSure();
				customerSure.setRepairNo(rs.getInt("repairNo"));			     // 维修编号
				customerSure.setReserveTime(rs.getDate("reserveTime"));		     // 接修日期
				customerSure.setProductType(rs.getString("productType"));        // 产品类型
				customerSure.setMachineBrand(rs.getString("machineBrand"));      // 机器品牌
				customerSure.setMachineVersion(rs.getString("machineVersion"));  // 机器型号
				customerSure.setSeriesNumber(rs.getString("seriesNumber"));      // 机器型号
				customerSure.setCompany(rs.getString("company"));                // 公司名称
				customerSure.setLinkmen(rs.getString("linkmen"));                // 联系人
				customerSure.setFailureAppear(rs.getString("failureAppear"));	 // 机器故障现象
				customerSure.setLockPart(rs.getString("lockPart"));	             // 缺少零件
				customerSure.setAttachment(rs.getString("attachment"));	         // 随机附件    
				customerSureList.add(customerSure);
			}
		} catch (SQLException e) {
			//throw new DaoException("Error on finding user", e);
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(stmt);
		}
		return customerSureList;
	}
}
