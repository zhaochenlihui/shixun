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
import service.ForRepairManagerService;
import service.MachineManagerService;
import utils.ServiceException;
public class ForRepairManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForRepairManager() {
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
		MachineManagerService ums = MachineManagerService.getInstance();
		ForRepairManagerService t=ForRepairManagerService.getInstance();
		ForRepair forrepair=t.findForRepairByNo(repairNo);
		Machine machine=ums.findMachineByNo(repairNo);
//        System.out.println(customersure.getFailureAppear());
		request.setAttribute("machine", machine);
		request.setAttribute("forrepair", forrepair);
//		request.setAttribute("repairNo", repairNo);
		RequestDispatcher rd = request.getRequestDispatcher("html/forRepairSet/detail.jsp");//需要修改
		rd.forward(request, response);
	}

}
