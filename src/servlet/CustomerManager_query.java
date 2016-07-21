package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import domain.Customer;
import service.CustomerManagerService;
import utils.ServiceException;

public class CustomerManager_query extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerManager_query() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int customer_number;
		customer_number= Integer.parseInt(request.getParameter("customerNo"));		
		CustomerManagerService ums = CustomerManagerService.getInstance();
		Customer customer=ums.findCustomerByNo(customer_number);

		request.setAttribute("customer", customer);
//		request.setAttribute("customerNo", customer_number);
		RequestDispatcher rd = request.getRequestDispatcher("html/update.jsp");//需要修改
		rd.forward(request, response);
	}

}
