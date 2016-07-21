package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.SparePart;
import service.SparePartManagerService;
import utils.ServiceException;

public class CheckSparePartsManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public CheckSparePartsManager(){
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
	
		try{
			HttpSession session = request.getSession();
			String service = (String)session.getAttribute("service");
			if(service.equals("find")){
				SparePartManagerService spms = new SparePartManagerService();
				List<SparePart> spList = spms.findAllSparePart();
				int i = 0;
				for(i=0;i<spList.size();i++){
					System.out.println(spList.get(i).getPartName());
				}
				
				String name =new String(request.getParameter("spareParts_Name").getBytes("ISO-8859-1"),"utf-8");
				System.out.println("zheshi:" + name);
				boolean a;
				for(i = 0;i < spList.size();){
					
					a=!spList.get(i).getPartName().equals(name);
					System.out.println(i);
					System.out.println(a);
					if(!spList.get(i).getPartName().equals(name)){
						spList.remove(i);
					}else{
						i++;
					}
				}
				
				System.out.println("afterDel");
				for(i=0;i<spList.size();i++){
					System.out.println(spList.get(i).getPartName());
				}
				
				if(spList.isEmpty()){
					RequestDispatcher rd = request.getRequestDispatcher("/html/stock/noElement.jsp");
					rd.forward(request, response);
				}else{
					request.setAttribute("spList", spList);
					RequestDispatcher rd = request.getRequestDispatcher("/html/stock/printss.jsp");
					rd.forward(request, response);
				}
			}
		}catch (ServiceException e) {
//			request.setAttribute("errorMsg", e.getMessage());
//			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
//			rd.forward(request, response);
			e.printStackTrace();
		} catch (Exception e) {
//			request.setAttribute("errorMsg", "δ֪������" + e.getStackTrace());
//			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
//			rd.forward(request, response);
			e.printStackTrace();
		}	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
}
