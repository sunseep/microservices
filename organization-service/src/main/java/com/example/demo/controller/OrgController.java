package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Organization;
import com.example.demo.model.dto.OrganazationDTO;
import com.example.demo.repository.OrgRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
@Component
public class OrgController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrgController.class);
	
	@Autowired
	OrgRepository repository;
	
	@PostMapping("/")
	public Organization add(@RequestBody Organization org) {
		LOGGER.info("Employee add: {}", org);
		return repository.save(org);
	}
	
	@GetMapping("/{id}")
	public OrganazationDTO findById(@PathVariable("id") Long id) {
		LOGGER.info("Org find: id={}", id);
		Optional<Organization> org=repository.findById(id);
		if(org.isPresent())
		{
			LOGGER.info("Org name={}", org.get().getName());
			return new OrganazationDTO(org.get().getName());
		}
		return null;
	}
	
	@GetMapping("/org/{name}")
	@HystrixCommand(fallbackMethod = "reliable")
	public Long findByName(@PathVariable("name") String name) throws Exception
	{
//		LOGGER.info("Org find: id={}", name);
//		List<Organization> org=repository.findByName(name);
//		if(org != null && !org.isEmpty())
//			return org.get(0).getOrganizationId();
//		else
//		{
//			Organization org2=add(new Organization(name));
//			if(org2 != null)
//			{
//				return org2.getOrganizationId();
//			}
//		}
//		return null;
		throw new Exception();
	}
	
	 public Long reliable(String msg) {
		    return new Long(1);
	 }
	
}
