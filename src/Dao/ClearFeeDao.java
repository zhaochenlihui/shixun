package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.ClearFee;
import utils.DBUtils;
import utils.DaoException;

public class ClearFeeDao {
	private Connection connection;
	
	public ClearFeeDao(Connection conn){
		this.connection=conn;
	}
	
	/**
	 * ��ӽ����嵥
	 * @param clearFee �����嵥
	 */
	public void addClearFee(ClearFee clf){
		String sql = "insert into clearFee (repairNo, " +            // ά�ޱ��
									  "reserveTime, " +         // ά������
									  "repairedTime, " +        // �޸�ʱ��
									  "productType, " +         // ��Ʒ����
									  "machineBrand, " +        // ����Ʒ��
									  "seriesNumber, " +        // ϵ�к�
									  "company, " +             // ��λ���
									  "linkmen, " +             // ��ϵ��
									  "moneySum, " +            // �ϼƽ��
									  "repairCost, " +          // ά�޷���
									  "materialCost, " +        // ���Ϸ���
									  "failureType, " +         // ��������
									  "warranty, " +            // ���޳�ŵ
									  "attention, " +           // ע������
									  "partName, " +            // �������
									  "version, " +             // �ͺ�
									  "amount, " +              // ����
									  "price) " +               // ����
					 "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, clf.getRepairNo());
			pstmt.setDate(2, clf.getReserveTime());
			pstmt.setDate(3, clf.getRepairedTime());
			pstmt.setString(4, clf.getProductType());
			pstmt.setString(5, clf.getMachineBrand());
			pstmt.setString(6, clf.getSeriesNumber());
			pstmt.setString(7, clf.getCompany());
			pstmt.setString(8, clf.getLinkmen());
			pstmt.setDouble(9, clf.getMoneySum());
			pstmt.setDouble(10, clf.getRepairCost());
			pstmt.setDouble(11, clf.getMaterialCost());
			pstmt.setString(12, clf.getFailureType());
			pstmt.setString(13, clf.getWarranty());
			pstmt.setString(14, clf.getAttention());
			pstmt.setString(15, clf.getPartName());
			pstmt.setString(16, clf.getVersion());
			pstmt.setInt(17, clf.getAmount());
			pstmt.setDouble(18, clf.getPrice());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Error on adding user", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}
	}
	
	/**
	 * ɾ������嵥
	 * @param clearfee �����嵥
	 */
	public void deleteClearFee(String[] repairNoList){
		StringBuffer sbfSql = new StringBuffer();
		for (int i = 0; i < repairNoList.length; i++) {
			sbfSql.append("'").append(repairNoList[i]).append("'").append(",");
		}
		String sql = "delete from clearFee where repairNo in ("
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
	 * ��ѯ���б��޶���
	 * @return feeList ���޼���
	 */
	/*public List<ClearFee> findAllfeeList(){
		String sql = "select * from fee order by feeNo ";
		Statement stmt = null;
		ResultSet rs = null;
		List<ClearFee> feeList = new ArrayList<ClearFee>();
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ClearFee fee=new ClearFee();
				fee.setRepairNo(rs.getInt("repairNo"));					   // ά�ޱ��
				fee.setRepairCost(rs.getFloat("repairCost"));		       // ά�޷���
				fee.setMaterialCost(rs.getFloat("materialCost"));	       // ���Ϸ���
				fee.setWarranty(rs.getString("warranty"));		           // ���޳�ŵ
				fee.setAttention(rs.getString("attention"));			   // ע������
				fee.setClearTime(rs.getDate("clearTime"));	               // ��������
				feeList.add(fee);
			}
		} catch (SQLException e) {
			throw new DaoException("Error on finding user", e);
		} finally {
			DBUtils.closeStatement(stmt);
		}
		return feeList;
	}*/
	
	/**
	 * ��ѯ�����嵥
	 * @param repairNo ά�ޱ��
	 * @return fee �����嵥
	 */
	public ClearFee findClearFeeByNo(int repairNo){
		String sql = "select * from clearFee where repairNo=?";
		ClearFee fee =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, repairNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				fee = new ClearFee();
				fee.setRepairNo(rs.getInt("repairNo"));        // ά�ޱ��					                     // ά�ޱ��
			    fee.setReserveTime(rs.getDate("reserveTime"));
			    fee.setRepairedTime(rs.getDate("repairedTime"));
			    fee.setProductType(rs.getString("productType"));
			    fee.setMachineBrand(rs.getString("machineBrand"));
			    fee.setSeriesNumber(rs.getString("seriesNumber"));
			    fee.setCompany(rs.getString("company"));
			    fee.setLinkmen(rs.getString("linkmen"));
			    fee.setMoneySum(rs.getDouble("moneySum"));
			    fee.setRepairCost(rs.getDouble("repairCost"));
			    fee.setMaterialCost(rs.getDouble("materialCost"));
				fee.setFailureType(rs.getString("failureType"));
				fee.setWarranty(rs.getString("warranty"));
				fee.setAttention(rs.getString("attention"));
				fee.setPartName(rs.getString("partName"));
				fee.setVersion(rs.getString("version"));
				fee.setAmount(rs.getInt("amount"));
				fee.setPrice(rs.getDouble("price"));
			}
		} catch (SQLException e) {
			throw new DaoException("Error on getting user", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}
		return fee;
	}
	
