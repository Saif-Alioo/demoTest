package com.example.demo.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List; 
import java.util.Optional;

import com.example.demo.entity.Profile;
import com.example.demo.exception.customException;

import com.example.demo.repo.ProfileRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class ProfileService {
	@Autowired
	private ProfileRepo repository;
	
	//Add Profile method.
//	public Profile addProfile(Profile profile)
//    {
//    	return repository.save(profile);
//    }
//	
	
	 public void uploadProfile(int proid ,String name, MultipartFile file) throws IOException
	    {
		 
		    Profile profile=new Profile();
		    String fileName=file.getOriginalFilename();
		    if(fileName.contains("..")) {
		    	System.out.println("Not a valid File");
		    }
	    	profile.setProid(proid);
	    	profile.setName(name);
	    	profile.setImage(file.getBytes());
	    	repository.save(profile);
	    }
	 

    //Get profile method.
    public List<Profile> getProfiles(){
   	 return repository.findAll();
    }
    
    //Get Profile by using profile Id.
    public Optional<Profile> getProfileById(int id) throws customException{
   	  repository.findById(id).orElseThrow(()->new customException("Desired Id is not present in database"));
   	  return repository.findById(id);
    }
    
    //Delete profile by using Profile Id
   public String deleteProfile(int id) {
	   repository.deleteById(id);
	   return "Profile is deleted";
   }
   
 //Update the profile.
   public Profile updateProfile(int id ,Profile profile) throws customException {
	   Profile updateProfile=repository.findById(id).orElseThrow(()->new customException("Profile not found"));
	   updateProfile.setName(profile.getName());
	   return repository.save(updateProfile);
   }
   
   
	
   
}
