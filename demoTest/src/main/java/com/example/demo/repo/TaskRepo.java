package com.example.demo.repo;

import java.util.List;

//import com.example.demo.entity.Profile;
import com.example.demo.entity.Task; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

	@Query("from Task where proid = ?1")
	List <Task> findByProfileId(int id);

}
