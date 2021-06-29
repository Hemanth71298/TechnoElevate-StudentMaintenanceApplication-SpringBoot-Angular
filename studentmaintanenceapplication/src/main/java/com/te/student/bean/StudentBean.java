package com.te.student.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Entity
@Table(name = "Users")
@JsonRootName("Users")
@JsonPropertyOrder({ "Userid","Email","Marks" ,"name","Grade" })
@XmlRootElement(name="User")


public class StudentBean implements Serializable{
	@Id
	@Column
	@JsonProperty("Userid")
	private Integer Userid;
	private String Email;
	private double Marks;
	private String Name;
	private String Grade;
	


}
