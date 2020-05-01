package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// autowire the CustomerService
	@Autowired
	private CustomerService customerService;

	// add mapping for GET /customers
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}

	@GetMapping("/customers/{customerId}")
	public Customer getCustomerById(@PathVariable int customerId) {
		Customer customer = customerService.getCustomer(customerId);
		if (customer == null) {
			throw new CustomerNotFoundException("Customer Id not found : " + customerId);
		}
		return customer;
	}

	@PostMapping("/customers")
	public Customer saveCustomer(@RequestBody Customer customer) {
		customer.setId(0);

		customerService.saveCustomer(customer);

		return customer;
	}

	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {

		Customer customerExists = customerService.getCustomer(customer.getId());
		if (customerExists == null) {
			throw new CustomerNotFoundException("Update Operation Failed. Customer Id not found : " + customer.getId());
		}

		customerService.saveCustomer(customer);

		return customer;
	}

	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {

		Customer customerExists = customerService.getCustomer(customerId);
		if (customerExists == null) {
			throw new CustomerNotFoundException("Delete Operation Failed. Customer Id not found : " + customerId);
		}

		customerService.deleteCustomer(customerId);

		return "Delete Successful for Customer Id : " + customerId;
	}

}
