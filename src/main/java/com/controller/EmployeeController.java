package com.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.entity.Employee;
import com.service.IEmployeeService;
import com.validator.EmployeeValidator;


@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService ser;
	@Autowired 
	private EmployeeValidator validator;
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	@GetMapping("/show_employee_report")// All data will show here
	public String findAllEmp(Map<String,Object> mp){
		
		Iterable<Employee> allEmpolyee = ser.getAllEmpolyee();
		mp.put("emplist", allEmpolyee);
		
		return "show_employee_report";
		
	}
	
	
	@GetMapping("/emp_add")// form will open here
	public String register(@ModelAttribute("emp") Employee e) {
		return "emp_register";
	}
	
	
	
	@PostMapping("/emp_add")// Employee Data will Insert here
	public String saveEmployee(@ModelAttribute("emp") Employee e, Map<String,Object> mp,RedirectAttributes rattr,BindingResult error) {
		
		if(validator.supports(Employee.class)) {
			validator.validate(e, error);
			
			if(error.hasErrors()) {
				System.out.println(error.getObjectName());
				return "emp_register";
			}
		}
			
		
		String register = ser.register(e);
		System.out.println(register);
		rattr.addFlashAttribute("result", "Registerd");
		
		return "redirect:show_employee_report";
	}
	
	@GetMapping("/emp_edit")
	public String getByid(@RequestParam int id,@ModelAttribute("emp") Employee emp) {
		Employee empdata= ser.getByid(id);
		 
		BeanUtils.copyProperties(empdata, emp);
		
		return "emp_update";
	}
	
	
	@PostMapping("/emp_edit")
	public String update(@ModelAttribute Employee e,RedirectAttributes rattr) {
		
		rattr.addFlashAttribute("result", "Employee Update SuccessFully" );
		ser.register(e);
		return "redirect:show_employee_report";
		
	}
	
	
	@GetMapping("/emp_delete")
	public String deleteByIdEmployee(@RequestParam int id,RedirectAttributes rattr ) {
		rattr.addFlashAttribute("result", "Employee Deleted SuccessFully" );
		ser.deleteById(id);
		return "redirect:show_employee_report";
	}
	
	@GetMapping("/search")
	public String srech() {
		return "search";
	}
	
	
	
	@SuppressWarnings("finally")
	@PostMapping("/search")
	public String serachById(@RequestParam(required = false) String name,@ModelAttribute("emp") Employee e) {
		System.out.println("EmployeeController.serachById()");
		
		try {
			int id = Integer.parseInt(name);
			
			BeanUtils.copyProperties(ser.getByid(id), e);
		}
		catch (Exception e1) {
			
			
			BeanUtils.copyProperties(ser.findByName(name), e);
			
		      System.out.println(e);
			
		}
		
		finally {
			return "emp_update";
		}
		
		
	}
	
	
	
	
}
