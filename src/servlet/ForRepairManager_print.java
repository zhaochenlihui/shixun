package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import domain.CustomerSure;

import service.CustomerSureManagerService;
import utils.ServiceException;


public class ForRepairManager_print extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForRepairManager_print() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void destroy() {
		super.destroy(); 
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
		CustomerSureManagerService ums = CustomerSureManagerService.getInstance();
		CustomerSure customersure=ums.findCustomerSureByNo(repairNo);
//        System.out.println(customersure.getFailureAppear());
		request.setAttribute("customersure", customersure);
//		request.setAttribute("repairNo", repairNo);
		RequestDispatcher rd = request.getRequestDispatcher("html/forRepair_print/forRepair_frame_footer.jsp");//需要修改
		rd.forward(request, response);
	}

}
