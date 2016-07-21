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







import domain.Customer;
import service.CustomerManagerService;
import utils.ServiceException;
public class CustomerManager_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerManager_update() {
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
		Customer u=new Customer();
		int customerNo;
		Date deliverTime;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date newDate = null;
		
			try {
				newDate = sdf.parse(request.getParameter("deliverTime"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			deliverTime= new Date(newDate.getTime());
		customerNo = Integer.parseInt(request.getParameter("customerNo"));
		u.setCustomerNo(customerNo);
		u.setIDCard(request.getParameter("IDCard"));
		u.setDeliverTime(deliverTime);
		String customerType= new String(request.getParameter("customerType").getBytes("ISO-8859-1"),"utf-8");
		u.setCustomerType(customerType);
		//u.setCustomerType(request.getParameter("customerType"));
		//u.setCustomerType("家庭用户");
		String company= new String(request.getParameter("company").getBytes("ISO-8859-1"),"utf-8");
		u.setCompany(company);
		u.setHomePhone(request.getParameter("homePhone"));
		u.setMobilePhone(request.getParameter("mobilePhone"));
		
		String address= new String(request.getParameter("address").getBytes("ISO-8859-1"),"utf-8");
		u.setCompany(address);
		u.setPostcode(request.getParameter("postcode"));
		String linkmen= new String(request.getParameter("linkmen").getBytes("ISO-8859-1"),"utf-8");
		u.setLinkmen(linkmen);
		u.setEmail(request.getParameter("email"));	
		CustomerManagerService ums = CustomerManagerService.getInstance();
		ums.modifyCustomer(u);	
		RequestDispatcher rd = request.getRequestDispatcher("html/content.html");
		rd.forward(request, response);
	}

}
