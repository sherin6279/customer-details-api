package com.addict.arts.webproject.controller;

import java.util.List;

import com.addict.arts.webproject.model.Customer;
import com.addict.arts.webproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable int id) {
		return customerService.getCustomer(id);
	}
	
	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
		return customer;
	};
	
	@RequestMapping(value= "/all")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	@PutMapping
	public ResponseEntity updateCustomer(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteCustomer(@PathVariable int id) {
		customerService.deleteCustomer(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
