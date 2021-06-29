package com.te.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.student.bean.StudentBean;
import com.te.student.bean.StudentResponse;
import com.te.student.service.StudentService;


@RestController
public class StudentController {
	@Autowired
    private StudentService service;
	
	@GetMapping(path = "/getUser", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	
	public StudentResponse getUser(int id) {
		StudentBean studentBean = service.getUser(id);
		StudentResponse studentResponse = new StudentResponse();
		if (studentBean != null) {
			studentResponse.setStatusCode(200);
			studentResponse.setMsg("success");
			studentResponse.setDescription(" Data found for id : " + id);
			studentResponse.setBean(studentBean);
		} else {
			studentResponse.setStatusCode(404);
			studentResponse.setMsg("failure");
			studentResponse.setDescription("Error Data Not found for id:"+id);
		}
		return studentResponse;
	}//End of get User
	
	@PostMapping(path = "/insert", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public StudentResponse addUser(@RequestBody StudentBean studentBean) {
		StudentResponse response = new StudentResponse();
		if (service.addUsers(studentBean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Inserted Successfully");
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Something Went Wrong");
		}
		return response;
	}//add
	
	@GetMapping(path = "/search", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public StudentResponse getAll() {
		StudentResponse response = new StudentResponse();
		List<StudentBean> studentBeans = service.getAllUser();
		if (studentBeans != null) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Student details found");
			response.setStudentBeans(studentBeans);
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Details Not found");
		}
		return response;
	}//Search
	
	@DeleteMapping(path = "/Remove/{Userid}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public StudentResponse removeUser(@PathVariable(name = "Userid") int id) {
		StudentResponse response = new StudentResponse();
		if (service.deleteUserData(id)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription(" Data Deleted for id : " + id);
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription(" Data Not for id : " + id);
		}

		return response;
	}//delete
	
	@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public StudentResponse updateEmp(@RequestBody StudentBean bean) {
		System.out.println(bean);
		StudentResponse response = new StudentResponse();
		if (service.updateUser(bean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Added Successfully");
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Something Went Wrong");
		}
		return response;
	}


}
