package servlet;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Worker;
import service.WorkerManagerService;
import utils.ServiceException;

public class WorkerManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkerManager() {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			Worker u=new Worker();
			String t=request.getParameter("workerName");
			String str=new String(t.getBytes("ISO-8859-1"),"UTF-8");
			u.setWorkerName(str);
//			u.setWorkerName(request.getParameter("workerName"));
			u.setPassword(request.getParameter("password"));
			u.setWorkerNo(2);
			u.setWorkerType("客服");
			
			WorkerManagerService ums = WorkerManagerService.getInstance();
			List<Worker> Workers=ums.findWorker(u);
			if(Workers.size()>=1){
			request.setAttribute("Workers", Workers);
			request.setAttribute("u", u);
			RequestDispatcher rd = request.getRequestDispatcher("html/start.jsp");
//			RequestDispatcher rd = request.getRequestDispatcher("/../../WebRoot/Worker/start.jsp");
//			RequestDispatcher rd = request.getRequestDispatcher("start.jsp");

			rd.forward(request, response);}
		}
		/*else if(service.equals("signup")){
			Worker worker = new Worker();
			setWorker(request, worker);
			WorkerManagerService ums = WorkerManagerService.getInstance();
			ums.addWorker(worker);	// 添加用户
			RequestDispatcher rd = request.getRequestDispatcher("/servlet/WorkerManage?service=list");
			rd.forward(request, response);
		
			
		}*/
	//}
	private void setWorker(HttpServletRequest request, Worker worker)  {		
			worker.setWorkerName(request.getParameter("workerName"));
			worker.setPassword(request.getParameter("password"));
		
		} 
	

}
