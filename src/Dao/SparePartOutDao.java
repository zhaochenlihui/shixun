package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.SparePartOut;
import utils.DBUtils;
import utils.DaoException;

public class SparePartOutDao {
	
private Connection connection;
	
	public SparePartOutDao(Connection conn){
		this.connection = conn;
	}
	
	public void addSparePartOut(SparePartOut sparePartOut){
		String sql = "insert into Sparepartout (partname, " +
												"vesion, " +
												"price, " +
												"amount, " +
												"outtime, " +
												"repairno, " +
					 "values(?,?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement pstmt = null;
		try{
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, sparePartOut.getPartName());
			pstmt.setString(2, sparePartOut.getVesion());
			pstmt.setInt(3, sparePartOut.getPrice());
			pstmt.setInt(4, sparePartOut.getAmount());
			pstmt.setDate(5, sparePartOut.getOutTime());
			pstmt.setInt(6, sparePartOut.getRepairNO());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtils.closeStatement(pstmt);
		}
	}
	
	public void deleteSparePartOut(String[] partNameList){
		StringBuffer sbfSql = new StringBuffer();
		for (int i = 0; i < partNameList.length; i++) {
			sbfSql.append("'").append(partNameList[i]).append("'").append(",");
		}
		String sql = "delete from sparepartout where partname in ("
				+ sbfSql.substring(0, sbfSql.length() - 1) + ")";
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			throw new DaoException("Error on deleting sparepart", e);
		} finally {
			DBUtils.closeStatement(stmt);
		}
	}
	
	public List<SparePartOut> findAllSparePartOutList(){
		String sql = "select * from sparepartout ";
		Statement stmt=null;
		ResultSet rs = null;
		List<SparePartOut> sparePartOutList = new ArrayList<SparePartOut>();
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				SparePartOut sparePartOut = new SparePartOut();
				sparePartOut.setAmount(rs.getInt("Amount"));		 
				sparePartOut.setOutTime(rs.getDate("outtime"));			
				sparePartOut.setPartName(rs.getString("partname"));
				sparePartOut.setPrice(rs.getInt("Price"));
				sparePartOut.setRepairNO(rs.getInt("repairno"));
				sparePartOut.setVesion(rs.getString("version"));
				sparePartOutList.add(sparePartOut);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Error on finding sparePartOutOut", e);
		} finally {
			DBUtils.closeStatement(stmt);
		}
		return sparePartOutList;
	}
	
	public SparePartOut findSparePartOutByName(String partName) {
		String sql = "select * from sparepartout where partname=?";
		SparePartOut sparePartOut = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, partName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				sparePartOut = new SparePartOut();
				sparePartOut.setAmount(rs.getInt("Amount"));		 
				sparePartOut.setOutTime(rs.getDate("outtime"));			
				sparePartOut.setPartName(rs.getString("partname"));
				sparePartOut.setPrice(rs.getInt("Price"));
				sparePartOut.setRepairNO(rs.getInt("repairno"));
				sparePartOut.setVesion(rs.getString("version"));
			}
		} catch (SQLException e) {
			throw new DaoException("Error on getting sparePartOutOut", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}
		return sparePartOut;
	}
	
	public void modifySparePartOut(SparePartOut sparePartOut) {
		String sql = "update sparepartout set vesion=?, " +
												"price=?, " +
												"amount=?, " +
												"outtime=?, " +
												"repairNo=?, " +
									"where partname=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(6, sparePartOut.getPartName());
			pstmt.setString(1, sparePartOut.getVesion());
			pstmt.setInt(2, sparePartOut.getPrice());
			pstmt.setInt(3, sparePartOut.getAmount());
			pstmt.setDate(4, sparePartOut.getOutTime());
			pstmt.setInt(5, sparePartOut.getRepairNO());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Error on updating sparePartOutOut", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}
	}
}
