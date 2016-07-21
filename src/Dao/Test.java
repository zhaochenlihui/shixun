package Dao;

import java.sql.Date;

import service.FeeManagerService;
import domain.Fee;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fee fee=new Fee();
		FeeManagerService service=new FeeManagerService();
		fee.setRepairNo(1008);
		fee.setRepairCost(34);
		fee.setMaterialCost(67);
		Date date=new Date(116,10,24);
		fee.setAttention("buad");
		fee.setWarranty("dsjjdjd");
		fee.setClearTime(date);
		service.addFee(fee);
	}

}
