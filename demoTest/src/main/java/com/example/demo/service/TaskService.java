package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Profile;
import com.example.demo.entity.Task;
import com.example.demo.repo.ProfileRepo;
import com.example.demo.repo.TaskRepo;

@Service
public class TaskService {

	@Autowired
	private TaskRepo repository;
	
    //Get all tasks
    public List<Task> getTasks(){
   	 return repository.findAll();
    }
    
    //Get tasks by using task id
    public Optional<Task> getTaskById(int id){
   	 return repository.findById(id);
    }
    
    //Add task
    public Task addTask(Task task)
    {
    	return repository.save(task);
    }
    public String deleteTask(int id) {
		repository.deleteById(id);
		return "Task Deleted";
	}
    //Get task by profile id
    public List<Task> getTaskByProfileId(int pid){
    	List<Task> list=repository.findByProfileId(pid);
    	return list;
    	
    }
    //Update task
    public Task updateTask(int id,Task task) {
    	Task updateTask=repository.findById(id).orElse(null);
    	updateTask.setTaskName(task.getTaskName());
    	updateTask.setStartTime(task.getStartTime());
    	updateTask.setEndTime(task.getEndTime());
    	updateTask.setTaskdec(task.getTaskdec());
    	return repository.save(updateTask);
    }
    
}
