package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Machine;
import utils.DBUtils;
import utils.DaoException;

public class MachineDao {
	private Connection connection;
	
	public MachineDao(Connection conn){
		this.connection=conn;
	}
	
	/**
	 * ���ӻ�������
	 * @param machine ������Ϣ
	 */
	public void addMachine(Machine mac){
		String sql = "insert into machine (repairNo, " +       // ά�ޱ��
											"machineBrand, " +   // ����Ʒ��
											"machineVesion, " +  // �����ͺ�
			    							"seriesNumber, " +	 // �ͻ����
			    							"lackPart, " +	     // ��Ʒ����
			    							"failureAppear, " +	 // ��Ʒ����
			    							"failureType, " +	 // ��Ʒ����
			    							"outlook, " +	     // ��Ʒ����
			    							"onPassword, " +     // �ͻ�ʱ��
			    							"importantM, " +     // �ͻ�ʱ��
			    							"HDD, " +            // �ͻ�ʱ��
			    							"memory, " +         // �ͻ�ʱ��
			    							"pcCard, " +         // �ͻ�ʱ��
			    							"AC, " +             // �ͻ�ʱ��
			    							"battery, " +        // �ͻ�ʱ��
			    							"CDDriver, " +       // �ͻ�ʱ��
			    							"softDriver, " +     // Ԥ���۸�
			    							"others) " +         // ����״̬
			    	 "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, mac.getRepairNo());
			pstmt.setString(2, mac.getMachineBrand());
			pstmt.setString(3, mac.getMachineVesion());
			pstmt.setString(4, mac.getSeriesNumber());
			pstmt.setString(5, mac.getLackPart());
			pstmt.setString(6, mac.getFailureAppear());
			pstmt.setString(7, mac.getFailureType());
			pstmt.setString(8, mac.getOutlook());
			pstmt.setString(9, mac.getOnPassword());
			pstmt.setString(10, mac.getImportantM());
			pstmt.setString(11, mac.getHDD());
			pstmt.setString(12, mac.getMemory());
			pstmt.setString(13, mac.getPcCard());
			pstmt.setString(14, mac.getAC());
			pstmt.setString(15, mac.getBattery());
			pstmt.setString(16, mac.getCDDriver());
			pstmt.setString(17, mac.getSoftDriver());
			pstmt.setString(18, mac.getOthers());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
//			throw new DaoException("Error on adding user", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}
	}
	
