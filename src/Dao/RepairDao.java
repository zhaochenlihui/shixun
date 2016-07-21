package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Repair;
import utils.DBUtils;
import utils.DaoException;

public class RepairDao {

	private Connection connection;
	public RepairDao(Connection conn){
		this.connection=conn;
	}
	
	public void addRepair(Repair repair){
		String sql= "insert into repair (repairNo, " +
											"repairWork, "+
											"testRecord, "+
											"repairRecord, "+
											"testTime, "+
											"workAmount, "+
											"usePart, "+
											"repairState) "+
					"values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=null;
		try{
			pstmt= connection.prepareStatement(sql);
			pstmt.setInt(1, repair.getRepairNo());
			pstmt.setString(2, repair.getRepairWork());
			pstmt.setString(3, repair.getTestRecord());
			pstmt.setString(4,repair.getRepairRecord());
			pstmt.setDate(5, repair.getTestTime());
			pstmt.setString(6, repair.getWorkAmount());
			pstmt.setString(7, repair.getUsePart());
			pstmt.setString(8, repair.getRepairState());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtils.closeStatement(pstmt);
		}
	}
	
//	public void deleteRepair(String[] repairNoList){
//		StringBuffer sbfSql = new StringBuffer();
//		for (int i = 0; i < repairNoList.length; i++) {
//			sbfSql.append("'").append(repairNoList[i]).append("'").append(",");
//		}
//		String sql = "delete from repair where repairNo in ("
//				+ sbfSql.substring(0, sbfSql.length() - 1) + ")";
//		Statement stmt = null;
//		try {
//			stmt = connection.createStatement();
//			stmt.executeUpdate(sql);
//		} catch (SQLException e) {
//			throw new DaoException("Error on deleting user", e);
//		} finally {
//			DBUtils.closeStatement(stmt);
//		}
//	}
	
	public void deleteRepairbyNo(int t){
//		StringBuffer sbfSql = new StringBuffer();
//		for (int i = 0; i < repairNoList.length; i++) {
//			sbfSql.append("'").append(repairNoList[i]).append("'").append(",");
//		}
		String sql = "delete from repair" + "where repairNo=?" ;
		Statement stmt = null;
		PreparedStatement pstmt=null;
		try {
			pstmt=this.connection.prepareStatement(sql);
			pstmt.setInt(1,t);
			stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			throw new DaoException("Error on deleting user", e);
		} finally {
			DBUtils.closeStatement(stmt);
		}
	}
	
	public  List<Repair> findAllRepairList(){
		String sql = "select * from repair order by repairNo ";
		Statement stmt = null;
		ResultSet rs = null;
		List<Repair> repairList = new ArrayList<Repair>();
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Repair repair = new Repair();
				repair.setRepairNo(rs.getInt("repairNo"));					                 
				repair.setRepairWork(rs.getString("repairWork"));		 
				repair.setTestRecord(rs.getString("testRecord"));			
				repair.setRepairRecord(rs.getString("repairRecord"));
				repair.setTestTime(rs.getDate("testTime"));
				repair.setWorkAmount(rs.getString("workAmount"));
				repair.setUsePart(rs.getString("usePart"));
				repair.setRepairState(rs.getString("repairState"));
				repairList.add(repair);
			}
		} catch (SQLException e) {
			throw new DaoException("Error on finding user", e);
		} finally {
			DBUtils.closeStatement(stmt);
		}
		return repairList;
	}
	
	public Repair findRepairByNo(int repairNo){
		String sql="select * from repair where repairNo=?";
		Repair repair=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		try{
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, repairNo);
			rs = pstmt.executeQuery();
			if(rs.next()){
				repair = new Repair();
				repair.setRepairNo(rs.getInt("repairNo"));					                 
				repair.setRepairWork(rs.getString("repairWork"));		 
				repair.setTestRecord(rs.getString("testRecord"));			
				repair.setRepairRecord(rs.getString("repairRecord"));
				repair.setTestTime(rs.getDate("testTime"));
				repair.setWorkAmount(rs.getString("workAmount"));
				repair.setUsePart(rs.getString("usePart"));
				repair.setRepairState(rs.getString("repairState"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtils.closeStatement(pstmt);
		}
		return repair;
	}
	
	public void modifyRepair(Repair repair){
		String sql = "update repair set repairWork=?, "+
											"testRecord=?, "+
											"repairRecord=?, "+
											"testTime=?, "+
											"workAmount=?, "+
											"usePart=?, "+
											"repairState=? " +
									"where repairNo=?";
		PreparedStatement pstmt = null;
		try{
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, repair.getRepairWork());
			pstmt.setString(2, repair.getTestRecord());
			pstmt.setString(3,repair.getRepairRecord());
			pstmt.setDate(4, repair.getTestTime());
			pstmt.setString(5, repair.getWorkAmount());
			pstmt.setString(6, repair.getUsePart());
			pstmt.setString(7, repair.getRepairState());
			pstmt.setInt(8, repair.getRepairNo());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtils.closeStatement(pstmt);
		}
	}
}
