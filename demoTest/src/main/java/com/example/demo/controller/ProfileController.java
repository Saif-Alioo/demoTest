package com.example.demo.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.demo.entity.Profile;
import com.example.demo.exception.customException;
import com.example.demo.repo.ProfileRepo;
import com.example.demo.service.ProfileService;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import antlr.StringUtils;
import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j
@RequestMapping("/tata")
public class ProfileController {
	
	@Autowired
	private ProfileService service;
	
  //Add New Profile in to Database.
//	@PostMapping("/add")
//	public ResponseEntity<String> addProfile(@Valid @RequestBody  Profile profile)
//	{
//		
//	   service.addProfile(profile);
//	   log.info("New profile is added.");
//	   return ResponseEntity.ok("Profile is Added");
//	}
	
	
	@PostMapping("/upload")
	public String saveProfile(@RequestParam("file") MultipartFile file, @RequestParam String name, @RequestParam int proId) throws IOException {
		service.uploadProfile(proId, name, file);
		return "Prolife added";
	}
	
	//Get The all the Profiles
	@GetMapping("/profiles")
	public List<Profile> findAllProfiles(){
		log.info("Getting Profile...");
		return service.getProfiles();
	}
	
	//Get the Profile by Using Profile Id.
	@GetMapping("/profiles/{id}")
	public String findProfileById(@PathVariable ("id")int id) throws customException {
		log.info("Getting Profilename by Id...");
	    service.getProfileById(id);
	    return "Profile found";
	}
	
	//Update the Profile name by using profile Id.
    @PutMapping("/update/{id}")
    
	public Profile updateProfile(@PathVariable ("id")int id , @RequestBody Profile profile) throws customException {
    	log.info("Update Profile by using Id...");
		return service.updateProfile(id,profile);
		
	}
	
    //Delete the Profile using Id.
	@DeleteMapping("/delete/{id}")
	public String deleteProfile(@PathVariable ("id")int id) {
		log.info("Profile is deleted...");
		return service.deleteProfile(id);
	}
	
	
	
	
	


}
