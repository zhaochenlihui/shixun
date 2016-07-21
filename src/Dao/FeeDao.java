package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Fee;
import utils.DBUtils;
import utils.DaoException;

public class FeeDao {
private Connection connection;
	
	public FeeDao(Connection conn){
		this.connection=conn;
	}
	
	/**
	 * �������
	 * @param fee ����
	 */
	public void addFee(Fee fee){
		String sql = "insert into fee (repairNo, " +           // ά�ޱ��
									  "repairCost, " +         // ά�޷���
									  "materialCost, " +       // ���Ϸ���
									  "warranty, " +           // ���޳�ŵ
									  "attention, " +          // ע������
									  "clearTime) " +          // ��������
					 "values(?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, fee.getRepairNo());
			pstmt.setFloat(2, fee.getRepairCost());
			pstmt.setFloat(3, fee.getMaterialCost());
			pstmt.setString(4, fee.getWarranty());
			pstmt.setString(5, fee.getAttention());
			pstmt.setDate(6, fee.getClearTime());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			//throw new DaoException("Error on adding user", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}
	}
	
	/**
	 * ɾ����������Ϣ
	 * @param fee �������
	 */
	public void deleteFee(String[] repairNoList){
		StringBuffer sbfSql = new StringBuffer();
		for (int i = 0; i < repairNoList.length; i++) {
			sbfSql.append("'").append(repairNoList[i]).append("'").append(",");
		}
		String sql = "delete from feehine where repairNo in ("
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
	public List<Fee> findAllfeeList(){
		String sql = "select * from fee order by feeNo ";
		Statement stmt = null;
		ResultSet rs = null;
		List<Fee> feeList = new ArrayList<Fee>();
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Fee fee=new Fee();
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
	}
	
	/**
	 * ��ѯ���������Ϣ
	 * @param repairNo ά�ޱ��
	 * @return fee ���������Ϣ
	 */
	public Fee findFeeByNo(int repairNo){
		String sql = "select * from fee where repairNo=?";
		Fee fee =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, repairNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				fee = new Fee();
				fee.setRepairNo(rs.getInt("repairNo"));        // ά�ޱ��					                     // ά�ޱ��
			    fee.setRepairCost(rs.getFloat("repairCost"));    
				fee.setMaterialCost(rs.getFloat("materialCost"));
				fee.setWarranty(rs.getString("warranty"));
				fee.setAttention(rs.getString("attention"));
				fee.setClearTime(rs.getDate("clearTime"));
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
	public void updateFee(Fee fee){
		String sql = "update set fee repairCost=?, " +        // ά�ޱ��
										"materialCost=?, " +  // ά�޷���
										"warranty=?, " +	  // ���Ϸ���
										"attention=?, " +	  // ���޳�ŵ
										"clearTime=? " +      // ע������
										"where repairNo=?";	  // ��������    
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, fee.getRepairNo());
			pstmt.setFloat(2, fee.getRepairCost());
			pstmt.setFloat(3, fee.getMaterialCost());
			pstmt.setString(4, fee.getWarranty());
			pstmt.setString(5, fee.getAttention());
			pstmt.setDate(6, new java.sql.Date(fee.getClearTime().getTime()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Error on updating user", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}
	
	}
	public List<Fee> findFee(Fee u){
		Statement stmt = null;
		ResultSet rs = null;
		List<Fee> feeList = new ArrayList<Fee>();
		String sql = "select * from fee where repairNo="+u.getRepairNo();
		if(u.getRepairCost()!=0)
		{
			sql+=" and repairCost='"+u.getRepairCost()+"'";
		}
		if(u.getMaterialCost()!=0)
		{
			sql+=" and materialCost='"+u.getMaterialCost()+"'";
		}
		if(u.getAttention()!=null && !u.getAttention().equals(""))
		{
			sql+=" and attention='"+u.getAttention()+"'";
		}
		if(u.getWarranty()!=null && !u.getWarranty().equals(""))
		{
			sql+=" and warranty='"+u.getWarranty()+"'";
		}
		if(u.getClearTime()!=null && !u.getClearTime().equals(""))
		{
			sql+=" and clearTime='"+u.getClearTime()+"'";
		}
		System.out.println(sql);
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Fee fee = new Fee();
				fee.setRepairNo(rs.getInt("repairNo"));        // ά�ޱ��					                     // ά�ޱ��
			    fee.setRepairCost(rs.getFloat("repairCost"));    
				fee.setMaterialCost(rs.getFloat("materialCost"));
				fee.setWarranty(rs.getString("warranty"));
				fee.setAttention(rs.getString("attention"));
				fee.setClearTime(rs.getDate("clearTime"));
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
