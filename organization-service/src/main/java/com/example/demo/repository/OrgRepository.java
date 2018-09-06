package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Organization;
import java.lang.String;
import java.util.List;


public interface OrgRepository extends JpaRepository<Organization, Long>{
	
	List<Organization> findByName(String name);

}
