package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * http://localhost:8080/ で動く
 * @author user1
 */
@RestController
public class ControllerA {
	@GetMapping
	public int getA() {
		return methodB();
	}


	private static int methodB() {
		ClassA a = new ClassA();
		a.i += 1;
		return a.i;
	}
	
	private static class ClassA{
		public int i = 5;
	}
}
