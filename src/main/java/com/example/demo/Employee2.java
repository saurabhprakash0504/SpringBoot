package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("employees")
public class Employee2 {
	@Autowired
	Employee e;
	
	void print() {
		System.out.println("Emplyee2 >>> "+e.hashCode());
	}
}
