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

public class RepairManager_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RepairManager_update() {
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
		Date testTime;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date newDate = null;

			try {
				newDate = sdf.parse(request.getParameter("testTime"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			testTime= new Date(newDate.getTime());
			u.setTestTime(testTime);

		repairNo = Integer.parseInt(request.getParameter("repairNo"));
		u.setRepairNo(repairNo);
		String repairWork = new String(request.getParameter("repairWork").getBytes("ISO-8859-1"),"utf-8");
		u.setRepairWork(repairWork);
		String testRecord = new String(request.getParameter("testRecord").getBytes("ISO-8859-1"),"utf-8");
		u.setTestRecord(testRecord);
		String repairRecord = new String(request.getParameter("repairRecord").getBytes("ISO-8859-1"),"utf-8");
		u.setRepairRecord(repairRecord);
		String workAmount = new String(request.getParameter("workAmount").getBytes("ISO-8859-1"),"utf-8");
		u.setWorkAmount(workAmount);
		String usePart = new String(request.getParameter("usePart").getBytes("ISO-8859-1"),"utf-8");
		u.setUsePart(usePart);
		String repairState = new String(request.getParameter("repairState").getBytes("ISO-8859-1"),"utf-8");
		u.setRepairState(repairState);
		RepairManagerService ums = new RepairManagerService();
		ums.modifyRepair(u);		
		RequestDispatcher rd = request.getRequestDispatcher("html/content.html");
		rd.forward(request, response);
	}

}
