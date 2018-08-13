package com.javatechie.spring.couchbase.example.controller;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.couchbase.example.model.Customer;
import com.javatechie.spring.couchbase.example.repository.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository repository;

	@PostConstruct
	public void addCustomer() {
		repository.saveAll(Stream.of(new Customer(123, "Basant", new String[] { "Bangalore" }),
				new Customer(321, "Santosh", new String[] { "Pune" }),
				new Customer(999, "Shiva", new String[] { "Mumbai" })).collect(Collectors.toList()));
	}

	@GetMapping("/getAllCustomers")
	public Iterable<Customer> getCustomers() {
		return repository.findAll();
	}

	@DeleteMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable int id) {
		repository.deleteById(id);
		return "customer deleted with id : " + id;
	}

}
