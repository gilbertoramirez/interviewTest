package com.solutions.coherent.interviewTest;

import com.solutions.coherent.interviewTest.util.DbMemoryUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class InterviewTestApplication{


	public static void main(String[] args) {
		SpringApplication.run(InterviewTestApplication.class, args);
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				DbMemoryUtil.setRecords();
			}
		}));
	}
}
