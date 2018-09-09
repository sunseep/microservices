package com.example.demo.client;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class OrgService {
	 private static final Logger LOGGER = LoggerFactory.getLogger(OrgService.class);
	@Autowired
	OrgClient orgClient;
	 private static int COUNTER = 0;


	@Retryable(value = {Exception.class}, maxAttempts = 3, backoff = @Backoff(delay = 2000, multiplier=2))
	public Long findByName(String orgName) throws Exception {
		Long id;
		if(COUNTER == 0)
		{
			LOGGER.info("COUNTER"+COUNTER++);
			throw new Exception();
		}
		else if(COUNTER == 1)
		{
			LOGGER.info("COUNTER"+COUNTER++);
			throw new Exception();
		}
		else
		{
			 id= orgClient.findByName(orgName);
		}
		return id;
	}
	
	

}
