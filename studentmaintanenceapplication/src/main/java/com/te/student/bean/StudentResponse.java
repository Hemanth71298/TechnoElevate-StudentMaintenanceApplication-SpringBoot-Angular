package com.te.student.bean;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("student_response")
@JsonPropertyOrder({ "statusCode", "msg" })
@JsonInclude(JsonInclude.Include.NON_NULL)


public class StudentResponse implements Serializable{
	private int statusCode;

	private String msg;

	private String description;

	@JsonProperty("User")
	private StudentBean bean;
	
	@JsonProperty("User")
	private List<StudentBean>  StudentBeans;


}
