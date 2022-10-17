package com.example.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;

//import com.example.demo.entity.FileResponse;
import com.example.demo.entity.Profile;
import com.example.demo.entity.Task;

import com.example.demo.service.TaskService;

@RestController
@Slf4j
@RequestMapping("/task")
public class TaskController {
	@Autowired
	private TaskService service;
    private Profile profile;
  
   
    //Post method for adding new task
    @PostMapping("/add")
	public ResponseEntity<String> addNewTask(@Valid@RequestBody Task task)
	{
	   service.addTask(task);
	   log.info("New task is added.");
	   return ResponseEntity.ok("Task is valid");
	}
	
	//Getting all tasks
	@GetMapping("/tasks")
	public List<Task> findAllProfiles(){
		log.info("Retriving All tasks.");
		return service.getTasks();
	}
	
    //Task details by using profile Id
	@GetMapping("/custom/{proid}")
	public List<Task> findTaskByProIds(@PathVariable int proid){
		log.info("Finding task details by using Profile ID.");
		return service.getTaskByProfileId(proid);
	}
 
	//Put mapping to update the task
	@PutMapping("update/{id}")
	public Task updateTask(@PathVariable ("id")int taskid,@RequestBody Task task) {
		log.info("Updating task details by using task ID.");
		return service.addTask(task);	
	}
	
	//Delete the task by using task id
	@DeleteMapping("/delete/{id}")
	public String deleteTask(@PathVariable ("id")int id) {
		log.info("Delete the tasks using task ID.");
		return service.deleteTask(id);
	}
	
	//Downloading the data in csv  
  
	@GetMapping("/exportCsv/{id}")
    public void exportToCCV(HttpServletResponse response,@PathVariable ("id") int id) throws IOException {
	
	response.setContentType("text/csv");
	String fileName="task.csv";
	
	String headerKey="Content-Disposition";
	String headerValue="attachment;filename" + fileName;
	
	response.setHeader(headerKey, headerValue);
	
	
	List<Task> listTask=service.getTaskByProfileId(id);
	
	ICsvBeanWriter csvWriter=new CsvBeanWriter(response.getWriter(),CsvPreference.STANDARD_PREFERENCE);
	
	String [] csvHeader= {"Task Id" ,"Task Name","Start Time","End Time","Task Desc","Date"};
	String [] nameMapping= {"taskid","taskName","startTime","endTime","taskdec","Date"};
	
	csvWriter.writeHeader(csvHeader);
	for(Task task:listTask) {
		csvWriter.write(task, nameMapping);
	}
	csvWriter.close();
}

}
