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



import domain.Repair;
import service.RepairManagerService;
import utils.ServiceException;

public class RepairManager_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RepairManager_delete() {
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
		Repair u=new Repair();
		int repairNo; 
		repairNo= Integer.parseInt(request.getParameter("repairNo"));
//		String[] repair = request.getParameterValues("repair");
		RepairManagerService ums = RepairManagerService.getInstance();
		ums.deleteRepairbyNo(repairNo);	// 删除用户
//		RequestDispatcher rd = request.getRequestDispatcher("html/repair/Repair_inquire.jsp");

//		System.out.println(repairNo);
		
		RequestDispatcher rd = request.getRequestDispatcher("html/content.html");
		rd.forward(request, response);

	}

}
