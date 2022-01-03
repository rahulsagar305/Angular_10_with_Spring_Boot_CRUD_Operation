package com.crud.rs;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootCrudRsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudRsApplication.class, args);
	}
	
	@GetMapping("/")
	public void defaultService(HttpServletResponse servletResponse) throws Exception {

		servletResponse.getWriter().write("<b>API Version 1.1 Started Successfully</b>");
	}
}
