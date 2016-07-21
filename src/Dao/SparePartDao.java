package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.SparePart;
import utils.DBUtils;
import utils.DaoException;

public class SparePartDao {

	private Connection connection;
	
	public SparePartDao(Connection conn){
		this.connection = conn;
	}
	
	public void addSparePart(SparePart sparePart){
		String sql = "insert into Sparepart (partname, " +
												"vesion, " +
												"price, " +
												"amount, " +
												"intime, " +
												"alertamount, " +
												"stockstate) " +
					 "values(?,?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement pstmt = null;
		try{
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, sparePart.getPartName());
			pstmt.setString(2, sparePart.getVesion());
			pstmt.setInt(3, sparePart.getPrice());
			pstmt.setInt(4, sparePart.getAmount());
			pstmt.setDate(5, sparePart.getInTime());
			pstmt.setInt(6, sparePart.getAlertAmount());
			pstmt.setString(7, sparePart.getStockState());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtils.closeStatement(pstmt);
		}
	}
	
	public void deleteSparePart(String[] partNameList){
		StringBuffer sbfSql = new StringBuffer();
		for (int i = 0; i < partNameList.length; i++) {
			sbfSql.append("'").append(partNameList[i]).append("'").append(",");
		}
		String sql = "delete from sparepart where partname in ("
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
	
	public List<SparePart> findAllSparePartList(){
		String sql = "select * from sparepart ";
		Statement stmt=null;
		ResultSet rs = null;
		List<SparePart> sparePartList = new ArrayList<SparePart>();
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				SparePart sparePart = new SparePart();
				sparePart.setAlertAmount(rs.getInt("alertamount"));
				sparePart.setAmount(rs.getInt("Amount"));		 
				sparePart.setInTime(rs.getDate("intime"));			
				sparePart.setPartName(rs.getString("partname"));
				sparePart.setPrice(rs.getInt("Price"));
				sparePart.setStockState(rs.getString("StockState"));
				sparePart.setVesion(rs.getString("vesion"));
				sparePartList.add(sparePart);
			}
		} catch (SQLException e) {
			throw new DaoException("Error on finding sparePart", e);
		} finally {
			DBUtils.closeStatement(stmt);
		}
		return sparePartList;
	}
	
	public SparePart findSparePartByName(String partName) {
		String sql = "select * from sparepart where partname=?";
		SparePart sparePart = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, partName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				sparePart = new SparePart();
				sparePart.setAlertAmount(rs.getInt("alertamount"));
				sparePart.setAmount(rs.getInt("Amount"));		 
				sparePart.setInTime(rs.getDate("intime"));			
				sparePart.setPartName(rs.getString("partname"));
				sparePart.setPrice(rs.getInt("Price"));
				sparePart.setStockState(rs.getString("StockState"));
				sparePart.setVesion(rs.getString("vesion"));
			}
		} catch (SQLException e) {
			throw new DaoException("Error on getting sparePart", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}
		return sparePart;
	}
	
	public void modifySparePart(SparePart sparePart) {
		String sql = "update sparepart set vesion=?, " +
												"price=?, " +
												"amount=?, " +
												"intime=?, " +
												"alertamount=?, " +
												"stockstate=? " +
									"where partname=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, sparePart.getVesion());
			pstmt.setInt(2, sparePart.getPrice());
			pstmt.setInt(3, sparePart.getAmount());
			pstmt.setDate(4, sparePart.getInTime());
			pstmt.setInt(5, sparePart.getAlertAmount());
			pstmt.setString(6, sparePart.getStockState());
			pstmt.setString(7, sparePart.getPartName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Error on updating sparePart", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}
	}
}
