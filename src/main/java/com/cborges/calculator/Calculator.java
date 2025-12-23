package com.cborges.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.stereotype.Service;

// @SpringBootApplication
// public class Calculator {

// 	public static void main(String[] args) {
// 		SpringApplication.run(Calculator.class, args);
// 	}

// }

@Service
public class Calculator {

	public int sum(int a, int b) {
		return a + b;
	}

	// public double subtract(double a, double b) {
	// 	return a - b;
	// }

	// public double multiply(double a, double b) {
	// 	return a * b;
	// }

	// public double divide(double a, double b) {
	// 	if (b == 0) {
	// 		throw new IllegalArgumentException("Division by zero is not allowed.");
	// 	}
	// 	return a / b;
	// }
}