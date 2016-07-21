package Dao;

import domain.Customer;

import java.util.List;

public interface CustomerDaoInterface {
	public void addCustomer(Customer customer);
	public void deleteCustomer(String[] customerNoList);
	public List<Customer> findAllcustomerList();
	public Customer findcustomerByNo(int customerNo);
	public void updatecustomer(Customer customer);
}
