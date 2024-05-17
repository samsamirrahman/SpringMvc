package com.reposetry;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.Employee;

@Repository
public interface IEmployeeReposetry extends CrudRepository<Employee,Integer>{
	
	public Employee findByename(String name);
	

}
