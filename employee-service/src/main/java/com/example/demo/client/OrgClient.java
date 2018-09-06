package com.example.demo.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.dto.OrganizationDTO;


@FeignClient(name="org-service")
@RibbonClient
public interface OrgClient {
	
	@GetMapping("/{id}")
	OrganizationDTO findById(@PathVariable("id") Long id);

	@GetMapping("/org/{name}")
	Long findByName(@PathVariable("name") String name);
	
	
	
	

}
