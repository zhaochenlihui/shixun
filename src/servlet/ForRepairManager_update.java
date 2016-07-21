package servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import domain.ForRepair;
import domain.Machine;
import domain.Repair;
import service.ForRepairManagerService;
import service.MachineManagerService;
import service.RepairManagerService;
import utils.ServiceException;

public class ForRepairManager_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForRepairManager_update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Machine u=new Machine();
		ForRepair t=new ForRepair();
		int repairNo;
		int customerNo;
		double previewCost;
		Date deliverTime;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date newDate = null;
		
			try {
				newDate = sdf.parse(request.getParameter("deliverTime"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			deliverTime= new Date(newDate.getTime());
			t.setDeliverTime(deliverTime);
			String productType = new String(request.getParameter("productType").getBytes("ISO-8859-1"),"utf-8");
			t.setProductType(productType);
			String failureType = new String(request.getParameter("failureType").getBytes("ISO-8859-1"),"utf-8");
			u.setFailureType(failureType);
			String deliverState = new String(request.getParameter("deliverState").getBytes("ISO-8859-1"),"utf-8");
			t.setDeliverState(deliverState);
		repairNo = Integer.parseInt(request.getParameter("repairNo"));
		u.setRepairNo(repairNo);
		previewCost = Double.parseDouble(request.getParameter("previewCost"));
		t.setPreviewCost(previewCost);
		customerNo = Integer.parseInt(request.getParameter("customerNo"));
		t.setCustomerNo(customerNo);
		t.setRepairNo(repairNo);
		String machineBrand = new String(request.getParameter("machineBrand").getBytes("ISO-8859-1"),"utf-8");
		u.setMachineBrand(machineBrand);
		t.setMachineBrand(machineBrand);
		u.setMachineVesion(request.getParameter("machineVesion"));
		u.setSeriesNumber(request.getParameter("seriesNumber"));
		String lackPart = new String(request.getParameter("lackPart").getBytes("ISO-8859-1"),"utf-8");
		u.setLackPart(lackPart);
		String failureAppear = new String(request.getParameter("failureAppear").getBytes("ISO-8859-1"),"utf-8");
		u.setFailureAppear(failureAppear);
		String outlook = new String(request.getParameter("outlook").getBytes("ISO-8859-1"),"utf-8");
		u.setOutlook(outlook);
		u.setOnPassword(request.getParameter("onPassword"));	
		
		String importantM = new String(request.getParameter("importantM").getBytes("ISO-8859-1"),"utf-8");
		u.setImportantM(importantM);
		u.setHDD(request.getParameter("HDD"));
		u.setMemory(request.getParameter("memory"));
		u.setPcCard(request.getParameter("pcCard"));
		u.setAC(request.getParameter("AC"));
		u.setBattery(request.getParameter("battery"));
		u.setCDDriver(request.getParameter("CDDriver"));
		u.setSoftDriver(request.getParameter("softDriver"));
		u.setOther(request.getParameter("others"));
		MachineManagerService ums = new MachineManagerService();
		ums.modifyMachine(u);	
		ForRepairManagerService tms = new ForRepairManagerService();
		tms.modifyForRepair(t);
		RequestDispatcher rd = request.getRequestDispatcher("html/content.html");
		rd.forward(request, response);
	}

}
