package com.example.demo;

import org.springframework.stereotype.Component;

@Component("employee")
//@Scope("prototype")
//@Scope("singelton")
public class Employee {

	void print() {
		System.out.println("name is priniting method >> " );
	}

}
