package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.ForRepair;
import utils.DBUtils;
import utils.DaoException;

public class ForRepairDao {
	private Connection connection;
	
	public ForRepairDao(Connection conn){
		this.connection=conn;
	}
	
	/**
	 * �����û�
	 * @param forRepair ����
	 */
	public void addForRepair(ForRepair forRepair){
		String sql = "insert into forRepair (repairNo, " +        // ά�ޱ��
			    							"customerNo, " +	  // �ͻ����
			    							"productType, " +	  // ��Ʒ����
			    							"machineBrand, " +    // ����Ʒ��
			    							"deliverTime, " +     // �ͻ�ʱ��
			    							"previewCost, " +     // Ԥ���۸�
			    							"deliverState) " +    // ����״̬
			    	 "values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, forRepair.getRepairNo());
			pstmt.setLong(2, forRepair.getCustomerNo());
			pstmt.setString(3, forRepair.getProductType());
			pstmt.setString(4, forRepair.getMachineBrand());
			pstmt.setDate(5, forRepair.getDeliverTime());
			pstmt.setDouble(6, forRepair.getPreviewCost());
			pstmt.setString(7, forRepair.getDeliverState());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Error on adding user", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}
	}
	
	/**
	 * ɾ���޶���
	 * @param forRepair ����
	 */
	public void deleteForRepair(String[] repairNoList){
		StringBuffer sbfSql = new StringBuffer();
		for (int i = 0; i < repairNoList.length; i++) {
			sbfSql.append("'").append(repairNoList[i]).append("'").append(",");
		}
		String sql = "delete from forRepair where repairNo in ("
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
	 * @return forRepairList ���޼���
	 */
	public List<ForRepair> findAllforRepairList(){
		String sql = "select * from forRepair order by repairNo ";
		Statement stmt = null;
		ResultSet rs = null;
		List<ForRepair> forRepairList = new ArrayList<ForRepair>();
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ForRepair forRepair = new ForRepair();
				forRepair.setRepairNo(rs.getInt("repairNo"));					                     // ά�ޱ��
				forRepair.setCustomerNo(rs.getInt("customerNo"));		         // �ͻ����
				forRepair.setProductType(rs.getString("productType"));		     // ��Ʒ����
				forRepair.setMachineBrand(rs.getString("machineBrand"));		 // ����Ʒ��
				forRepair.setDeliverTime(rs.getDate("deliverTime"));			 // �ͻ�ʱ��
				forRepair.setPreviewCost(rs.getDouble("previewCost"));			 // Ԥ���۸�
				forRepair.setDeliverState(rs.getString("deliverState"));	     // ����״̬
				forRepairList.add(forRepair);
			}
		} catch (SQLException e) {
			throw new DaoException("Error on finding user", e);
		} finally {
			DBUtils.closeStatement(stmt);
		}
		return forRepairList;
	}
	
	/**
	 * ��ѯ����
	 * @param repairNo ά�ޱ��
	 * @return forRepair ������Ϣ
	 */
	public ForRepair findforRepairByNo(int repairNo){
		String sql = "select * from forRepair where repairNo=?";
		ForRepair forRepair = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, repairNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				forRepair = new ForRepair();
				forRepair.setRepairNo(rs.getInt("repairNo"));					                     // ά�ޱ��
				forRepair.setCustomerNo(rs.getInt("customerNo"));		         // �ͻ����
				forRepair.setProductType(rs.getString("productType"));		     // ��Ʒ����
				forRepair.setMachineBrand(rs.getString("machineBrand"));		 // ����Ʒ��
				forRepair.setDeliverTime(rs.getDate("deliverTime"));			 // �ͻ�ʱ��
				forRepair.setPreviewCost(rs.getDouble("previewCost"));			 // Ԥ���۸�
				forRepair.setDeliverState(rs.getString("deliverState"));	     // ����״̬
			}
		} catch (SQLException e) {
			throw new DaoException("Error on getting user", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}
		return forRepair;
	}

	/**
	 * �޸ı�����Ϣ
	 * @param forRepair �ͻ���Ϣ
	 */
	public void updateforRepair(ForRepair forRepair){
		String sql = "update forRepair set customerNo=?, " +		   //���֤��
				                          "productType=?, " +	   //�ͻ��ͻ�ʱ��
				                          "machineBrand=?, " +     //�ͻ�����
				                          "deliverTime=?, " +          //��λ���
				                          "previewCost=?, " +        //���
				                          "deliverState=? " +      //�ƶ��绰 
				                          "where repairNo=?";         //�ʱ�
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, forRepair.getCustomerNo());
			pstmt.setString(2, forRepair.getProductType());
			pstmt.setString(3, forRepair.getMachineBrand());
			pstmt.setDate(4, forRepair.getDeliverTime());
			pstmt.setDouble(5, forRepair.getPreviewCost());
			pstmt.setString(6, forRepair.getDeliverState());
			pstmt.setLong(7, forRepair.getRepairNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Error on updating user", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}
	}
	
	public List<ForRepair> findForRepair(ForRepair u)
	{
		Statement stmt = null;
		ResultSet rs = null;
		List<ForRepair> forRepairList = new ArrayList<ForRepair>();
		String sql = "select * from forRepair where repairNo="+u.getRepairNo();
		if(u.getCustomerNo()!=0)
		{
			sql+=" and customerNo='"+u.getCustomerNo()+"'";
		}
		if(u.getDeliverTime()!=null && !u.getDeliverTime().equals(""))
		{
			sql+=" and deliverTime=to_date('"+u.getDeliverTime()+"','yyyy-mm-dd')";
		}
		if(u.getProductType()!=null )
		{
			sql+=" and productType='"+u.getProductType()+"'";
		}
		if(u.getMachineBrand()!=null )
		{
			sql+=" and machineBrand='"+u.getMachineBrand()+"'";
		}
		if(u.getPreviewCost()!=0 )
		{
			sql+=" and previewCost='"+u.getPreviewCost()+"'";
		}
		if(u.getDeliverState()!=null )
		{
			sql+=" and deliverState='"+u.getDeliverState()+"'";
		}
		System.out.println(sql);
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ForRepair forRepair = new ForRepair();
				forRepair.setRepairNo(rs.getInt("repairNo"));                                   // �ͻ����
				forRepair.setCustomerNo(rs.getInt("customerNo"));		             // ���֤��
				forRepair.setProductType(rs.getString("productType"));		     // ��Ʒ����
				forRepair.setMachineBrand(rs.getString("machineBrand"));		 // ����Ʒ��
				forRepair.setDeliverTime(rs.getDate("deliverTime"));			 // �ͻ�ʱ��
				forRepair.setPreviewCost(rs.getDouble("previewCost"));			 // Ԥ���۸�
				forRepair.setDeliverState(rs.getString("deliverState"));	     // ����״̬
				forRepairList.add(forRepair);
			}
		} catch (SQLException e) {
			//throw new DaoException("Error on finding user", e);
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(stmt);
		}
		return forRepairList;
	}
}
