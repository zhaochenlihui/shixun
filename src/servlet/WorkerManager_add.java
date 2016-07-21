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



import domain.Worker;
import service.WorkerManagerService;

import utils.ServiceException;

public class WorkerManager_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkerManager_add() {
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
		Worker u=new Worker();
		int workerNo;
		workerNo = Integer.parseInt(request.getParameter("workerNo"));
		u.setWorkerNo(workerNo);
		String WorkerType=request.getParameter("workerType");
		u.setWorkerType(WorkerType);
		//u.setWorkerType(request.getParameter("WorkerType"));
		//u.setWorkerType("家庭用户");
		u.setWorkerName(request.getParameter("workerName"));
		u.setPassword(request.getParameter("password"));	
		WorkerManagerService ums = new WorkerManagerService();
		ums.addWorker(u);		
		RequestDispatcher rd = request.getRequestDispatcher("html/start.jsp");
		rd.forward(request, response);
	}

}
