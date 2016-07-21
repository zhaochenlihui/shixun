package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import domain.ClearFee;
import domain.Fee;
import service.ClearFeeManagerService;
import service.FeeManagerService;
import utils.ServiceException;

/**
 * Servlet implementation class FeeManager
 */

public class FeeManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeeManager() {
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
		Fee u=new Fee();
		int repairNo;
		float repairCost,materialCost;
		Date cleartime;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date newDate = null;	
			try {
//				System.out.println("clearTime:" + request.getParameter("clearTime") + request.getParameter("repairNo"));
				newDate= sdf.parse(request.getParameter("clearTime"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		cleartime= new Date(newDate.getTime());
		repairNo = Integer.parseInt(request.getParameter("repairNo"));
		repairCost=Float.parseFloat(request.getParameter("repairCost"));
		materialCost=Float.parseFloat(request.getParameter("materialCost"));
		u.setRepairNo(repairNo);
		u.setRepairCost(repairCost);
		u.setMaterialCost(materialCost);
		String warranty= new String(request.getParameter("warranty").getBytes("ISO-8859-1"),"utf-8");
		u.setWarranty(warranty);
		String attention= new String(request.getParameter("attention").getBytes("ISO-8859-1"),"utf-8");
		u.setAttention(attention);
		u.setClearTime(cleartime);		
		FeeManagerService ums = FeeManagerService.getInstance();
		ums.addFee(u);	
		RequestDispatcher rd = request.getRequestDispatcher("html/content.html");//需要修改
		rd.forward(request, response);
	}

}