	/**
	 * ɾ�������Ϣ
	 * @param machine ����
	 */
	public void deleteMachine(String[] repairNoList){
		StringBuffer sbfSql = new StringBuffer();
		for (int i = 0; i < repairNoList.length; i++) {
			sbfSql.append("'").append(repairNoList[i]).append("'").append(",");
		}
		String sql = "delete from machine where repairNo in ("
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
	/*public List<Machine> findAllforRepairList(){
		String sql = "select * from forRepair order by forRepairNo ";
		Statement stmt = null;
		ResultSet rs = null;
		List<Machine> forRepairList = new ArrayList<Machine>();
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Machine forRepair = new Machine();
				int i = Integer.parseInt(rs.getString("repairNo"));
				forRepair.setRepairNo(i);					                     // ά�ޱ��
				forRepair.setCustomerNo(rs.getInt("customerNo"));		         // �ͻ����
				forRepair.setProductType(rs.getString("productType"));		     // ��Ʒ����
				forRepair.setMachineBrand(rs.getString("machineBrand"));		 // ����Ʒ��
				forRepair.setDeliverTime(rs.getDate("deliverTime"));			 // �ͻ�ʱ��
				forRepair.setPreviewCost(rs.getFloat("previewCost"));			 // Ԥ���۸�
				forRepair.setDeliverState(rs.getString("deliverState"));	     // ����״̬
				forRepairList.add(forRepair);
			}
		} catch (SQLException e) {
			throw new DaoException("Error on finding user", e);
		} finally {
			DBUtils.closeStatement(stmt);
		}
		return forRepairList;
	}*/
	
	/**
	 * ��ѯ������Ϣ
	 * @param repairNo ά�ޱ��
	 * @return machine ������Ϣ
	 */
	public Machine findMachineByNo(int repairNo){
		String sql = "select * from machine where repairNo=?";
		Machine mac = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, repairNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mac = new Machine();
				mac.setRepairNo(rs.getInt("repairNo"));        // ά�ޱ��					                     // ά�ޱ��
			    mac.setMachineBrand(rs.getString("machineBrand"));    
				mac.setMachineVesion(rs.getString("machineVesion"));
				mac.setSeriesNumber(rs.getString("seriesNumber"));
				mac.setLackPart(rs.getString("lackPart"));
				mac.setFailureAppear(rs.getString("failureAppear"));
				mac.setFailureType(rs.getString("failureType"));
				mac.setOutlook(rs.getString("outlook"));
				mac.setOnPassword(rs.getString("onPassword"));
				mac.setImportantM(rs.getString("importantM"));
				mac.setHDD(rs.getString("HDD"));
				mac.setMemory(rs.getString("memory"));
				mac.setPcCard(rs.getString("pcCard"));
				mac.setAC(rs.getString("AC"));
				mac.setBattery(rs.getString("battery"));
				mac.setCDDriver(rs.getString("CDDriver"));
				mac.setSoftDriver(rs.getString("softDriver"));
				mac.setOther(rs.getString("others"));
			}
		} catch (SQLException e) {
			throw new DaoException("Error on getting user", e);
		} finally {
			DBUtils.closeStatement(pstmt);
		}
		return mac;
	}

	/**
	 * �޸ı�����Ϣ
	 * @param forRepair �ͻ���Ϣ
	 */
	public void updateMachine(Machine mac){
		String sql = "update machine set machineBrand=?, " +   // ����Ʒ��
										"machineVesion=?, " +  // �����ͺ�
										"seriesNumber=?, " +	 // �ͻ����
										"lackPart=?, " +	     // ��Ʒ����
										"failureAppear=?, " +	 // ��Ʒ����
										"failureType=?, " +	 // ��Ʒ����
										"outlook=?, " +	     // ��Ʒ����
										"onPassword=?, " +     // �ͻ�ʱ��
										"importantM=?, " +     // �ͻ�ʱ��
										"HDD=?, " +            // �ͻ�ʱ��
										"memory=?, " +         // �ͻ�ʱ��
										"pcCard=?, " +         // �ͻ�ʱ��
										"AC=?, " +             // �ͻ�ʱ��
										"battery=?, " +        // �ͻ�ʱ��
										"CDDriver=?, " +       // �ͻ�ʱ��
										"softDriver=?, " +     // Ԥ���۸�
										"others=? " +         // ����״̬
										"where repairNo=?";     // ά�ޱ��
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, mac.getMachineBrand());
			pstmt.setString(2, mac.getMachineVesion());
			pstmt.setString(3, mac.getSeriesNumber());
			pstmt.setString(4, mac.getLackPart());
			pstmt.setString(5, mac.getFailureAppear());
			pstmt.setString(6, mac.getFailureType());
			pstmt.setString(7, mac.getOutlook());
			pstmt.setString(8, mac.getOnPassword());
			pstmt.setString(9, mac.getImportantM());
			pstmt.setString(10, mac.getHDD());
			pstmt.setString(11, mac.getMemory());
			pstmt.setString(12, mac.getPcCard());
			pstmt.setString(13, mac.getAC());
			pstmt.setString(14, mac.getBattery());
			pstmt.setString(15, mac.getCDDriver());
			pstmt.setString(16, mac.getSoftDriver());
			pstmt.setString(17, mac.getOthers());
			pstmt.setInt(18, mac.getRepairNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
//			throw new DaoException("Error on updating user", e);
			
		} finally {
			DBUtils.closeStatement(pstmt);
		}
	}
	
	public List<Machine> findMachine(Machine u){
		Statement stmt = null;
		ResultSet rs = null;
		List<Machine> macList = new ArrayList<Machine>();
		String sql = "select * from machine where repairNo="+u.getRepairNo();
		if(u.getMachineBrand()!=null && !u.getMachineBrand().equals(""))
		{
			sql+=" and machineBrand='"+u.getMachineBrand()+"'";
		}
		if(u.getMachineVesion()!=null && !u.getMachineVesion().equals(""))
		{
			sql+=" and machineVesion='"+u.getMachineVesion()+"'";
		}
		if(u.getSeriesNumber()!=null && !u.getSeriesNumber().equals(""))
		{
			sql+=" and seriesNumber='"+u.getSeriesNumber()+"'";
		}
		if(u.getLackPart()!=null && !u.getLackPart().equals(""))
		{
			sql+=" and lackPart='"+u.getLackPart()+"'";
		}
		if(u.getFailureAppear()!=null && !u.getFailureAppear().equals(""))
		{
			sql+=" and failureAppear='"+u.getFailureAppear()+"'";
		}
		if(u.getFailureType()!=null && !u.getFailureType().equals(""))
		{
			sql+=" and failureType='"+u.getFailureType()+"'";
		}
		if(u.getOutlook()!=null && !u.getOutlook().equals(""))
		{
			sql+=" and outlook='"+u.getOutlook()+"'";
		}
		if(u.getOnPassword()!=null && !u.getOnPassword().equals(""))
		{
			sql+=" and onpassward='"+u.getOnPassword()+"'";
		}
		if(u.getImportantM()!=null && !u.getImportantM().equals(""))
		{
			sql+=" and importantM='"+u.getImportantM()+"'";
		}
		if(u.getHDD()!=null && !u.getHDD().equals(""))
		{
			sql+=" and HDD='"+u.getHDD()+"'";
		}
		if(u.getMemory()!=null && !u.getMemory().equals(""))
		{
			sql+=" and memory='"+u.getMemory()+"'";
		}
		if(u.getPcCard()!=null && !u.getPcCard().equals(""))
		{
			sql+=" and pcCard='"+u.getPcCard()+"'";
		}
		if(u.getAC()!=null && !u.getAC().equals(""))
		{
			sql+=" and AC='"+u.getAC()+"'";
		}
		if(u.getBattery()!=null && !u.getBattery().equals(""))
		{
			sql+=" and battery='"+u.getBattery()+"'";
		}
		if(u.getCDDriver()!=null && !u.getCDDriver().equals(""))
		{
			sql+=" and CDDriver='"+u.getCDDriver()+"'";
		}
		if(u.getSoftDriver()!=null && !u.getSoftDriver().equals(""))
		{
			sql+=" and softDriver='"+u.getSoftDriver()+"'";
		}
		if(u.getOthers()!=null && !u.getOthers().equals(""))
		{
			sql+=" and others='"+u.getOthers()+"'";
		}
		System.out.println(sql);
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Machine mac = new Machine();
				mac.setRepairNo(rs.getInt("repairNo"));        // ά�ޱ��					                     // ά�ޱ��
			    mac.setMachineBrand(rs.getString("machineBrand"));    
				mac.setMachineVesion(rs.getString("machineVesion"));
				mac.setSeriesNumber(rs.getString("seriesNumber"));
				mac.setLackPart(rs.getString("lackPart"));
				mac.setFailureAppear(rs.getString("failureAppear"));
				mac.setFailureType(rs.getString("failureType"));
				mac.setOutlook(rs.getString("outlook"));
				mac.setOnPassword(rs.getString("onPassword"));
				mac.setImportantM(rs.getString("importantM"));
				mac.setHDD(rs.getString("HDD"));
				mac.setMemory(rs.getString("memory"));
				mac.setPcCard(rs.getString("pcCard"));
				mac.setAC(rs.getString("AC"));
				mac.setBattery(rs.getString("battery"));
				mac.setCDDriver(rs.getString("CDDriver"));
				mac.setSoftDriver(rs.getString("softDriver"));
				mac.setOther(rs.getString("others"));
				macList.add(mac);
			}
		} catch (SQLException e) {
			//throw new DaoException("Error on finding user", e);
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(stmt);
		}
		return macList;
	}
}
