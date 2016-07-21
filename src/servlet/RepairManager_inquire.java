package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import domain.Repair;

import service.RepairManagerService;
import utils.ServiceException;

public class RepairManager_inquire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RepairManager_inquire() {
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
		int repairNo;
		repairNo= Integer.parseInt(request.getParameter("repairNo"));		
		RepairManagerService ums = RepairManagerService.getInstance();
		Repair repair=ums.findRepairByNo(repairNo);
//		System.out.println(repair.getRepairRecord());
//System.out.println(clearfee.getLinkmen());
		
		request.setAttribute("repair", repair);
		RequestDispatcher rd = request.getRequestDispatcher("html/repair/inquire.jsp");//需要修改
		rd.forward(request, response);
	}

}
