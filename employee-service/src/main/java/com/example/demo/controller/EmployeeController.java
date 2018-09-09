package com.example.demo.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.OrgClient;
import com.example.demo.client.OrgService;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.OrganizationDTO;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;


@RestController
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeRepository repository;
	
	@Autowired
	OrgClient orgClient;
	
	@Autowired
	OrgService service;
	
	@PostMapping("/")
	public Employee add(@RequestBody EmployeeDTO employee) throws Exception {
		LOGGER.info("Employee add: {}", employee);
		Long id=service.findByName(employee.getOrg().getOrgName());
		Employee emp=new Employee(id,employee.getName());
		return repository.save(emp);
	}
	
	@GetMapping("/{id}")
	public EmployeeDTO findById(@PathVariable("id") Long id) {
		LOGGER.info("Employee find: id={}", id);
		Optional<Employee> emp=repository.findById(id);
		if(emp.isPresent())
		{
			Employee empIn=emp.get();
			OrganizationDTO orgDto=orgClient.findById(empIn.getOrganizationId());
			LOGGER.info("orgDto.name", orgDto.getOrgName());
			EmployeeDTO empDTO = null;
			if(orgDto != null)
			{
				empDTO=new EmployeeDTO(empIn.getName(),orgDto);
			}
			return empDTO;
		}
		return null;
	}
	
	
	
}