	/**
	 * �޸Ľ��������Ϣ
	 * @param fee ���������Ϣ
	 */
	public void updateClearFee(ClearFee clf){
		String sql = "update clearFee set reserveTime=?, " +        // ά������
										 "repairedTime=?, " +        // �޸�ʱ��
										 "productType=?, " +         // ��Ʒ����
										 "machineBrand=?, " +        // ����Ʒ��
										 "seriesNumber=?, " +        // ϵ�к�
										 "company=?, " +             // ��λ���
										 "linkmen=?, " +             // ��ϵ��
										 "moneySum=?, " +            // �ϼƽ��
										 "repairCost=?, " +          // ά�޷���
										 "materialCost=?, " +        // ���Ϸ���
										 "failureType=?, " +         // ��������
										 "warranty=?, " +            // ���޳�ŵ
										 "attention=?, " +           // ע������
										 "partName=?, " +            // �������
										 "version=?, " +             // �ͺ�
										 "amount=?, " +              // ����
										 "price=? " +               // ����
					 "where repairNo=?";	  // ά�ޱ��    
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setDate(1, clf.getReserveTime());
			pstmt.setDate(2, clf.getRepairedTime());
			pstmt.setString(3, clf.getProductType());
			pstmt.setString(4, clf.getMachineBrand());
			pstmt.setString(5, clf.getSeriesNumber());
			pstmt.setString(6, clf.getCompany());
			pstmt.setString(7, clf.getLinkmen());
			pstmt.setDouble(8, clf.getMoneySum());
			pstmt.setDouble(9, clf.getRepairCost());
			pstmt.setDouble(10, clf.getMaterialCost());
			pstmt.setString(11, clf.getFailureType());
			pstmt.setString(12, clf.getWarranty());
			pstmt.setString(13, clf.getAttention());
			pstmt.setString(14, clf.getPartName());
			pstmt.setString(15, clf.getVersion());
			pstmt.setInt(16, clf.getAmount());
			pstmt.setDouble(17, clf.getPrice());
			pstmt.setInt(18, clf.getRepairNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Error on updating user", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}
	
	}
	
	public List<ClearFee> findClearFee(ClearFee u){
		Statement stmt = null;
		ResultSet rs = null;
		List<ClearFee> feeList = new ArrayList<ClearFee>();
		String sql = "select * from clearFee where repairNo="+u.getRepairNo();
		if(u.getReserveTime()!=null && !u.getReserveTime().equals(""))
		{
			sql+=" and reserveTime='"+u.getReserveTime()+"'";
		}
		if(u.getProductType()!=null && !u.getProductType().equals(""))
		{
			sql+=" and productType='"+u.getProductType()+"'";
		}
		if(u.getMachineBrand()!=null && !u.getMachineBrand().equals(""))
		{
			sql+=" and machineBrand='"+u.getMachineBrand()+"'";
		}
		if(u.getSeriesNumber()!=null && !u.getSeriesNumber().equals(""))
		{
			sql+=" and seriesNumber='"+u.getSeriesNumber()+"'";
		}
		if(u.getCompany()!=null && !u.getCompany().equals(""))
		{
			sql+=" and company='"+u.getCompany()+"'";
		}
		if(u.getLinkmen()!=null && !u.getLinkmen().equals(""))
		{
			sql+=" and linkmen='"+u.getLinkmen()+"'";
		}
		if(u.getMoneySum()!=0)
		{
			sql+=" and moneySum='"+u.getMoneySum()+"'";
		}
		if(u.getRepairCost()!=0)
		{
			sql+=" and repairCost='"+u.getRepairCost()+"'";
		}
		if(u.getMaterialCost()!=0)
		{
			sql+=" and materialCost='"+u.getMaterialCost()+"'";
		}
		if(u.getFailureType()!=null && !u.getFailureType().equals(""))
		{
			sql+=" and failureType='"+u.getFailureType()+"'";
		}
		if(u.getWarranty()!=null && !u.getWarranty().equals(""))
		{
			sql+=" and warranty='"+u.getWarranty()+"'";
		}
		if(u.getAttention()!=null && !u.getAttention().equals(""))
		{
			sql+=" and attention='"+u.getAttention()+"'";
		}
		if(u.getPartName()!=null && !u.getPartName().equals(""))
		{
			sql+=" and partName='"+u.getPartName()+"'";
		}
		if(u.getVersion()!=null && !u.getVersion().equals(""))
		{
			sql+=" and version='"+u.getVersion()+"'";
		}
		if(u.getAmount()!=0)
		{
			sql+=" and amount='"+u.getAmount()+"'";
		}
		if(u.getPrice()!=0)
		{
			sql+=" and price='"+u.getPrice()+"'";
		}
		System.out.println(sql);
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ClearFee fee = new ClearFee();
				fee.setRepairNo(rs.getInt("repairNo"));        // ά�ޱ��					                     // ά�ޱ��
			    fee.setReserveTime(rs.getDate("reserveTime"));
			    fee.setRepairedTime(rs.getDate("repairedTime"));
			    fee.setProductType(rs.getString("productType"));
			    fee.setMachineBrand(rs.getString("machineBrand"));
			    fee.setSeriesNumber(rs.getString("seriesNumber"));
			    fee.setCompany(rs.getString("company"));
			    fee.setLinkmen(rs.getString("linkmen"));
			    fee.setMoneySum(rs.getDouble("moneySum"));
			    fee.setRepairCost(rs.getDouble("repairCost"));
			    fee.setMaterialCost(rs.getDouble("materialCost"));
				fee.setFailureType(rs.getString("failureType"));
				fee.setWarranty(rs.getString("warranty"));
				fee.setAttention(rs.getString("attention"));
				fee.setPartName(rs.getString("partName"));
				fee.setVersion(rs.getString("version"));
				fee.setAmount(rs.getInt("amount"));
				fee.setPrice(rs.getDouble("price"));
				feeList.add(fee);
			}
		} catch (SQLException e) {
			//throw new DaoException("Error on finding user", e);
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(stmt);
		}
		return feeList;
	  }
}
