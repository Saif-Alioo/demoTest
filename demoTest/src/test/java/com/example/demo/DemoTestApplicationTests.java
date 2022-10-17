package com.example.demo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import com.example.demo.entity.Profile;
//import com.example.demo.entity.Profile;
import com.example.demo.repo.ProfileRepo;
import com.example.demo.service.ProfileService;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.h2.command.dml.MergeUsing.When;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
class DemoTestApplicationTests {

//	
//	 @Test
//	   public void testUserName() {
//		   Profile pro=new Profile(1,"Jhon",23);
//		  assertEquals("Jhon", pro.getName());
//	   }
//	 
//	@Test
//	public void testEnterAge() {
//		Profile pro=new Profile(1,"Jhon",23);
//		assertEquals(23, pro.getAge());
//	}
}
