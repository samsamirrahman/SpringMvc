package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Employee;
import com.reposetry.IEmployeeReposetry;
@Service
public class EmpolyeeImpService implements IEmployeeService{

	@Autowired
	private IEmployeeReposetry repo;
	
	@Override
	public Iterable<Employee> getAllEmpolyee() {
		
		return repo.findAll();
	}

	@Override
	public String register(Employee e) {
		
		return "Register"+repo.save(e);
	}

	@Override
	public Employee getByid(int id) {
		Optional<Employee> findById = repo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		else {
			throw new RuntimeException("Empolyee  Data not find");
		}
		
	}

	@Override
	public void deleteById(int id) {
		
		repo.deleteById(id);
		
	}

	@Override
	public Employee findByName(String name) {
		// TODO Auto-generated method stub
		Employee findByename = repo.findByename(name);
		System.out.println(findByename);
		return findByename;
	}
	

	

}
