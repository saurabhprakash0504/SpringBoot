package com.example.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @Controller
public class HomeController {

	@Autowired
	@Qualifier("employee")
	Employee e;

	@Autowired
	Employee2 e2;

	@RequestMapping("/allRecords")
	@Produces("application/xml")
	public List<Student> allRecords() {
		System.out.println("homeCOntroller >>> " + e.hashCode());
		e2.print();
		e.print();
		List<Student> l = new ArrayList<>();
		l.add(new Student("saurabh", 2, "don bosco"));
		l.add(new Student("prakash", 4, "st joesph"));
		return l;
	}

	@RequestMapping("/StudentById")
	@Produces(MediaType.APPLICATION_XML)
	public Student getStudentById(@QueryParam("id") int id) {
		List<Student> l = new ArrayList<>();
		l.add(new Student("saurabh", 2, "don bosco"));
		l.add(new Student("prakash", 4, "st joesph"));

		Student s = new Student();
		Iterator<Student> i = l.iterator();
		while (i.hasNext()) {
			Student ii = i.next();
			if (ii.id == id) {
				s.setId(id);
				s.setName(ii.getName());
				s.setSchool(ii.getSchool());
			}
		}

		return s;
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@RequestMapping("/updateData/{id}")
	ResponseEntity<Student> updateStudent(@PathVariable int id){
		List<Student> l = new ArrayList<>();
		l.add(new Student("saurabh", 2, "don bosco"));
		l.add(new Student("prakash", 4, "st joesph"));
		Student s = new Student();
		Iterator<Student> i = l.iterator();
		while (i.hasNext()) {
			Student ii = i.next();
			if (ii.id == id) {
				s.setId(id);
				s.setName("HIMICA");
				s.setSchool(ii.getSchool());
			}
		}

		ResponseEntity<Student> ss=new ResponseEntity<>(s,HttpStatus.FOUND);
		return ss;


	}
	/*{
	    "name": "saurabh",
	    "id": 2,
	    "school": "don bosco"
	}*/
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@RequestMapping("/updateStudentWithBody")
	ResponseEntity<Student> updateStudentWithBody(@RequestBody Student ss){
		
		Student s=new Student();
		s.setName(ss.getName());
		s.setId(555);
		s.setSchool(ss.getSchool());

		ResponseEntity<Student> sss=new ResponseEntity<>(s,HttpStatus.FOUND);
		return sss;


	}


	
}
