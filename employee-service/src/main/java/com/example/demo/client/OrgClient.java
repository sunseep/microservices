package com.example.demo.client;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.retry.annotation.Backoff;
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
