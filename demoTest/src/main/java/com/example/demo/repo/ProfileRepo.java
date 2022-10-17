package com.example.demo.repo;

import java.util.List;

import com.example.demo.entity.Profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface ProfileRepo extends JpaRepository<Profile,Integer>{

	
	
}
