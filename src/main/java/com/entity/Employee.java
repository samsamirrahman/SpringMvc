package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Data
@SQLDelete(sql ="update employee set STATUS='DEACTIVE' where empid=?" )
@Where(clause = "STATUS <> 'DEACTIVE' ")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer empid;
	@Column(length = 20)
	private String ename;
	@Column(length = 20)
	private String job;
	private Float sal;
	private Integer dep;
	private String STATUS="active";
	
	

}
