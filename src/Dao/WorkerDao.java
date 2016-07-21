package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Worker;
import utils.DBUtils;
import utils.DaoException;

public class WorkerDao {
	private Connection connection;
	
	public WorkerDao(Connection conn){
		this.connection=conn;
	}
	
	/**
	 * 增加用户
	 * @param worker 公司工作人员
	 */
	public void addWorker(Worker worker){
		String sql = "insert into worker (workerName, " +        // 用户名
			    							"password, " +		// 密码
			    							"workerType, " +		// 职工工种
			    							"workerNo) " +        //职工编号
			    	 "values(?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, worker.getWorkerName());
			pstmt.setString(2, worker.getPassword());
			pstmt.setString(3, worker.getWorkerType());
			pstmt.setLong(4, worker.getWorkerNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Error on adding user", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}
	}
	
	/**
	 * 删除用户
	 * @param worker 公司工作人员
	 */
	public void deleteWorker(String[] workerNoList){
		StringBuffer sbfSql = new StringBuffer();
		for (int i = 0; i < workerNoList.length; i++) {
			sbfSql.append("'").append(workerNoList[i]).append("'").append(",");
		}
		String sql = "delete from worker where workerNo in ("
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
	 * 查询所有用户
	 * @return workerList 所有员工的集合
	 */
	public List<Worker> findAllWorkerList(){
		String sql = "select * from worker order by workerNo ";
		Statement stmt = null;
		ResultSet rs = null;
		List<Worker> workerList = new ArrayList<Worker>();
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Worker worker = new Worker();
				worker.setWorkerNo(rs.getInt("workerNo"));					                 // 职工编号
				worker.setWorkerName(rs.getString("WorkerName"));		 // 职工名
				worker.setPassword(rs.getString("password"));			 // 密码
				worker.setWorkerType(rs.getString("workType"));			 // 职工工种
				workerList.add(worker);
			}
		} catch (SQLException e) {
			throw new DaoException("Error on finding user", e);
		} finally {
			DBUtils.closeStatement(stmt);
		}
		return workerList;
	}
	
	/**
	 * 查询用户
	 * @param workerNo 职工编号
	 * @return worker 职工信息
	 */
	public Worker findWorkerByNo(int workerNo) {
		String sql = "select * from worker where workerNo=?";
		Worker worker = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, workerNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				worker = new Worker();
				worker.setWorkerNo(rs.getInt("workerNo"));
				worker.setWorkerName(rs.getString("workerName"));
				worker.setPassword(rs.getString("password"));
				worker.setWorkerType(rs.getString("workType"));
			}
		} catch (SQLException e) {
			throw new DaoException("Error on getting user", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}
		return worker;
	}

	/**
	 * 修改用户信息
	 * @param worker 职工信息
	 */
	public void updateWorker(Worker user) {
		String sql = "update worker set workerName=?, " +	// 用户们
										  "password=?, " +	// 密码
										  "workerType=? " + // 职工工种
								    "where workerNo=?";		// 职工编号
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, user.getWorkerName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getWorkerType());
			pstmt.setLong(4, user.getWorkerNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Error on updating user", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}
	}
	
	public List<Worker> findWorker(Worker u){
		Statement stmt = null;
		ResultSet rs = null;
		List<Worker> userList = new ArrayList<Worker>();
		String sql = "select * from worker where";
		if(u.getWorkerName()!=null && !u.getWorkerName().equals(""))
		{
//			sql+=" and workerName='"+u.getWorkerName()+"'";
			sql+=" workerName='"+u.getWorkerName()+"'";
		}
//		if(u.getWorkType()!=null && !u.getWorkType().equals(""))
//		{
//			sql+=" and workerType='"+u.getWorkType()+"'";
//		}
		if(u.getPassword()!=null )
		{
			sql+=" and password='"+u.getPassword()+"'";
			//sql+=" and credate=to_date('"+u.getBirthDate()+"','yyyy-mm-dd')";
		}
		System.out.println(sql);
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Worker worker = new Worker();
				worker.setWorkerNo(rs.getInt("workerNo"));
				worker.setWorkerName(rs.getString("workerName"));
				worker.setPassword(rs.getString("password"));
				worker.setWorkerType(rs.getString("workerType"));
				userList.add(worker);
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
