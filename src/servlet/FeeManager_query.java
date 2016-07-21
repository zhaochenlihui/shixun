package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ClearFee;

import service.ClearFeeManagerService;

import utils.ServiceException;


public class FeeManager_query extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeeManager_query() {
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
		ClearFeeManagerService ums = ClearFeeManagerService.getInstance();
		ClearFee clearfee=ums.findClearFeeByNo(repairNo);
//System.out.println(clearfee.getLinkmen());
		request.setAttribute("clearfee", clearfee);
		RequestDispatcher rd = request.getRequestDispatcher("html/inquiryClearingFee/Settlement_Print_footer.jsp");//需要修改
		rd.forward(request, response);
	}

}
