package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.ServiceException;
import domain.SparePart;
import domain.SparePartOut;
import service.SparePartManagerService;
import service.SparePartOutManagerService;

public class SparePartOutManager extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public SparePartOutManager(){
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		try {
			
			//��ȡ����
			HttpSession session = request.getSession();
			String service = (String)session.getAttribute("service");
			System.out.println("http" + service);
			//�û������б�
			if(service == null || service.equals("") || service.equals("list")){
				System.out.println((new java.util.Date()).toString() + "�������г������б�");
				SparePartManagerService spms = new SparePartManagerService();
				List<SparePart> spList = spms.findAllSparePart();
				request.setAttribute("spList", spList);
				RequestDispatcher rd = request.getRequestDispatcher("/Worker/check-inventory.jsp");
				rd.forward(request, response);
//				response.setContentType("text/html;charset=UTF-8");
//				PrintWriter out =response.getWriter();
//				String title = "Print table---\"SparePartOut";
//				String docType ="<!doctype html>";
//				out.println(docType +
//						"<html>\n" +
//						"<head><meta charset=\"utf-8><title>" + title + "</title></head>\n" +
//						"<body>\n" +
//						"<table width=\"100%\" border=1 style=text-align:center>" +
//						"<tr>\n" +
//						"<th>�������</th>\n" + 
//						"<th>�ͺ�</th>\n" +
//						"<th>����</th>\n" +
//						"<th>����</th>\n" +
//						"<th>���ʱ��</th>\n" +
//						"<th>��������</th>\n" +
//						"<th>���״̬</th>\n" +
//						"</tr>\n");
//				int i=0;
//				for(i=0;i<spList.size();i++){
//					out.print("<tr>\n" +
//							"<th>" + spList.get(i).getPartName() + "</th>\n" +
//							"<th>" + spList.get(i).getVesion() + "</th>\n" +
//							"<th>" + spList.get(i).getPrice() + "</th>\n" +
//							"<th>" + spList.get(i).getAmount() + "</th>\n" +
//							"<th>" + spList.get(i).getInTime() + "</th>\n" +
//							"<th>" + spList.get(i).getAlertAmount() + "</th>\n" +
//							"<th>" + spList.get(i).getStockState() + "</th>\n" +
//							"</tr>\n");
//				}
//				out.print("</table>\n" +
//						"</body>\n" +
//						"</html>\n");
			}else if(service.equals("Stock-out")){
				System.out.println((new java.util.Date()).toString() + "�����󱸼�����");
				SparePartManagerService spms = new SparePartManagerService();
				String spName = new String(request.getParameter("spareParts_Name").getBytes("ISO-8859-1"),"utf-8");
				System.out.println("������ƣ�" + spName);
				SparePart sp = spms.findSparePartByNo(spName);
				
				SparePartOutManagerService spoms = new SparePartOutManagerService();
				SparePartOut spo = new SparePartOut();
				spo.setPartName( new String(request.getParameter("spareParts_Name").getBytes("ISO-8859-1"),"utf-8"));
				spo.setVesion( new String(request.getParameter("spareParts_ModelNo").getBytes("ISO-8859-1"),"utf-8"));
				spo.setRepairNO( Integer.parseInt(request.getParameter("spareParts_FixNo")));
				spo.setPrice(Integer.parseInt(request.getParameter("spareParts_UnitPrice")));
				spo.setAmount(Integer.parseInt("-" + request.getParameter("spareParts_Quantity")));
				String sDate = new String(request.getParameter("spareParts_StockoutTime").getBytes("ISO-8859-1"),"utf-8");
				System.out.println(sDate);
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//Сд��mm��ʾ���Ƿ���  
				String dstr= sDate;  
				java.sql.Date date=new java.sql.Date(sdf.parse(dstr).getTime());  
				spo.setOutTime(date);
				spoms.addSparePartOut(spo);

				
				if (sp != null){
					System.out.println("chenggong!");
					int spQuantity = sp.getAmount();
					System.out.println(spQuantity);
					System.out.println(Integer.parseInt(request.getParameter("spareParts_Quantity")));
					if(spQuantity == Integer.parseInt(request.getParameter("spareParts_Quantity"))){
						String[] delSpID = new String[]{""};
						delSpID[0] = spName;
						spms.deleteSparePart(delSpID);
					}else{
						sp.setAmount(spQuantity - Integer.parseInt(request.getParameter("spareParts_Quantity")));
						spms.modifySparePart(sp);
					}
				}else {
					System.out.println("error��");
				}
				RequestDispatcher rd = request.getRequestDispatcher("/html/stock/check-inventory.jsp");
				rd.forward(request, response);
			}else if(service.equals("Stock-in")){
				System.out.println((new java.util.Date()).toString() + "�����󱸼����");
				SparePartManagerService spms = new SparePartManagerService();
				String spName = new String(request.getParameter("spareParts_Name").getBytes("ISO-8859-1"),"utf-8");
				System.out.println("������ƣ�" + spName);
				SparePart sp = spms.findSparePartByNo(spName);
				System.out.println(Integer.parseInt(request.getParameter("spareParts_Quantity")));
				
				SparePartOutManagerService spoms = new SparePartOutManagerService();
				SparePartOut spo = new SparePartOut();
				spo.setPartName( new String(request.getParameter("spareParts_Name").getBytes("ISO-8859-1"),"utf-8"));
				spo.setVesion( new String(request.getParameter("spareParts_ModelNo").getBytes("ISO-8859-1"),"utf-8"));
				spo.setRepairNO( Integer.parseInt(request.getParameter("spareParts_FixNo")));
				spo.setPrice(Integer.parseInt(request.getParameter("spareParts_UnitPrice")));
				spo.setAmount(Integer.parseInt(request.getParameter("spareParts_Quantity")));
				String sDate = new String(request.getParameter("spareParts_StockoutTime").getBytes("ISO-8859-1"),"utf-8");
				System.out.println(sDate);
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//Сд��mm��ʾ���Ƿ���  
				String dstr= sDate;  
				java.sql.Date date=new java.sql.Date(sdf.parse(dstr).getTime());  
				spo.setOutTime(date);
				spoms.addSparePartOut(spo);
				
				if(sp != null){
					System.out.println("����������");
					int spQuantity = sp.getAmount();
					sp.setAmount(spQuantity + Integer.parseInt(request.getParameter("spareParts_Quantity")));
					spms.modifySparePart(sp);
				}else{
					System.out.println("��������");
					sp = new SparePart();
					sp.setPartName( new String(request.getParameter("spareParts_Name").getBytes("ISO-8859-1"),"utf-8"));
					sp.setVesion( new String(request.getParameter("spareParts_ModelNo").getBytes("ISO-8859-1"),"utf-8"));
//					sp.setRepairNO( Integer.parseInt(request.getParameter("spareParts_FixNo")));
					sp.setPrice(Integer.parseInt(request.getParameter("spareParts_UnitPrice")));
					sp.setAmount(Integer.parseInt(request.getParameter("spareParts_Quantity")));
					Date dNow = new Date( );     
				      SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
				      String dateN = ft.format(dNow);
					sp.setInTime(new java.sql.Date(ft.parse(dateN).getTime()));
			
//					String sDate = new String(request.getParameter("spareParts_StockoutTime").getBytes("ISO-8859-1"),"utf-8");
//					System.out.println(sDate);
//					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//Сд��mm��ʾ���Ƿ���  
//					String dstr= sDate;  
//					java.sql.Date date=new java.sql.Date(sdf.parse(dstr).getTime());  
//					sp.setOutTime(date);
					
					spms.addSparePart(sp);
				}
				RequestDispatcher rd = request.getRequestDispatcher("/html/stock/check-inventory.jsp");
				rd.forward(request, response);
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
