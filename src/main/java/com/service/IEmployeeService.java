package com.service;



import com.entity.Employee;

public interface IEmployeeService {

	public Iterable<Employee> getAllEmpolyee();
	
	public String register(Employee e);
	
	public Employee getByid(int id);
	
	public void deleteById(int id);
	
	public Employee findByName(String name);
	
}
