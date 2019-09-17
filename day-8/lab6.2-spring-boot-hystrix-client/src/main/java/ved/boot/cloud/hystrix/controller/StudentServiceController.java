package ved.boot.cloud.hystrix.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ved.boot.cloud.hystrix.domain.Student;

@RestController
public class StudentServiceController {

	private static Map<String, List<Student>> schooDB = new HashMap<String, List<Student>>();

	static {
		schooDB = new HashMap<String, List<Student>>();

		List<Student> lst = new ArrayList<Student>();

		Student std = new Student("Sprint Boot", "O'Raily !!!");
		lst.add(std);

		std = new Student("Micro-Services", "O'Raily !!!");
		lst.add(std);

		schooDB.put("Hindustan College", lst);

		std = new Student("Java", "Manning !!!");
		lst.add(std);

		std = new Student("Robotics", "Manning !!!");
		lst.add(std);

		schooDB.put("Learning", lst);	
	}

	@GetMapping(value = "/getSchoolDetails/{schoolname}")
	public List<Student> getStudents(@PathVariable String schoolname) {

		System.out.println("Getting Student details for " + schoolname);

		List<Student> studentList = schooDB.get(schoolname);
		
		if (studentList == null) {
			studentList = new ArrayList<Student>();
			Student std = new Student("Not Found", "N/A");
			studentList.add(std);
		}
		
		return studentList;
	}
}
