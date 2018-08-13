package com.javatechie.spring.couchbase.example.model;

import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	@Id
	@Field
	private int id;
	@Field
	private String name;
	@Field
	private String[] address;
}
