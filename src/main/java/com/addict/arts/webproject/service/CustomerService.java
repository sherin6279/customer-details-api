package com.addict.arts.webproject.service;

import com.addict.arts.webproject.model.Customer;
import com.addict.arts.webproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	public void addCustomer(Customer customer) {
		customerRepo.save(customer);
	}
	
	public Customer getCustomer(int id) {
		return customerRepo.findById(id).orElseThrow(() -> new RuntimeException("error"));
	}

	public List<Customer> getAllCustomers() {
		List<Customer> customerList = StreamSupport.stream(customerRepo.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return customerList;
	} 
	
	public void updateCustomer(Customer customer) {	
		Customer user = customerRepo.findById(customer.getId())
				.orElseThrow(() -> new RuntimeException(
						String.format("Cannot find customer Id %s", customer.getId())));
		user.setAge(customer.getAge()==0 ? user.getAge(): customer.getAge());
		user.setGender((customer.getGender() != null)? customer.getGender(): user.getGender());
		user.setName((customer.getName() != null)? customer.getName(): user.getName());
		user.setPhNumber(customer.getPhNumber()==0 ? user.getPhNumber(): customer.getPhNumber());
		user.setEmailId((customer.getEmailId() != null)? customer.getEmailId(): user.getEmailId());
		user.setBookedDate((customer.getBookedDate() != null)? customer.getBookedDate(): user.getBookedDate());
		customerRepo.save(user);
	}
	
	public void deleteCustomer(int customerId) {
		customerRepo.deleteById(customerId);
	}

}
