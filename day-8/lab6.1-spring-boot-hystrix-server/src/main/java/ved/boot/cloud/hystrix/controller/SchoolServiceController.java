package ved.boot.cloud.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ved.boot.cloud.hystrix.delegate.StudentServiceDelegate;

@RestController
public class SchoolServiceController {

	@Autowired
	StudentServiceDelegate studentServiceDelegate;

	@GetMapping(value = "/getSchoolDetails/{schoolname}")
	public String getStudents(@PathVariable String schoolname) {
		
		System.out.println("Going to call student service to get data!");
		
		return studentServiceDelegate.callStudentServiceAndGetData(schoolname);
	}

}
