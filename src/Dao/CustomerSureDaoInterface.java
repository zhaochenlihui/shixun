package Dao;

import java.util.List;

import domain.CustomerSure;

public interface CustomerSureDaoInterface {
	public void addCustomerSure(CustomerSure customerSure);
	public CustomerSure findcustomerSureByNo(int repairNo);
	public List<CustomerSure> findCustomerSure(CustomerSure u);
		
}
