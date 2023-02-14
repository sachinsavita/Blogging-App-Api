package com.blogapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blogapp.repos.UserRepo;

@SpringBootTest
class BlogAppApisApplicationTests {
	
	@Autowired
	private UserRepo userRepo;

	@Test
	void contextLoads() {
	}
	
	
	//This test is to show how @Autowired annotation create proxy package and class of an interface
	//in this case UserRepo interface we autowired and tested it and find 
	//jdk.proxy2.$Proxy103   (Class)
	//jdk.proxy2     (Package)
	@Test
	void userRepoTest() {
		
		String className = this.userRepo.getClass().getName();
		String packageName = this.userRepo.getClass().getPackageName();
		
		System.out.println(className);
		System.out.println(packageName);
	}

}
